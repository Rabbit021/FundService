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
    public String mgrexp; // 管理费
    public String trustexp; // 托管费
    public String salesexp; // 销售服务费
}