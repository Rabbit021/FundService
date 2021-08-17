package com.rabbit.fundservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rabbit.fundservice.data.FundMNDetailInformation;
import com.rabbit.fundservice.data.FundMNUniqueInfo;
import com.rabbit.fundservice.data.TianTianConfig;
import org.dom4j.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import sun.util.locale.provider.LocaleServiceProviderPool;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangheng
 * 数据爬取
 */
@Component
public class SpiderService {
    private static final Logger logger = LoggerFactory.getLogger(SpiderService.class);
    @Autowired
    WebManger webManger;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    TianTianConfig tianConfig;

    public FundMNDetailInformation GetFundMNDetailInformation(String code) {
        String fun = "/FundMNewApi/FundMNDetailInformation";
        FundMNDetailInformation information = GetTiantianDatas(fun, code, FundMNDetailInformation.class);
        return information;
    }

    public FundMNUniqueInfo PostFundMNUniqueInfo(String code) {
        String fun = "/FundMNewApi/FundMNUniqueInfo";
        FundMNUniqueInfo uniqueInfo = PostTianTianDatas(fun, code, FundMNUniqueInfo.class);
        return uniqueInfo;
    }

    /**
     * 获取返现类型转换
     *
     * @param path
     * @param code
     * @param tClass
     * @param <T>
     * @return
     */
    private <T> T GetTiantianDatas(String path, String code, Class<T> tClass) {
        try {
            Map<String, String> query = getQueryMap(code);
            String queryString = query.entrySet().stream().map(x -> x.getKey() + "=" + x.getValue()).collect(Collectors.joining("&"));
            String url = tianConfig.Api + path + "?" + queryString;

            String json = webManger.getString(url);
            JsonNode root = objectMapper.readValue(json, JsonNode.class);
            JsonNode datas = root.get("Datas");
            return objectMapper.treeToValue(datas, tClass);

        } catch (Exception ex) {
            return null;
        }
    }

    private <T> T PostTianTianDatas(String path, String code, Class<T> tClass) {
        try {
            Map<String, String> query = getQueryMap(code);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            query.entrySet().forEach(x -> map.add(x.getKey(), x.getValue()));

            String url = tianConfig.Api + path;
            String json = webManger.postString(url, map);

            JsonNode root = objectMapper.readValue(json, JsonNode.class);
            JsonNode datas = root.get("Datas");
            return objectMapper.treeToValue(datas, tClass);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return null;
        }
    }

    private Map<String, String> getQueryMap(String code) {
        Map<String, String> query = new LinkedHashMap<>();
        query.put("FCODE", code);
        query.put("AppVersion", tianConfig.AppVersion);
        query.put("deviceid", tianConfig.deviceid);
        query.put("plat", tianConfig.plat);
        query.put("product", tianConfig.product);
        query.put("version", tianConfig.version);
        return query;
    }
}

