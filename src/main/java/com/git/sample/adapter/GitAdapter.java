package com.git.sample.adapter;

import com.git.sample.model.RespFollowers;
import com.git.sample.model.RespResponse;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class GitAdapter {
    @Autowired
    RestTemplate restTemplate;
    @Value("${hotRepoUrl}")
    String hotRepoUri;
    @Value("${zeroSizeurl}")
    String zeroSizeurl;

    public ResponseEntity<RespResponse> getHotRepos() {
        Date utils=DateUtils.addDays(new Date(),-7);
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String url=String.format(hotRepoUri,simpleDateFormat.format(utils));
        return restTemplate.exchange(url, HttpMethod.GET,getEntity(),RespResponse.class);
    }

    private HttpEntity getEntity() {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Accept","application/vnd.github.preview");
        return new HttpEntity(httpHeaders);
    }

    public ResponseEntity<RespFollowers> getZeroFollowers() {
        return restTemplate.exchange(zeroSizeurl,HttpMethod.GET,getEntity(),RespFollowers.class);
    }
}
