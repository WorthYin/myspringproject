package springmvc;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import model.ScoreInfo;
import model.UserInfo;
import service.ScoreService;
import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestUsersService {
	private static final Logger LOGGER = Logger.getLogger(TestUsersService.class);

	@Autowired
	private UserService userService;
	@Autowired
	private ScoreService scoreService;
	
	@Test
	public void testInsert() {
		UserInfo userInfo = new UserInfo();
		userInfo .setUname("xiaoming");
		userInfo.setUnumber(4);
		int result = userService.insert(userInfo);
		LOGGER.info("Insert Result：" + result);
	}

	public void testQueryAll() {
		List<UserInfo> userInfos = userService.getUsers();
		LOGGER.info(JSON.toJSON(userInfos));
	}

	@Test
	public void testInsertScore(){
		UserInfo userInfo = new UserInfo();
		userInfo.setUname("Edward");
		userInfo.setUnumber(118);
		ScoreInfo scoreInfo = new ScoreInfo();
		scoreInfo.setCname("english");
		scoreInfo.setScore((float)99);
		scoreInfo.setUnumber("118");
		int Result1 = userService.insert(userInfo);
		int Result2 = scoreService.insert(scoreInfo);
		LOGGER.info("Insert Result1：" + Result1+"Result2："+Result2);
	}
}
