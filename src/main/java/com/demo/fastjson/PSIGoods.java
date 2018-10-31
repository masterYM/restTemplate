package com.demo.fastjson;

import lombok.Data;

@Data
public class PSIGoods {
    //商品ID
    private String goodsId;
    //商品数量
    private int goodsCount;
    //商品销售单价
    private String goodsPrice;
    //销售金额
    private Double goodsMoney;
    //备注
    private String memo;
}
