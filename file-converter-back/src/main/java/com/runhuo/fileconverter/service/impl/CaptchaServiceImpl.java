package com.runhuo.fileconverter.service.impl;

import com.runhuo.fileconverter.service.CaptchaService;
import com.runhuo.fileconverter.utils.CaptchaUtils;
import com.runhuo.fileconverter.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/6 12:09
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private CaptchaUtils captchaUtils;

    @Override
    public Result getImageCaptcha() {
        Map<String, String> captcha = captchaUtils.getCaptcha();
        return Result.success(captcha);
    }
}
