package service.Impl;

import java.util.List;  

import dao.UserInfoMapper;  
import model.UserInfo;  
import service.UserService;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

@Service("userService") 
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	public UserInfo getUserById(int id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}

	public List<UserInfo> getUsers() {
		return userInfoMapper.selectAll();
	}

	public int insert(UserInfo userInfo) {
		int result = userInfoMapper.insert(userInfo);  
        System.out.println(result);  
        return result;
	}

	public UserInfo getUserByNumber(String number) {
		List<UserInfo> userInfos = getUsers();
		for (UserInfo userInfo : userInfos) {
			if (number.equals(userInfo.getUnumber().toString())){
				return userInfo;
			}
		}
		return null;
	}
	

}
