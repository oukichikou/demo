package recode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jedis.JedisClient;
import service.TypeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class test1 {
	@Autowired
	private TypeService service;
	@Test
	public void set() {
		service.getByid(1);
		service.getByid(1);
		service.getByid(1);
		service.getByid(1);
	}
	
	public void get() {
	
	}
	
	
	

}
