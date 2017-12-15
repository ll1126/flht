package com.wsloan.fanLiWang.dao;

import com.wsloan.fanLiWang.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestDao {
	List<User> getUserList(@Param("min") Integer min ,@Param("max") Integer max);

	
}
