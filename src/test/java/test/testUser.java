package test;

import com.wsloan.fanLiWang.dao.BrandInformationDao;
import com.wsloan.fanLiWang.dao.ReceiptDao;
import com.wsloan.fanLiWang.dao.UserDao;
import com.wsloan.fanLiWang.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUser {
	protected UserService userService;

	UserDao dao;
	BrandInformationDao brandDao;
	ApplicationContext act;
	ReceiptDao receiptDao;
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		dao=act.getBean("userDao",UserDao.class);
		brandDao = act.getBean("brandInformationDao", BrandInformationDao.class);
		receiptDao = act.getBean("receiptDao",ReceiptDao.class);
	}
	@Test
	public void initTestWorkOrderService(){
		/*
		List<User> list = dao.getUserList();
		for(User user:list){
			System.out.println(user);
		}*/
		
//		int num = receiptDao.updateState(2, 2);
//		System.out.println(num);
		
//		List<Receipt> list = receiptDao.getReceiptList(1,null);
		
	//	List<BrandInformation> list = brandDao.getBrandList(1, 6);
//		for(Receipt receipt:list){
//			System.out.println(receipt);
//		}
		
	}
}
