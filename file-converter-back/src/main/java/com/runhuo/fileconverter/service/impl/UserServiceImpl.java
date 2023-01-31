package com.runhuo.fileconverter.service.impl;

import com.runhuo.fileconverter.service.UserService;
import com.runhuo.fileconverter.vo.Result;
import org.springframework.stereotype.Service;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/7 16:15
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Result login(String account, String password) {
        return null;
    }

    @Override
    public Result register(String account, String password, String captcha) {
        return null;
    }
}
