package com.demo.rest_template.run;


import com.alibaba.fastjson.JSONObject;
import com.demo.fastjson.PSIGoods;
import com.demo.fastjson.PSIOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RunOrder {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/Sale/editSOBill",method = RequestMethod.GET)
    public String goodsInfoList(@CookieValue("cookieName") String cookie){
        String url = "http://localhost:10080/web/Home/Sale/editSOBill";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        List<String> cookies = new ArrayList<>();
        cookies.add("cookieName=" + cookie);
        headers.put(HttpHeaders.COOKIE,cookies);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("jsonStr", main());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity , String.class );

        JSONObject jsonObject = JSONObject.parseObject(response.getBody().toString());
        String result = jsonObject.getString("msg");
        System.out.println(result);
        return result;
    }

    public  String main() {
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
        psiGoods1.setMemo("商品备注11");
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
        return jsonString;
    }
}
