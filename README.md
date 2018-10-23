# RestTemplate


```
//---------------cookie怎么传-----------------------
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);//表单形式
        
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

```
