package test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {

	protected ApplicationContext act;

	public TestBase() {
		super();
	}

	@Before
	public void init() {
		act=new ClassPathXmlApplicationContext(
				"conf/spring-mybatis.xml","conf/spring-mvc.xml");
	}

}