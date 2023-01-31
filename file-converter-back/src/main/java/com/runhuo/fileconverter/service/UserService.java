package com.runhuo.fileconverter.service;

import com.runhuo.fileconverter.vo.Result;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/7 16:15
 */
public interface UserService {
    Result login(String account, String password);

    Result register(String account, String password, String captcha);
}
