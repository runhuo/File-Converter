package com.runhuo.fileconverter.controller;

import com.runhuo.fileconverter.service.CaptchaService;
import com.runhuo.fileconverter.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/6 12:08
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/image")
    public Result getImageCaptcha(){
        return captchaService.getImageCaptcha();
    }

}
