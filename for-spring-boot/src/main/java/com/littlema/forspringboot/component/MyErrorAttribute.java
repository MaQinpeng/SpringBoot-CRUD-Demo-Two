package com.littlema.forspringboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","company");
        Map<String,Object> ext = (Map<String,Object>)webRequest.getAttribute("ext", 0);
        if(ext!=null&&!ext.isEmpty()){
            map.putAll(ext);
        }
        return map;
    }
}
