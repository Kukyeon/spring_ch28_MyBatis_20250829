package com.kkuk.mybatistest.dao;

import java.util.List;

import com.kkuk.mybatistest.dto.UserOrderDto;

public interface OrderDao {
	
	public List<UserOrderDto> userOrderListDao(String userid); 
}
