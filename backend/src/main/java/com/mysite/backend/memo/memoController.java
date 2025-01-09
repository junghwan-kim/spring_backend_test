package com.mysite.backend.memo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
public class memoController {
	private final MemoDao memoDao;
	

	@GetMapping("/memo")
	public List<Map<String, Object>> list(@RequestParam(name = "memo", defaultValue = "") String memo){		
		return memoDao.list(memo);
	}
	
	@PostMapping("/memo/insert")
	public void insert(@RequestParam Map<String, Object> map) {
		memoDao.insert(map);
	}
	

	@GetMapping("/memo/detail/{idx}")
	public Map<String, Object> detail(@PathVariable(name = "idx") int idx){
		return memoDao.detail(idx);
	}

	@PostMapping("/memo/update")
	public void update(@RequestParam Map<String, Object> map) {
		memoDao.update(map);
	}

	@PostMapping("/memo/delete")
	public void delete(@RequestParam(name = "idx") int idx) {
		memoDao.delete(idx);
	}

}
