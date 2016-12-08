package com.mask.controller;

import com.mask.bean.User;
import com.mask.dao.UserDaoI;
import com.mask.utils.Util;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyl on 2016/12/8.
 */
@Controller
public class LoginController {
    @Autowired
    private UserDaoI userDao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    @ResponseBody
    public String checkUser(User user) {
        Util.out("checkUser...." + user.getName());
        String password = userDao.findPassWordByName(user.getName());
        if (null != password && password.equals(user.getPassword())) {
            Util.out("success.....");
            return "success";
        } else if (null == password) {
            Util.out("没有此用户.....");
            return "there is no this name";
        } else {
            Util.out("账号,密码不匹配......");
            return "name and password is not matching";
        }
    }

    @RequestMapping(value = "sysLogin", method = RequestMethod.GET)
    public String sysLogin() {
        return "success";
    }
}
