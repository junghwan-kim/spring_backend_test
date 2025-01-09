package com.mysite.backend.survey;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class SurveyController {
	
	private final SurveyDao surveyDao;
	
	@RequestMapping("/survey/insert")
	public void insert(@RequestParam Map<String, Object> map) {
		System.out.println(map);
		surveyDao.insert(map);
	}
	
	@RequestMapping("/survey/view/{survey_idx}")
	public Map<String, Object> view(@PathVariable(name ="survey_idx") int survey_idx){
		return surveyDao.view(survey_idx);
	}
	
	@RequestMapping("/survey/summary/{survey_idx}")
	public List<Map<String, Object>> summary(@PathVariable(name ="survey_idx") int survey_idx){
		System.out.println(survey_idx);
		return surveyDao.summary(survey_idx);
	}
	
}
