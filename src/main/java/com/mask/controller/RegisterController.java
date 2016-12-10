package com.mask.controller;

import com.mask.bean.User;
import com.mask.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zyl on 2016/12/8.
 */
@Controller
public class RegisterController {
    @Autowired
    private UserDaoI userDao;
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(User user, HttpServletRequest request){
        user.setCity(request.getParameter("province")+","+user.getCity());
        userDao.saveAndFlush(user);
        request.getSession().setAttribute("msg","恭喜,用户名"+user.getName()+"注册成功!");
        return "login";
    }
}
