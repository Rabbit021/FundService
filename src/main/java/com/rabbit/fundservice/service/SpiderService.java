package com.rabbit.fundservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.fundservice.data.FundMNDetailInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangheng
 * 数据爬取
 */
@Component
public class SpiderService {
    @Autowired
    WebManger webManger;
    @Autowired
    ObjectMapper objectMapper;

    /// <summary>
    /// 获取基金概况
    /// </summary>
    public FundMNDetailInformation GetFundMNDetailInformation(String code) {
        String fun = "/FundMNewApi/FundMNDetailInformation";
        FundMNDetailInformation information = GetTiantianDatas(fun, code, FundMNDetailInformation.class);
        return information;
    }

    private <T> T GetTiantianDatas(String path, String code, Class<T> tClass) {
        try {
            HashMap<String, String> query = new HashMap<String, String>();
            query.put("FCODE", code);
            String url = GetUrl(path, query);
            String json = webManger.getString(url);
            JsonNode root = objectMapper.readValue(json, JsonNode.class);
            JsonNode datas = root.get("Datas");
            return objectMapper.treeToValue(datas, tClass);
        } catch (Exception ex) {
            return null;
        }
    }


    /// <summary>
    /// 获取请求路径
    /// </summary>
    /// <param name="path"></param>
    /// <param name="query"></param>
    /// <returns></returns>
    protected String GetUrl(String path, Map<String, String> query) {
        String fundapi = "https://fundmobapi.eastmoney.com";
        String queryString = query.entrySet().stream().map(x -> String.join(x.getKey(), "=", x.getValue())).collect(Collectors.joining("&"));
        return String.join(fundapi, path, "?", queryString);
    }
}

