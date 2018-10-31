package com.demo.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * ━━━━━━如来保佑━━━━━━
 * ━━━━━━如来保佑━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━永无BUG━━━━━━
 *
 * @author Ledev4
 * @date 2018/10/31 11:23 星期三
 */


public class JsonToJsonObject {
    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject("{\"id\":\"\",\"dealDate\":\"2018-10-20\",\"customerId\":\"04B53C5E-B812-11E4-8FC9-782BCBD7746B\",\"dealAddress\":\"\",\"isEcBill\":\"1\",\"isPaid\":\"0\",\"deliveryType\":\"1\",\"warehouseId\":\"17A72FFA-B3F3-11E4-9DEA-782BCBD7746B\",\"contact\":\"\",\"tel\":\"\",\"fax\":\"\",\"orgId\":\"5EBDBE11-A129-11E4-9B6A-782BCBD7746B\",\"bizUserId\":\"6C2A09CD-A129-11E4-9B6A-782BCBD7746B\",\"receivingType\":\"0\",\"billMemo\":\"\",\"items\":[{\"goodsId\":\"DA4D10A8-B3F3-11E4-9DEA-782BCBD7746B\",\"goodsCount\":2,\"goodsPrice\":\"2799.00\",\"goodsMoney\":5598,\"tax\":951.66,\"taxRate\":17,\"moneyWithTax\":6549.66,\"memo\":\"\"}]}");
        String date = jsonObject.getString("dealDate");
        System.out.println(date);
        System.out.println(jsonObject.getString("customerId"));
    }
}
