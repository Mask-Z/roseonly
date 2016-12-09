package com.mask.controller;

import com.mask.bean.Flower;
import com.mask.bean.Indent;
import com.mask.bean.User;
import com.mask.dao.FlowerDaoI;
import com.mask.dao.IndentDaoI;
import com.mask.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.mask.utils.Util.out;

/**
 * Created by Mr丶周 on 2016/12/8.
 */
@Controller
@RequestMapping("/main")
public class MainController {
	@Autowired
	private FlowerDaoI flowerDao;
	@Autowired
	private UserDaoI userDao;
	@Autowired
	private IndentDaoI indentDao;

	@RequestMapping(value = "temp",method = RequestMethod.POST)
	public String temp(){
		return "success";
	}

	@RequestMapping("temp")
	public String temp2(){
		return "success";
	}
	@RequestMapping("/detail")
	public ModelAndView flowerDetail(@RequestParam int id) {

		Flower flower = flowerDao.findOne(id);
		out(flower.getName()+"....");
		Map model=new HashMap();
		model.put("flower",flower);
		ModelAndView modelAndView=new ModelAndView("detail","flower",flower);
		return modelAndView;
	}
	@RequestMapping(value = "/paying",method = RequestMethod.POST)
	public String  paying(HttpServletRequest request){
		out("paying......");
		out("userByUserId: "+request.getParameter("userByUserId"));
		out("flowerByFlowerId: "+request.getParameter("flowerByFlowerId"));
		out("number: "+request.getParameter("number"));
		Indent indent=new Indent();
		User user=userDao.findOne(Integer.valueOf(request.getParameter("userByUserId")));
		Flower flower=flowerDao.findOne(Integer.valueOf(request.getParameter("flowerByFlowerId")));
		indent.setUserByUserId(user);
		indent.setAddress(user.getCity());
		indent.setDealDetails(flower.getName()+"*"+request.getParameter("number"));
		indent.setFlowerByFlowerId(flower);
		out(indent.getFlowerByFlowerId().getName());
		out(indent.getUserByUserId().getName());
		request.setAttribute("indent",indent);
		return "deal";
	}
}
