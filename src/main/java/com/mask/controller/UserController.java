package com.mask.controller;

import com.mask.bean.User;
import com.mask.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Mr丶周 on 2016/12/6.
 */
@Controller
//@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDaoI userDao;
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	@RequestMapping(value = "/userLists", method = RequestMethod.GET)
	public String getUsers(ModelMap modelMap) {
		// 查询user表中所有记录
		List<User> userList = userDao.findAll();
		for(User user:userList)
			System.out.println(user.getRealname());
		// 将所有记录传递给要返回的jsp页面，放在userList当中
		modelMap.addAttribute("userList", userList);
		// 返回pages目录下的admin/users.jsp页面
		return "userManage";
	}

}
