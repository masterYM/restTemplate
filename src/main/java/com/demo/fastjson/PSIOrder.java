package com.demo.fastjson;

import lombok.Data;

import java.util.List;

@Data
public class PSIOrder {
    //订单ID，如果没有为新增，有为修改
    private String id;
    //交易日期，格式为"2018-10-20"
    private String dealDate;
    //客户ID，系统应为商城创建一个客户，使用该客户ID来创建销售订单
    private String customerId;
    //=1，是电商订单
    private String isEcBill;
    //订单是否已支付：=1，已支付; =0，未支付
    private String isPaid;
    //交货类型：=0, 快递；=1，门店自提
    private String deliveryType;
    //门店ID
    private String warehouseId;
    //交货地址， 即客户收货地址
    private String dealAddress;
    //联系人
    private String contact;
    //联系电话
    private String tel;
    //传真
    private String fax;
    //组织机构ID，系统应为电商指定一个组织机构
    private String orgId;
    //操作订单的业务员ID，系统应为电商分配一个业务员ID
    private String bizUserId;
    //记账类型：=0，记应收账款；=1， 现金收款
    private String receivingType;
    //备注
    private String billMemo;
    //订单商品详细
    private List<PSIGoods> items;
}
