package com.kkuk.mybatistest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kkuk.mybatistest.dao.IDao;
import com.kkuk.mybatistest.dao.OrderDao;
import com.kkuk.mybatistest.dto.BoardDto;
import com.kkuk.mybatistest.dto.UserOrderDto;

@Controller
public class OrderController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/orderlist")
	public String orderlist(Model model, HttpServletRequest request) {
		
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		List<UserOrderDto> userOrderDtos = orderDao.userOrderListDao("tiger");
		
		model.addAttribute("userOrderDtos", userOrderDtos);
		
		return "orderlist";
	}
}
