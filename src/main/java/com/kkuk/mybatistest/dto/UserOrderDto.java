package com.kkuk.mybatistest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderDto {

	private String userid;
	private String username;
	private int orderid;
	private String ordername;
	
	
}
