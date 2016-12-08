package com.mask.controller;

import com.mask.bean.Flower;
import com.mask.dao.FlowerDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/detail")
	public ModelAndView flowerDetail(@RequestParam int id) {
		ModelAndView modelAndView=new ModelAndView("detail");
		Flower flower = flowerDao.findOne(id);
		out(flower.getName()+"....");
		Map model=new HashMap();
		model.put("flower",flower);
//		modelAndView.addObject(flower);
		modelAndView.addObject("flower", model);
//		modelAndView.setViewName("detail");
		return modelAndView;
	}
}
