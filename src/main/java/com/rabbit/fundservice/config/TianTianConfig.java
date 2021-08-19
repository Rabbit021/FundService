package com.rabbit.fundservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "tiantian")
@Component
@Data
public class TianTianConfig {
    public String Host;
    public String AppVersion;
    public String version;
    public String deviceid;
    public String plat;
    public String product;
}
