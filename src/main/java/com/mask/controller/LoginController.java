package com.mask.controller;

import com.mask.bean.Flower;
import com.mask.bean.User;
import com.mask.dao.FlowerDaoI;
import com.mask.dao.UserDaoI;
import com.mask.utils.MyControl;
import com.mask.utils.PropertiesUtils;
import com.mask.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

import static com.mask.utils.Util.out;

/**
 * Created by zyl on 2016/12/8.
 */
@Controller
public class LoginController {
    @Autowired
    private UserDaoI userDao;
    @Autowired
    private FlowerDaoI flowerDao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    @ResponseBody
    public String checkUser(User user, HttpServletRequest request) {
        out("checkUser...." + user.getName());
        String password = userDao.findPassWordByName(user.getName());
        if (null != password && password.equals(user.getPassword())) {
            out("success.....");
            User baseUser=userDao.findOne(userDao.findIdByName(user.getName()));
            request.getSession().setAttribute("baseUser",baseUser);
            return "success";
        } else if (null == password) {
            out("没有此用户.....");
            return "there is no this name";
        } else {
            out("账号,密码不匹配......");
            return "name and password is not matching";
        }
    }

    @RequestMapping(value = "sysLogin", method = RequestMethod.GET)
    public String sysLogin(ModelMap modelMap,HttpServletRequest request) {
//        ResourceBundle.clearCache();
//
//        ResourceBundle rb = ResourceBundle.getBundle("color");
//        MyControl.addNeedsReloadBaseName("color");
//        ResourceBundle rb = ResourceBundle.getBundle("color", MyControl.getControl());
//        String color=rb.getString("color");
        //读取配置文件,修改主题(不从缓存中获取)
//        if(request.getAttribute("msg")!=null&&request.getAttribute("msg")!=""){
//            request.setAttribute("msg", request.getAttribute("msg"));
//        }
        Properties properties=PropertiesUtils.loadProps("D:\\WorkSpace\\roseonly\\src\\main\\resources\\color.properties");
        String color=properties.getProperty("color");
        request.getSession().setAttribute("color",color);
        out("####:  "+color);
        List<Flower> flowerList=flowerDao.findAll();
        modelMap.addAttribute("flowerList",flowerList);
        return "home";
    }

    @RequestMapping(value = "flowerSearch", method = RequestMethod.POST)
    public String flowerSearch(String search,ModelMap modelMap) {
        out("进入flowerSearch...."+search);
        List<Flower> flowers=flowerDao.findAll();
        List<Flower> flowerList=new ArrayList<>();
        for(Flower flower:flowers){
            if (flower.getName().contains(search))
                flowerList.add(flower);
        }
        modelMap.addAttribute("search",search);
        modelMap.addAttribute("flowerList",flowerList);
        return "home";
    }
    @RequestMapping(value = "updateColor",method = RequestMethod.POST)
    @ResponseBody
    public String updateColor(HttpServletRequest request,String color){
//        String color2=request.getParameter("color");
        out("接收"+":  "+color);
        writeProperties(color);
        return "success";
    }

    public void writeProperties(String color) {
        Properties properties = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("D:\\WorkSpace\\roseonly\\src\\main\\resources\\color.properties");
            properties.setProperty("color", color);
            properties.store(output,"last modify" + new Date().toString());
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
