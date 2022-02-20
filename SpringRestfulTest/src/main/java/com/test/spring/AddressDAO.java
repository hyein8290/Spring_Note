package com.test.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {

	@Autowired private SqlSessionTemplate template;

	public int add(AddressDTO dto) {
		
		return template.insert("address.add", dto);
	}

	public List<AddressDTO> list() {
		
		return template.selectList("address.list");
	}

	public int edit(AddressDTO dto) {

		return template.update("address.edit", dto);
	}

	public int del(String seq) {

		return template.delete("address.del", seq);
	}

	public List<AddressDTO> search(String word) {

		return template.selectList("address.search", word);
	}
}
