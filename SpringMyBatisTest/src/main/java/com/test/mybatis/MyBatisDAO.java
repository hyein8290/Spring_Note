package com.test.mybatis;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisDAO {

	//Connection conn;
	//Statement stat;
	//ResultSet rs;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void m1() {
		
		//SQL 실행
		// - String sql > executeXXX() > return O, X
		
		//- stat.executeQuery()
		//	= template.selectXXX()
		
		//- stat.executeUpdate()
		//	= template.insert()
		//	= template.update()
		//	= template.delete()
		
		//template.insert("XML에 있는 쿼리의 식별자");
		template.insert("test.m1");
		
	}

	public int m2(MemoDTO dto) {
		
		return template.insert("test.m2", dto);
		
	}

	public int m3(String seq) {
		
		//무조건 인자는 하나만 넘길 수 있다. > dto나 hashmap으로 넘김. arraylist로 안 넘김
		return template.delete("test.m3", seq);
	}

	public int m4(HashMap<String, String> map) {

		return template.insert("test.m4", map);
	}

	public int m5() {
		
		//select
		//- 컬럼 수는 무관
		//1. template.selectOne() > 결과셋의 레코드 수가 1개일 때 > 주로 DTO 반환
		//2. template.selectList() > 결과셋의 레코드 수가 N개일 때 > 주로 List<DTO> 반환
		
		return template.selectOne("test.m5");
	}

	public MemoDTO m6(String seq) {

		return template.selectOne("test.m6", seq);
	}

	public List<String> m7() {

		return template.selectList("test.m7");
	}

	public List<MemoDTO> m8() {

		return template.selectList("test.m8");
	}

	public List<MemoDTO> m9(HashMap<String, String> map) {

		return template.selectList("test.m9", map);
	}

	public List<MemoDTO> m10(HashMap<String, String> map) {

		return template.selectList("test.m10", map);
	}

}
