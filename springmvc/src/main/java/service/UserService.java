package service;

import java.util.List;

import model.UserInfo;  
  
/**   
 * 创建时间：
 * @author yin
 * @version 2.2   
 */  
  
public interface UserService {  
  
    UserInfo getUserById(int id);  
    
    UserInfo getUserByNumber(String number); 
      
    List<UserInfo> getUsers();  
      
    int insert(UserInfo userInfo);
}  
