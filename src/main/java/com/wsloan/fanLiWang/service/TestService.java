package com.wsloan.fanLiWang.service;

import com.wsloan.fanLiWang.entity.User;

import java.util.List;

public interface TestService {
	 	List<User> getUserList(Integer pageNumber,Integer pageSize);
}
