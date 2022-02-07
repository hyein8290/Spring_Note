package com.test.memo;

import java.util.List;

public class MemoService implements IMemoService{

	@Override
	public List<MemoDTO> list() {
		
		MemoDAO dao = new MemoDAO();
		
		List<MemoDTO> list = dao.list();
		
		return list;
	}
}
