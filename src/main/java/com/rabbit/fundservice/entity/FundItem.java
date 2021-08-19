package com.rabbit.fundservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wangheng
 */
@Data
@Entity
@Table(name = "fund_item")
@IdClass(FundItem.class)
public class FundItem implements Serializable {
    @Id
    private String fcode;
    private String fname;
}
