package com.test.spring;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired 
	private ServletContext context;
	
	//테스트 + 템플릿 + List
	@GetMapping("/login")
	public String login(HttpServletRequest req, HttpSession session, String id) {
		
		session.setAttribute("id", id);
		
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(HttpServletRequest req, HttpSession session, Model model) {
		
		List<BoardDTO> list = service.list();
		
		model.addAttribute("list", list);
		
		return "board.list";
	}

	@GetMapping("/add")
	public String madd() {
		
		return "board.add";
	}
	
	@PostMapping("/addok")
	public String maddok(HttpServletRequest req, HttpSession session, HttpServletResponse resp, BoardDTO dto) {
		
		//1. 데이터 가져오기
		//2. 업무 파일
		//3. 뷰 호출
				
		int result = service.add(dto, session, req);
		
		if(result == 1) {
			return "redirect:/list";
		} else {
			return "redirect:/add";
		}
		
	}
	
	@GetMapping("/view")
	public String view(HttpServletRequest req, HttpSession session, HttpServletResponse resp, String seq, Model model) {
		
		BoardDTO dto = service.get(seq);
		
		model.addAttribute("dto", dto);
		
		return "board.view";
	}
	
	@GetMapping("/download")
	public void download(HttpServletRequest req, HttpSession session, HttpServletResponse resp) throws Exception {

		String fileName = req.getParameter("filename");
		String orgfileName = req.getParameter("orgfilename");

		String savePath = "resources/file"; // webapp > files

		String sDownloadPath = context.getRealPath(savePath);

		String sFilePath = sDownloadPath + "/" + fileName;
		byte b[] = new byte[4096];
		FileInputStream in = new FileInputStream(sFilePath);
		String sMimeType = context.getMimeType(sFilePath);
		System.out.println("sMimeType>>>" + sMimeType);

		if (sMimeType == null)
			sMimeType = "application/octet-stream";// 브라우저 반환 MIME
		// text/html
		// image/gif
		// application/zip

		resp.setContentType(sMimeType);
		String agent = req.getHeader("User-Agent");
		boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);

		if (ieBrowser) {
			fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("/+", "%20");
		} else {
			fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
		}

		orgfileName = new String(orgfileName.getBytes("UTF-8"), "ISO-8859-1");

		resp.setHeader("Content-Disposition", "attachment; filename= " + orgfileName);

		ServletOutputStream out2 = resp.getOutputStream();
		int numRead;

		while ((numRead = in.read(b, 0, b.length)) != -1) {
			out2.write(b, 0, numRead);
		}
		out2.flush();
		out2.close();
		in.close();
	}
	
	@GetMapping("/edit")
	public String medit(HttpServletRequest req, HttpSession session, HttpServletResponse resp, String seq, Model model) {
		
		BoardDTO dto = service.get(seq);
		
		model.addAttribute("dto", dto);
		
		return "board.edit";
	}
	
	@PostMapping("/editok")
	public String meditok(HttpServletRequest req, HttpSession session, HttpServletResponse resp, BoardDTO dto, String del) {
		
		//1. 데이터 가져오기
		//2. 업무 파일
		//3. 뷰 호출
				
		int result = service.edit(dto, session, req, del);
		
		if(result == 1) {
			return "redirect:/list";
		} else {
			return "redirect:/edit?seq=" + dto.getSeq();
		}
		
	}
	
	@GetMapping("/del")
	public String mdel(HttpServletRequest req, HttpSession session, HttpServletResponse resp, String seq, Model model) {
				
		model.addAttribute("seq", seq);
		
		return "board.del";
	}
	
	
	@PostMapping("/delok")
	public String mdelok(HttpServletRequest req, HttpSession session, HttpServletResponse resp, String seq) {
				
		int result = service.del(seq, req);
		
		if(result == 1) {
			return "redirect:/list";
		} else {
			return "redirect:/view?seq=" + seq;
		}
		
	}
	
	
	

}



