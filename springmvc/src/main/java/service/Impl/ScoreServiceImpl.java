package service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ScoreInfoMapper;
import model.ScoreInfo;
import service.ScoreService;
@Service("scoreService") 
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	ScoreInfoMapper scoreInfoMapper;

	@SuppressWarnings("null")
	public List<ScoreInfo> getScoreByUserId(int id) {
		List<ScoreInfo> scoreInfos = getScores();
		List<ScoreInfo> scoreInfosByUser = null;
		for (ScoreInfo scoreInfo : scoreInfos) {
			if (id == scoreInfo.getId()) {
				scoreInfosByUser.add(scoreInfo);
			}
		}
		return scoreInfosByUser;
	}

	@SuppressWarnings("null")
	public List<ScoreInfo> getScoreByUserNumber(String number) {
		List<ScoreInfo> scoreInfos = getScores();
		List<ScoreInfo> scoreInfosByNumber = new ArrayList<ScoreInfo>();
		for (ScoreInfo scoreInfo : scoreInfos) {
			if (number.equals(scoreInfo.getUnumber())) {
				scoreInfosByNumber.add(scoreInfo);
			}
		}
		return scoreInfosByNumber;
	}

	@SuppressWarnings("null")
	public List<ScoreInfo> getScoreByCourseName(String courseName) {
		List<ScoreInfo> scoreInfos = getScores();
		List<ScoreInfo> scoreInfosByCourseName = null;
		for (ScoreInfo scoreInfo : scoreInfos) {
			if (courseName.equals(scoreInfo.getCname())) {
				scoreInfosByCourseName.add(scoreInfo);
			}
		}
		return scoreInfosByCourseName;
	}

	public List<ScoreInfo> getScores() {
		return scoreInfoMapper.selectAll();
	}

	public int insert(ScoreInfo scoreInfo) {
		int result = scoreInfoMapper.insert(scoreInfo);
		return result;
	}

}
