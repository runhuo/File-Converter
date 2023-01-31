package com.runhuo.fileconverter.controller;

import com.runhuo.fileconverter.service.UserService;
import com.runhuo.fileconverter.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/7 16:14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login/{account}/{password}")
    public Result login(@PathVariable("account") String account,
                        @PathVariable("password") String password){
        return userService.login(account,password);
    }

    @PostMapping("/register/{account}/{password}/{captcha}")
    public Result register(@PathVariable("account") String account,
                           @PathVariable("password") String password,
                           @PathVariable("captcha")String captcha){
        return userService.register(account,password,captcha);
    }

}
