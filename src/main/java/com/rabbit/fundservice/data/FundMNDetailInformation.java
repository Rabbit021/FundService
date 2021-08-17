package com.rabbit.fundservice.data;

import lombok.Data;

import java.util.Date;

@Data
public class FundMNDetailInformation {
    public String fcode;
    public String shortname;
    public String ftype;
    public Date estabdate;
    public String endnav;
    // 管理费
    public String mgrexp;
    // 托管费
    public String trustexp;
    // 销售服务费
    public String salesexp;
}
