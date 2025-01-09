package com.mysite.backend.survey;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SurveyDao {
	
	private final SqlSession sqlSession;
	
	public Map<String, Object> view(int survey_idx) {		
		return sqlSession.selectOne("survey.view", survey_idx);
	}

	public void insert(Map<String, Object> map) {
		sqlSession.insert("survey.insert",map);		
	}

	public List<Map<String, Object>> summary(int survey_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("survey.summary",survey_idx);
	}

	

}
