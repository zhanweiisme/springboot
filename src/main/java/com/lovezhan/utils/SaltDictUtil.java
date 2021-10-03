package com.lovezhan.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Set;

public class SaltDictUtil {
private static final HashMap<String, String> MAP = new HashMap<String, String>();
	
	public static HashMap<String, String> getMap() throws IOException {
	    
        if (CollectionUtils.isEmpty(MAP)) {
            synchronized (SaltDictUtil.class) {
                if (CollectionUtils.isEmpty(MAP)) {
                    readJsonData();
                }
               
            }
            return MAP;   
        }else{
            return MAP;
        }
	    
	}
    public static String getKeyValues(String key) throws IOException {
        if (StringUtils.isEmpty(key)){return null;}
        if (CollectionUtils.isEmpty(MAP)) {
            readJsonData();
        }
        return MAP.get(key);
    }

    public static void readJsonData() throws IOException {
        InputStream inputStream = new ClassPathResource("/static/salt.json").getInputStream();
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8.name());
        String str = writer.toString();
        JSONObject jsonObject = JSONObject.parseObject(str);
        Set<String> keySet = jsonObject.keySet();
        for (String s : keySet) {
            MAP.put(s, jsonObject.getString(s));
        }
    }
    
}
