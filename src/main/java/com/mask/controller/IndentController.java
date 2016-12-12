package com.mask.controller;

import com.mask.bean.Indent;
import com.mask.bean.User;
import com.mask.dao.CartDaoI;
import com.mask.dao.IndentDaoI;
import com.mask.dao.UserDaoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;

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

	/**
	 * 保存用户订单(先这样接收数据)
	 *
	 * @return
	 */
	@RequestMapping(value = "saveIndent", method = RequestMethod.POST)
	public String saveIndent(String address, Integer postStyle, Integer payStyle, Double totalMoney,String dealDetails, HttpServletRequest request) {
		out("saveIndent...");
		out("address..." + address);
		Indent indent=new Indent();
		indent.setAddress(address);
		indent.setDealDetails(dealDetails);
		indent.setPayDate(new Date());
		indent.setPostStyle(postStyle);
		indent.setPayStyle(payStyle);
		indent.setTotalMoney(totalMoney);
		indent.setUserByUserId((User) request.getSession().getAttribute("baseUser"));
		indentDao.saveAndFlush(indent);
		//移除购物车信息
		cartDao.delete(((User) request.getSession().getAttribute("baseUser")).getCartsById());
		cartDao.flush();
		request.setAttribute("msg","已成功付款,请等待收货");
		return "home";
	}
}
