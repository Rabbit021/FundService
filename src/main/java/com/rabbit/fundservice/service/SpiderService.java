package com.rabbit.fundservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.rabbit.fundservice.config.TianTianConfig;
import com.rabbit.fundservice.data.FundMNAssetAllocationNew;
import com.rabbit.fundservice.data.FundMNDetailInformation;
import com.rabbit.fundservice.data.FundMNInverstPosition;
import com.rabbit.fundservice.data.FundMNUniqueInfo;
import com.rabbit.fundservice.data.Fundbood;
import com.rabbit.fundservice.data.Fundstock;
import com.rabbit.fundservice.utils.JsonManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author wangheng 数据爬取
 */
@Component
public class SpiderService {

  private static final Logger logger = LoggerFactory.getLogger(SpiderService.class);
  private final WebManger webManger;
  private final TianTianConfig tianConfig;

  public SpiderService(WebManger webManger, TianTianConfig tianConfig) {
    this.webManger = webManger;
    this.tianConfig = tianConfig;
  }

  /**
   * 获取基本信息
   */
  public FundMNDetailInformation getFundMNDetailInformation(String code) {
    String fun = "/FundMNewApi/FundMNDetailInformation";
    JsonNode jsonNode = getTiantianData(fun, code);
    return JsonManager.toObject(jsonNode, FundMNDetailInformation.class);
  }

  /**
   * 获取基金特有数据
   */
  public FundMNUniqueInfo getFundMNUniqueInfo(String code) {
    String fun = "/FundMNewApi/FundMNUniqueInfo";
    JsonNode jsonNode = postTianTianData(fun, code);
    return JsonManager.toObject(jsonNode, FundMNUniqueInfo.class);
  }

  /**
   * 最新持仓的比例
   */
  public FundMNAssetAllocationNew getFundMNAssetAllocationNew(String code) {
    String fun = "/FundMNewApi/FundMNAssetAllocationNew";
    JsonNode jsonNode = getTiantianData(fun, code);
    ArrayList<FundMNAssetAllocationNew> rst = JsonManager.toObject(jsonNode, ArrayList.class, FundMNAssetAllocationNew.class);
    Optional<FundMNAssetAllocationNew> first = rst.stream().findFirst();
    FundMNAssetAllocationNew result = first.orElse(new FundMNAssetAllocationNew());
    return result;
  }

  /**
   * 获取基金重仓信息
   */
  public FundMNInverstPosition GetFundMNInverstPosition(String code) {
    String fun = "/FundMNewApi/FundMNInverstPosition";
    JsonNode jsonNode = getTiantianData(fun, code);
    FundMNInverstPosition rst = JsonManager.toObject(jsonNode, ArrayList.class, FundMNInverstPosition.class);
    Map<String, Fundstock> fundDict = rst.fundStocks.stream()
        .collect(Collectors.toMap(x -> x.getGpdm(), y -> y));
    Map<String, Fundbood> boodsDict = rst.fundboods.stream()
        .collect(Collectors.toMap(x -> x.getZqdm(), y -> y));
    if (rst.etfcode != null) {
      FundMNAssetAllocationNew postSummary = getFundMNAssetAllocationNew(code);
      double fundPercent = postSummary.fundPercent;
      FundMNInverstPosition etf = GetFundMNInverstPosition(rst.etfcode);
      for (Fundstock itr : etf.fundStocks) {
        itr.jzbl = itr.jzbl * fundPercent / 100;
        Fundstock item = fundDict.putIfAbsent(itr.gpdm, new Fundstock());
        item.jzbl += itr.jzbl;
      }
      for (Fundbood itr : etf.fundboods) {
        {
          itr.zjzbl = itr.zjzbl * fundPercent / 100;
          Fundbood item = boodsDict.putIfAbsent(itr.zqdm, new Fundbood());
          item.zjzbl += itr.zjzbl;
        }
        rst.fundStocks = fundDict.values().stream().collect(Collectors.toList());
        rst.fundboods = boodsDict.values().stream().collect(Collectors.toList());
      }
    }
    return rst;
  }

  /**
   * 获取返现类型转换
   */
  private JsonNode getTiantianData(String path, String code) {
    try {
      Map<String, String> query = getQueryMap(code);
      String queryString = query.entrySet().stream().map(x -> x.getKey() + "=" + x.getValue())
          .collect(Collectors.joining("&"));
      String url = tianConfig.Host + path + "?" + queryString;
      String json = webManger.getString(url);
      return JsonManager.toJsonNode(json, "Datas");
    } catch (Exception ex) {
      return null;
    }
  }

  private JsonNode postTianTianData(String path, String code) {
    try {
      Map<String, String> query = getQueryMap(code);
      MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
      query.forEach(map::add);
      String url = tianConfig.Host + path;
      String json = webManger.postString(url, map);
      return JsonManager.toJsonNode(json, "Datas");
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
