package controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import model.ScoreInfo;
import model.UserInfo;
import service.ScoreService;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ScoreService scoreService;
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);


	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable int userId) {
		LOGGER.info("进入-----showInfo");
		UserInfo userInfo = userService.getUserById(userId);
		modelMap.addAttribute("userInfo", userInfo);
		return "/user/showInfo";
	}
	
	@RequestMapping("/showUserScore/{usernumber}")
	public String showUserScore(ModelMap modelMap, @PathVariable String usernumber) {
		LOGGER.info("进入---showUserScore");
		UserInfo userInfo = userService.getUserByNumber(usernumber);
		List<ScoreInfo> scoreInfos = scoreService.getScoreByUserNumber(usernumber);
		modelMap.addAttribute("userInfo", userInfo);
		modelMap.addAttribute("scoreInfo", scoreInfos);
		return "/score/userScoreInfo";
	}
	

	@RequestMapping("/showInfos")
	public @ResponseBody Object showUserInfos() {
		List<UserInfo> userInfos = userService.getUsers();
		return userInfos;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/UserScoreInfos")
	public String insertUserScoreInfos(@RequestBody JSONObject param) {
		ScoreInfo scoreInfo = (ScoreInfo) JSONObject.parse("ScoreInfo");
		int result = scoreService.insert(scoreInfo);
		if (result==1) {
			return "/score/insterUserScoreInfoSuccess";
		}else {
			return "/score/insterUserScoreInfoFaild";
		}
	}
	
}
