package com.kkuk.mybatistest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kkuk.mybatistest.dao.IDao;
import com.kkuk.mybatistest.dto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession; // 의존성 자동 주입/DI
	
	@RequestMapping(value = "/boardlist")
	public String boardlist(Model model, HttpServletRequest request) {
		
		IDao idao = sqlSession.getMapper(IDao.class);
		List<BoardDto> boardDtos = idao.boardlistDao();
		
		model.addAttribute("boardDtos", boardDtos);
		
		return "boardlist";
	}
	
	@RequestMapping(value = "/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping(value = "/writeOk")
	public String writeOk(Model model, HttpServletRequest request) {
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bname = request.getParameter("bname");
		
		IDao idao = sqlSession.getMapper(IDao.class);
		idao.boardWriteDao(btitle, bcontent, bname);
		// idao 값이 1이면 글쓰기 성고ㅓㅇ 실패면 0
		return "redirect:boardlist";
	}
	
	@RequestMapping(value = "/deleteForm")
	public String delete() {
		return "deleteForm";
	}
	
	@RequestMapping(value = "/deleteOk")
	public String deleteOk(Model model, HttpServletRequest request) {
		
		String bnum = request.getParameter("bnum");
		IDao idao = sqlSession.getMapper(IDao.class);
		idao.boardDeleteDao(bnum);
		
		return "redict:boardlist";
	}
}
