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
	
//	@Autowired
//	private BoardService boardService;
	
	@RequestMapping(value = "/boardlist")
	public String boardlist(Model model, HttpServletRequest request) {
		
		IDao idao = sqlSession.getMapper(IDao.class);
		List<BoardDto> boardDtos = idao.boardlistDao();
		int bCount = idao.boardcountDao();
//		int bCount = boardService.getBoardCount();
		
		model.addAttribute("boardDtos", boardDtos);
		model.addAttribute("bCount", bCount);
		
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
	
	@RequestMapping(value = "/content_view")
	public String content_view(Model model, HttpServletRequest request) {
		
		String bnum = request.getParameter("bnum");
		IDao idao = sqlSession.getMapper(IDao.class);
		BoardDto boardDto = idao.boardContentViewDao(bnum);
		
		model.addAttribute("boardDto", boardDto);
		
		return "contentview";
	}
	
	@RequestMapping(value = "/content_modify")
	public String content_modify(Model model, HttpServletRequest request) {
		
		String bnum = request.getParameter("bnum");
		IDao idao = sqlSession.getMapper(IDao.class);
		BoardDto boardDto = idao.boardContentViewDao(bnum);
		
		model.addAttribute("boardDto", boardDto);
		
		return "contentModify";
	}
	
	@RequestMapping(value = "/content_modifyOk")
	public String content_modifyOk(Model model, HttpServletRequest request) {
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bnum = request.getParameter("bnum");
		
		IDao idao = sqlSession.getMapper(IDao.class);
		int result = idao.boardModifyDao(btitle, bcontent, bnum);
		if(result == 0) { // 수정 실패시
			return "redirect:content_modify?bnum="+bnum;
		}
		BoardDto boardDto = idao.boardContentViewDao(bnum);
		model.addAttribute("boardDto", boardDto);
		
		return "contentview";
	}
}
