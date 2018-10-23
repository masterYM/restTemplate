package com.demo.rest_template.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Run {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取权限
     * @param res
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String run(HttpServletResponse res){
        String url = "http://localhost:10080/web/User/loginPost";
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("loginName", "admin");
        params.add("password", "admin");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        System.out.println(response.getBody());
        List<String> list = response.getHeaders().get("Set-Cookie");
        String string = list.get(0);
        String c = string.substring(string.indexOf("=")+1,string.indexOf(";"));
        Cookie cookie = new Cookie("cookieName",c);
        cookie.setMaxAge(3600*24*3);
        res.addCookie(cookie);

        return response.getBody();
    }

    /**
     * 获取分类
     * @param cookie
     * @return
     */
    @RequestMapping(value = "/Goods/allCategories",method = RequestMethod.GET)
    public String Cate(@CookieValue("cookieName") String cookie){
        String url = "url";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        List<String> cookies = new ArrayList<>();
        cookies.add("cookieName=" + cookie);
        headers.put(HttpHeaders.COOKIE,cookies);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("node", "root");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity , String.class );

        /*
        headers.add("authorization",Auth);
        headers.setContentType(MediaType.APPLICATION_JSON);//json形式

        JSONObject content = new JSONObject();//放入body中的json参数
        content.put("parm1","parm1");
        content.put("parm2",parm2);

        HttpEntity<JSONObject> request = new HttpEntity<>(content,headers); //组装

        ResponseEntity<String> response = template.exchange(url,HttpMethod.POST,request,String.class);
         *
         */

        System.out.println(response.getBody());
        return response.getBody();
    }

    /**
     *
     * @param cookie
     * @param categoryId 商品类别ID
     * @param start 从第几条记录返回
     * @param limit 共返回多少条记录
     * @return
     */
    @RequestMapping(value = "/Goods/goodsInfoList",method = RequestMethod.GET)
    public String goodsInfoList(@CookieValue("cookieName") String cookie,
                                @RequestParam("categoryId") String categoryId,
                                @RequestParam("start") String start,
                                @RequestParam("limit")String limit){
        String url = "url";
        //---------------cookie怎么传-----------------------
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        List<String> cookies = new ArrayList<>();
        cookies.add("cookieName=" + cookie);
        headers.put(HttpHeaders.COOKIE,cookies);
        //------------------参数怎么传---------------------
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("categoryId", categoryId);
        params.add("start", start);
        params.add("limit", limit);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity , String.class );

        System.out.println(response.getBody());
        return response.getBody();
    }

    @RequestMapping(value = "/Warehouse/warehouseList",method = RequestMethod.GET)
    public String Warehouse(@CookieValue("cookieName") String cookie, @RequestParam("id") String id){
        String url = "url";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        List<String> cookies = new ArrayList<>();
        cookies.add("cookieName=" + cookie);
        headers.put(HttpHeaders.COOKIE,cookies);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", id);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity , String.class );

        System.out.println(response.getBody());
        return response.getBody();
    }


}

























