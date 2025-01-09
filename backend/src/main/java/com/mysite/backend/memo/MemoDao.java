package com.mysite.backend.memo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemoDao {
	private final SqlSession sqlSession;
	
	public void insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert("memo.insert",map);		
	}
	public List<Map<String, Object>> list(String memo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("memo.listAll",memo);
	}
	public Map<String, Object> detail(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memo.detail",idx);
	}
	public void delete(int idx) {
		// TODO Auto-generated method stub
		sqlSession.delete("memo.delete",idx);
	}
	public void update(Map<String, Object> map) {
		sqlSession.update("memo.update",map);				
	}

}
