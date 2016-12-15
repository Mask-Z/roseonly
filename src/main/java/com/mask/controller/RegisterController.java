package com.mask.controller;

import com.mask.bean.User;
import com.mask.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.mask.utils.Util.out;

/**
 * Created by zyl on 2016/12/8.
 */
@Controller
public class RegisterController {
    @Autowired
    private UserDaoI userDao;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(User user, HttpServletRequest request) {
        user.setCity(request.getParameter("province") + "," + user.getCity());
        user.setRole(0);
        userDao.saveAndFlush(user);
        request.getSession().setAttribute("msg", "恭喜,用户名" + user.getName() + "注册成功!");
        return "login";
    }

    @RequestMapping("checkName")
    @ResponseBody
    public String checkName(HttpServletRequest request) {
        out("checkName....");
        String name = request.getParameter("name");
        String password = userDao.findPassWordByName(name);
        if (password!=null){
            return "failed";
        }else {
            return "success";
        }


    }
}
