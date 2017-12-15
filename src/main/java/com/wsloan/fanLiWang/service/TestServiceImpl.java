package com.wsloan.fanLiWang.service;

import com.wsloan.fanLiWang.dao.TestDao;
import com.wsloan.fanLiWang.dao.UserDao;
import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.Receipt;
import com.wsloan.fanLiWang.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {
	@Resource
    private TestDao testDao;


	public List<User> getUserList(Integer pageNumber, Integer pageSize) {
		Integer min = (pageNumber-1)*pageSize+1;//计算该页显示几到几条
		Integer max = pageNumber*pageSize;
		List<User> list = testDao.getUserList(min,max);
		return list;
	}
}
