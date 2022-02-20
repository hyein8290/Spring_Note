package com.test.spring;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;

	@Override
	public int add(BoardDTO dto, HttpSession session, HttpServletRequest req) {

		// 아이디 추가
		dto.setId(session.getAttribute("id").toString());

		// 첨부 파일 처리
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest) req;

		MultipartFile file = multi.getFile("attach");
		
		String path = req.getRealPath("/resources/file");

		// System.out.println(file.isEmpty());
		if (!file.isEmpty()) {
			
			String filename = file.getOriginalFilename();
			dto.setOrgfilename(filename);
			
			filename = getFileName(path, filename);
			dto.setFilename(filename);

			try {
				File mfile = new File(path + "\\" + filename);
				file.transferTo(mfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return dao.add(dto);
	}

	private String getFileName(String path, String filename) {

		int n = 1;
		int index = filename.lastIndexOf(".");
		String tempName = filename.substring(0, index);
		String tempExt = filename.substring(index);

		while (true) {

			File file = new File(path + "\\" + filename);

			if (file.exists()) {
				filename = tempName + "_" + n + tempExt;
				n++;
			} else {
				return filename;
			}
		}
	}
	
	@Override
	public List<BoardDTO> list() {
		
		List<BoardDTO> list = dao.list();
		
		return dao.list();
	}
	
	@Override
	public BoardDTO get(String seq) {
		
		return dao.get(seq);
	}
	
	@Override
	public int edit(BoardDTO dto, HttpSession session, HttpServletRequest req, String del) {
		
		// 아이디 추가
		dto.setId(session.getAttribute("id").toString());

		// 첨부 파일 처리
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;

		MultipartFile file = multi.getFile("attach");
		
		String path = req.getRealPath("/resources/file");		
		
		BoardDTO mdto = dao.get(dto.getSeq());
		dto.setOrgfilename(mdto.getOrgfilename());
		dto.setFilename(mdto.getFilename());
		
		
		// System.out.println(file.isEmpty());
		if (!file.isEmpty()) { //첨부파일 있음
			
			if(mdto.getFilename() != null) { //수정할 게시물에 첨부파일이 있는 경우
				File delfile = new File(path + "\\" + mdto.getFilename()); // 수정할 게시물의 첨부 파일 참조 객체
				delfile.delete();
			} else { //수정할 게시물에 첨부파일이 없는 경우
				
			}

			String filename = file.getOriginalFilename();
			dto.setOrgfilename(filename);
			
			filename = getFileName(path, filename);
			dto.setFilename(filename);

			try {
				File mfile = new File(path + "\\" + filename);
				file.transferTo(mfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			
			if (del.equals("on")) {
				File delfile = new File(path + "\\" + mdto.getFilename()); //수정할 게시물의 첨부 파일 참조 객체
				delfile.delete();
				
				dto.setOrgfilename(null);
				dto.setFilename(null);
			}
		}

		return dao.edit(dto);
	}
	
	@Override
	public int del(String seq, HttpServletRequest req) {
		
		//첨부파일 삭제
		BoardDTO dto = dao.get(seq);
		
		String path = req.getRealPath("/resources/file");		
		
		File file = new File(path + "\\" + dto.getFilename());
		file.delete(); //첨부 파일 삭제
		
		return dao.del(seq);
	}
}
