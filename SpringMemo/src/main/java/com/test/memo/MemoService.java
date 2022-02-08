package com.test.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//의존 객체의 자격 부여 > @Autowired를 통해서 자동으로 객체 생성 > 자동으로 의존 주입을 할 수 있게 만들어 준다.
//- 물리적 역할은 동일 > 사람이 보는 의미를 다르게..
//- @Component	> 나머지 객체
//- @Repository	> DAO 객체
//- @Service	> 서비스 객체 역할

@Service
public class MemoService implements IMemoService{

	@Autowired
	private MemoDAO dao;
	
	@Override
	public List<MemoDTO> list() {
				
		List<MemoDTO> list = dao.list();
		
		for(MemoDTO dto : list) {
			dto.setRegdate(dto.getRegdate().substring(0, 11));
		}
		
		return list;
	}
	
	@Override
	public int add(MemoDTO dto) {
		
		return dao.add(dto);
	}
	
	@Override
	public MemoDTO get(String seq) {
		
		return dao.get(seq);
	}
	
	@Override
	public int edit(MemoDTO dto) {
		
		return dao.edit(dto);
	}
	
	@Override
	public int del(String seq) {
		
		return dao.del(seq);
	}
}
