package com.test.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//restcontroller는 뷰를 호출하지 못한다. > responsebody 생략 가능
//@Controller
@RestController
public class AddressController {

	@Autowired private AddressDAO dao;
	
	//CRUD
	
	//요소 추가
	//1. http://localhost:8090/address
	//2. POST
	//3. return int
	
	//@RequestMapping(value="/address", method= {RequestMethod.POST})
	@PostMapping("/address")
	//@ResponseBody
	public int add(@RequestBody AddressDTO dto) {
		
		return dao.add(dto);
	}
	
	//요소 가져오기(목록)
	//1. http://localhost:8090/address
	//2. GET
	//3. return JSON
	@GetMapping("/address")
	//@ResponseBody
	public List<AddressDTO> list() {
		
		return dao.list();
	}
	
	//요소 수정하기
	//1. http://localhost:8090/address/1
	//2. PUT
	//3. return int
	@PutMapping("/address/{seq}")
	public int edit(@PathVariable("seq") String seq, @RequestBody AddressDTO dto) {
		
		dto.setSeq(seq);
		
		return dao.edit(dto);
	}
	
	//요소 삭제하기
	//1. http://localhost:8090/address/1
	//2. DELETE
	//3. return int 
	@DeleteMapping("/address/{seq}")
	public int del(@PathVariable("seq") String seq) {
		
		return dao.del(seq);
	}
	
	//요소 검색하기
	//1. http://localhost:8090/address/검색어
	//2. GET
	//3. return JSON
	//@GetMapping("/address/{word}/{word2}")
	@GetMapping("/address/{word}")
	//public List<AddressDTO> search(@PathVariable("word") String word, @PathVariable("word") String word){
	public List<AddressDTO> search(@PathVariable("word") String word){
		
		return dao.search(word);
	}
	

	
}





















