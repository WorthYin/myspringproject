package dao;

import java.util.List;

import model.ScoreInfo;

public interface ScoreInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ScoreInfo record);

    int insertSelective(ScoreInfo record);

    ScoreInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ScoreInfo record);

    int updateByPrimaryKey(ScoreInfo record);
    
    List<ScoreInfo> selectAll();
}