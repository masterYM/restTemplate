package com.demo.fastjson;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ObjectToJson {
    public static void main(String[] args) {
        PSIGoods psiGoods = new PSIGoods();
        psiGoods.setGoodsId("001");
        psiGoods.setGoodsPrice("10.2");
        psiGoods.setGoodsCount(5);
        psiGoods.setGoodsMoney(51.0);
        psiGoods.setMemo("none");
        PSIGoods psiGoods1 = new PSIGoods();
        psiGoods1.setGoodsId("001");
        psiGoods1.setGoodsPrice("10.2");
        psiGoods1.setGoodsCount(5);
        psiGoods1.setGoodsMoney(51.0);
        psiGoods1.setMemo("商品备注");
        List<PSIGoods> items = new ArrayList<>();
        items.add(psiGoods);
        items.add(psiGoods1);
        PSIOrder psiOrder = new PSIOrder();
        psiOrder.setId("");
        psiOrder.setDealDate("2018-10-31");
        psiOrder.setCustomerId("04B53C5E-B812-11E4-8FC9-782BCBD7746B");
        psiOrder.setIsEcBill("1");
        psiOrder.setIsPaid("0");
        psiOrder.setDeliveryType("0");
        psiOrder.setDealAddress("成都");
        psiOrder.setContact("杜好强");
        psiOrder.setTel("18888888888");
        psiOrder.setOrgId("5EBDBE11-A129-11E4-9B6A-782BCBD7746B");
        psiOrder.setBizUserId("6C2A09CD-A129-11E4-9B6A-782BCBD7746B");
        psiOrder.setBillMemo("订单备注");
        psiOrder.setItems(items);
        String jsonString = JSONObject.toJSONString(psiOrder);
        System.out.println(jsonString);

    }
}
