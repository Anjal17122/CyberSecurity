package com.ismt.cybersecurity.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CaptchaValidation {

    private RestTemplate restTemplate;

    public CaptchaValidation(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public boolean isValidCaptcha(String captcha) {

        String url= "https://www.google.com/recaptcha/api/siteverify";
        String serverSideKey = "6LdcOi4lAAAAAHdOtOfwKLmBJTIXaJ4ai0ri0XAI";
        String params="?secret="+serverSideKey+"&response="+captcha;
        String completeUrl=url+params;
        CaptchaResponse resp= restTemplate.postForObject(completeUrl, null, CaptchaResponse.class);
        if(resp==null) {
            return false;
        }
        else {
            return resp.isSuccess();
        }

    }
}
