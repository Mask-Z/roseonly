package com.mask.controller;

import com.mask.bean.Cart;
import com.mask.bean.Flower;
import com.mask.bean.Indent;
import com.mask.bean.User;
import com.mask.dao.CartDaoI;
import com.mask.dao.FlowerDaoI;
import com.mask.dao.IndentDaoI;
import com.mask.dao.UserDaoI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static com.mask.utils.Util.out;

/**
 * Created by Mr丶周 on 2016/12/8.
 */
@Controller
@RequestMapping("/main")
public class MainController {
	private final Log logger = LogFactory.getLog(MainController.class);
	@Autowired
	private FlowerDaoI flowerDao;
	@Autowired
	private UserDaoI userDao;
	@Autowired
	private IndentDaoI indentDao;
	@Autowired
	private CartDaoI cartDao;

	@RequestMapping(value = "temp", method = RequestMethod.POST)
	public String temp() {
		return "success";
	}

	@RequestMapping("temp")
	public String temp2() {
		return "success";
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping("/detail")
	public ModelAndView flowerDetail(@RequestParam int id) {

		Flower flower = flowerDao.findOne(id);
		out(flower.getName() + "....");
		Map model = new HashMap();
		List<Flower> flowerList = new ArrayList<Flower>();
		flowerList.add(flower);
		model.put("flower", flower);
		model.put("flowerList", flowerList);
		ModelAndView modelAndView = new ModelAndView("detail", model);
		return modelAndView;
	}

	@RequestMapping(value = "/paying", method = RequestMethod.POST)
	public String paying(HttpServletRequest request) {//支付页面
		Double price= Double.valueOf(request.getParameter("price"));
		String name=request.getParameter("name");
		Integer amount= Integer.valueOf(request.getParameter("amount"));
		out("paying......");
		out("price: " + request.getParameter("price"));
		out("amount: " + request.getParameter("amount"));
		Map<String,Integer> map=new HashMap<>();
		map.put(name,amount);
		request.setAttribute("map",map);
		request.setAttribute("count",price*amount);
//		Indent indent = new Indent();
//		User user = userDao.findOne(Integer.valueOf(request.getParameter("userByUserId")));
//		Flower flower = flowerDao.findOne(Integer.valueOf(request.getParameter("flowerByFlowerId")));
//		indent.setUserByUserId(user);
//		indent.setAddress(user.getCity());
//		indent.setDealDetails(flower.getName() + "*" + request.getParameter("amount"));
//		indent.setFlowerByFlowerId(flower);
//		out(indent.getFlowerByFlowerId().getName());
//		out(indent.getUserByUserId().getName());
//		request.setAttribute("indent", indent);
		return "deal2";
	}

	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	@ResponseBody
	public String addCart(HttpServletRequest request) {//先不用实体类接收
		logger.info("cart....");
		out("cart.......");

		Cart cart = new Cart();
		User user = (User) request.getSession().getAttribute("baseUser");
		User newUser=userDao.getOne(user.getId());
		List<Cart> carts = (List<Cart>) newUser.getCartsById();
		if (carts != null && carts.size() > 0) {//如果该用户有购物车,直接从数据库取出来并实例化
			out("购物车继续添加...");
			cart = carts.get(0);
//			String[] nameArr=cart.getGoods().split(",");

			cart.setGoods(cart.getGoods() + "," + flowerDao.findOne(Integer.valueOf(request.getParameter("flowerByFlowerId"))).getName() + "=" + request.getParameter("amount"));
			cart.setAddtime(new Date());

		} else {
			out("创建购物车...");
			cart.setUserByUserId(user);
			cart.setGoods(flowerDao.findOne(Integer.valueOf(request.getParameter("flowerByFlowerId"))).getName() + "=" + request.getParameter("amount"));
			cart.setAddtime(new Date());

		}
		cartDao.saveAndFlush(cart);
//		if(null!=cart){
//			logger.debug("save cart");
//			cart.setAddtime(new Date());
//			cartDao.saveAndFlush(cart);
//		}
		return "success";
	}

	/**
	 * 结算购物车
	 */
	@RequestMapping("dealCart")
	public String dealCart(HttpServletRequest request) {
		cartDao.flush();
		userDao.flush();
		logger.info("dealCart.....");
		User user = (User) request.getSession().getAttribute("baseUser");
        User newUser=userDao.getOne(user.getId());
		List<Cart> carts = (List<Cart>) newUser.getCartsById();

		Cart cart;
//		List<Flower> flowerList;
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (carts != null && carts.size() > 0) {//把购物车中的商品和数量放到map中
			out("取出购物车商品和数量...");
			cart = carts.get(0);
			String goods = cart.getGoods();
			String[] arr1 = goods.split(",");
			for (String str : arr1) {
				String[] arr2 = str.split("=");
				if (map.containsKey(arr2[0])) {
					map.put(arr2[0], map.get(arr2[0]) + Integer.valueOf(arr2[1]));
				} else {
					map.put(arr2[0], Integer.valueOf(arr2[1]));
				}
			}
		}
		Double count = 0.0;
		for (String key : map.keySet()) {
			count = count + flowerDao.findFlowerByName(key).getPrice() * map.get(key);
		}
		request.setAttribute("count", count);
		request.setAttribute("map", map);
		return "deal2";
	}
//	@RequestMapping("/userManage")
//	public String userManager(HttpServletRequest request){
//		HttpSession session=request.getSession();
//		User user= (User) session.getAttribute("baseUser");
//		session.setAttribute("baseUser",userDao.findOne(user.getId()));//刷新用户信息
//		return "userManage";
//	}
}
