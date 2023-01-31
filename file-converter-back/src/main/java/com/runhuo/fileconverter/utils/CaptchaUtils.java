package com.runhuo.fileconverter.utils;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/6 12:01
 */
@Component
public class CaptchaUtils {
    public Map<String,String> getCaptcha(){
        Map<String,String> map=new HashMap<>();
        SpecCaptcha captcha=new SpecCaptcha(120,40,4);
        captcha.setCharType(Captcha.TYPE_NUM_AND_UPPER);
        String text=captcha.text();
        String image=captcha.toBase64();
        map.put("text",text);
        map.put("image",image);
        return map;
    }
}
