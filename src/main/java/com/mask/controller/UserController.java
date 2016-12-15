package com.mask.controller;

import com.mask.bean.User;
import com.mask.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	// 查看用户详情
// @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
// 例如：访问 localhost:8080/users/show/1 ，将匹配 id = 1
	@RequestMapping(value = "/users/show/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

		// 找到userId所表示的用户
		User userEntity = userDao.findOne(userId);

		// 传递给请求页面
		modelMap.addAttribute("user", userEntity);
		return "userDetail";
	}

	// 更新用户信息 页面
	@RequestMapping(value = "/users/update/{id}", method = RequestMethod.GET)
	public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

		// 找到userId所表示的用户
		User userEntity = userDao.findOne(userId);

		// 传递给请求页面
		modelMap.addAttribute("user", userEntity);
		return "updateUser";
	}

	// 更新用户信息 操作
	@RequestMapping(value = "/users/updateP", method = RequestMethod.POST)
	public String updateUserPost(User user) {

		// 更新用户信息
		userDao.updateUser(user.getName(),user.getPassword(),user.getCity(),user.getRole(),user.getNumber(),user.getRealname(),user.getId());
		// 刷新缓冲区
		userDao.flush();
		return "redirect:/userLists";
	}

	// 删除用户
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Integer userId) {

		// 删除id为userId的用户
		userDao.delete(userId);
		// 立即刷新
		userDao.flush();
		return "redirect:/userLists";
	}
}
