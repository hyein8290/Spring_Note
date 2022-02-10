package com.test.mybatis;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyBatisController {

	@Autowired
	private MyBatisDAO dao;
	
	//DB 입출력
	
	@RequestMapping(value = "/m1.do", method = { RequestMethod.GET })
	public String m1(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//인자값X + 반환값X
		dao.m1();
		
		return "result";
	}
	
	@RequestMapping(value = "/m2.do", method = { RequestMethod.GET })
	public String m2(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//인자값O + 반환값X
		MemoDTO dto = new MemoDTO();
		
		dto.setName("아무개");
		dto.setMemo("인자값이 있는 쿼리 실행");
		
		int result = dao.m2(dto);
		
		req.setAttribute("result", result);

		return "result";
	}

	@RequestMapping(value = "/m3.do", method = { RequestMethod.GET })
	public String m3(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//인자값O, 반환값X
		//삭제 > 반호 전달
		
		String seq = "5";
		
		int result = dao.m3(seq);
		
		req.setAttribute("result", result);

		return "result";
	}

	@RequestMapping(value = "/m4.do", method = { RequestMethod.GET })
	public String m4(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//복합값 전달
		//1. DTO
		//2. Map(O)
		//3. List(X) index로 값을 꺼낼 수 없어서 안 씀
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("id", "홍길동");
		map.put("content", "해시맵을 전달합니다.");
		
		int result = dao.m4(map);
		
		req.setAttribute("result", result);
		
		return "result";
	}
	
	@RequestMapping(value = "/m5.do", method = { RequestMethod.GET })
	public String m5(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//단일값 반환(숫자, 문자열) > count(*)
		
		int count = dao.m5();
		
		req.setAttribute("count", count);

		return "result";
	}
	
	@RequestMapping(value = "/m6.do", method = { RequestMethod.GET })
	public String m6(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//단일값 반환(복합값 다중 컬럼) > DTO 반환
		String seq = "7";
		
		MemoDTO dto = dao.m6(seq);
		
		req.setAttribute("dto", dto);

		return "result";
	}
	
	@RequestMapping(value = "/m7.do", method = { RequestMethod.GET })
	public String m7(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//반환값 > 다중 레코드 + 단일 컬럼
		//메모 내용만 가져오기
		
		//MyBatis가 인터페이스로 돌려주기 때문에 ArrayList가 아닌 List로 쓴다.
		List<String> memo = dao.m7();
		
		req.setAttribute("memo", memo);

		return "result";
	}
	
	@RequestMapping(value = "/m8.do", method = { RequestMethod.GET })
	public String m8(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		//반환값 > 다중 레코드 + 다중 컬럼
		//전체 목록
		
		List<MemoDTO> list = dao.m8();
		
		req.setAttribute("list", list);

		return "result";
	}
	
	@RequestMapping(value = "/m9.do", method = { RequestMethod.GET })
	public String m9(HttpServletRequest req, HttpServletResponse resp, HttpSession session
						, String column, String word, String order) {

		//메모 검색
		//1. 메모 내용 검색 > memo like '%검색어%'
		//2. 작성자 검색 > name = '홍길동'
		
		//m9.do?column=memo&word=메모&order=asc
		//m9.do?column=name&word=길동&order=desc
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("column", column);
		map.put("word", word);
		map.put("order", order);
		
		List<MemoDTO> list = dao.m9(map);
		
		req.setAttribute("list", list);

		return "result";
	}
	
	@RequestMapping(value = "/m10.do", method = { RequestMethod.GET })
	public String m10(HttpServletRequest req, HttpServletResponse resp, HttpSession session
						, String column, String word, String order) {

		//메모 검색
		//1. 메모 검색 > memo like '%검색어%'
		//2. 작성자 검색 > name like '%검색어%'
		//3. 정렬
		
		//m10.do?column=memo&word=메모&order=asc
		//m10.do?column=name&word=홍길동&order=desc

		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("column", column);
		map.put("word", word);
		map.put("order", order);
		
		List<MemoDTO> list = dao.m10(map);
		
		req.setAttribute("list", list);

		return "result";
	}
}
