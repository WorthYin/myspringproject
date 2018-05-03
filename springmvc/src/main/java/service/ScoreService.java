package service;

import java.util.List;

import model.ScoreInfo;  
  
/**   
 * 创建时间：
 * @author yin
 * @version 2.2   
 */  
  
public interface ScoreService {  
  
	List<ScoreInfo> getScoreByUserId(int id);  
	
	List<ScoreInfo> getScoreByUserNumber(String number); 
	
	List<ScoreInfo> getScoreByCourseName(String courseName);
      
    List<ScoreInfo> getScores();  
      
    int insert(ScoreInfo scoreInfo);  
}  
