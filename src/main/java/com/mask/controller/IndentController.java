package com.mask.controller;

import com.mask.bean.Cart;
import com.mask.bean.Flower;
import com.mask.bean.Indent;
import com.mask.bean.User;
import com.mask.dao.CartDaoI;
import com.mask.dao.FlowerDaoI;
import com.mask.dao.IndentDaoI;
import com.mask.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mask.utils.Util.out;

/**
 * Created by Mr丶周 on 2016/12/10.
 */
@Controller
@RequestMapping("indent")
public class IndentController {

	@Autowired
	private IndentDaoI indentDao;
	@Autowired
	private UserDaoI userDao;
	@Autowired
	private CartDaoI cartDao;
	@Autowired
	private FlowerDaoI flowerDao;

	/**
	 * 保存用户订单(先这样接收数据)
	 *
	 * @return
	 */
	@RequestMapping(value = "saveIndent", method = RequestMethod.POST)
	public String saveIndent(String address, Integer postStyle, Integer payStyle, Double totalMoney, String dealDetails, HttpServletRequest request) {
		out("saveIndent...");
		out("address..." + address);
		Indent indent = new Indent();
		indent.setAddress(address);
		indent.setDealDetails(dealDetails);
		indent.setPayDate(new Date());
		indent.setPostStyle(postStyle);
		indent.setPayStyle(payStyle);
		indent.setTotalMoney(totalMoney);
		indent.setUserByUserId((User) request.getSession().getAttribute("baseUser"));
		indent.setState(1);//设置订单初始状态为1,代表为出库
		indentDao.saveAndFlush(indent);
		//移除购物车信息
		User user = (User) request.getSession().getAttribute("baseUser");
		User newUser = userDao.getOne(user.getId());
		cartDao.delete(newUser.getCartsById());
		cartDao.flush();
		userDao.flush();
		request.setAttribute("msg", "已成功付款,请等待收货");
		List<Flower> flowerList=flowerDao.findAll();
		request.setAttribute("flowerList",flowerList);
		return "home";
	}

	/**
	 * 直接支付时,保存用户订单
	 *
	 * @return
	 */
	@RequestMapping(value = "saveIndent2", method = RequestMethod.POST)
	public String saveIndent2(String address, Integer postStyle, Integer payStyle, Double totalMoney, String dealDetails, HttpServletRequest request) {
		out("saveIndent...");
		out("address..." + address);
		Indent indent = new Indent();
		indent.setAddress(address);
		indent.setDealDetails(dealDetails);
		indent.setPayDate(new Date());
		indent.setPostStyle(postStyle);
		indent.setPayStyle(payStyle);
		indent.setTotalMoney(totalMoney);
		indent.setUserByUserId((User) request.getSession().getAttribute("baseUser"));
		indent.setState(1);//设置订单初始状态为1,代表为出库
		indentDao.saveAndFlush(indent);
		//移除购物车信息
		User user = (User) request.getSession().getAttribute("baseUser");
		User newUser = userDao.getOne(user.getId());
		cartDao.delete(newUser.getCartsById());
		cartDao.flush();
		userDao.flush();
		out("我是第二类..");
		request.setAttribute("msg", "已成功付款,请等待收货");
		List<Flower> flowerList=flowerDao.findAll();
		request.setAttribute("flowerList",flowerList);
		return "home";
	}

	@RequestMapping("/indents/showIndent/{id}")
	public String showIndent(@PathVariable("id") Integer userId, ModelMap modelMap) {
		out("showIndent().......");
		modelMap.put("user", userDao.findOne(userId));
		List<Indent> indentList = (List<Indent>) userDao.findOne(userId).getIndentsById();
		modelMap.put("indentList", indentList);
		return "indentDetail";
	}

	/**
	 * 管理员修改订单状态
	 *
	 * @return
	 */
	@RequestMapping("/updateState/{userId}/{indentId}")
	public String updateState(@PathVariable("userId") Integer userId, @PathVariable("indentId") Integer indentId) {
		out("update.....");
		Indent indent = indentDao.findOne(indentId);
		indent.setState(2);
		String deal_details = indent.getDealDetails();
		String[] detailsArr = deal_details.split(",");
		for (String arr : detailsArr) {
			String[] arr2 = arr.split("\\*");
			if (arr2.length == 2) {
				String flowerName = arr2[0];
				int flowerNumber = Integer.parseInt(arr2[1]);
				Flower flower = flowerDao.findFlowerByName(flowerName);
				flower.setAmount(flower.getAmount() - flowerNumber);
				flowerDao.saveAndFlush(flower);//订单出库时,商品要减少
			}
		}
		indentDao.saveAndFlush(indent);

		return "redirect:/indent/indents/showIndent/" + userId;
	}

	@RequestMapping(value = "/showByFlag", method = RequestMethod.POST)
	public String showByFlag(HttpServletRequest request, ModelMap modelMap) {//根据订单状态返回查询结果
		String flag = request.getParameter("flag");
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		modelMap.put("user", userDao.findOne(userId));
		modelMap.put("flag", flag);
		List<Indent> indents = (List<Indent>) userDao.findOne(userId).getIndentsById();
		List<Indent> indentList = new ArrayList<>();
		if (flag.equals("0")) {
		} else if (flag.equals("1")) {
			for (Indent indent : indents) {
				if (indent.getState() == 2) {
					indentList.add(indent);
				}
			}
		} else {
			for (Indent indent : indents) {
				if (indent.getState() == 1) {
					indentList.add(indent);
				}
			}
		}
		request.setAttribute("indentList", indentList);
		return "indentDetail";
	}

//	public static void main(String[] args) {
//		String str="白玫瑰*2";
//		String[] arr=str.split("\\*");
//		for(String s:arr){
//			System.out.println(s);
//		}
//	}
}
