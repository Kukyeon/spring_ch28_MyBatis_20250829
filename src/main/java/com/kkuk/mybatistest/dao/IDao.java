package com.kkuk.mybatistest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kkuk.mybatistest.dto.BoardDto;

public interface IDao {
	
	//모든 글 리스트 불러오기 추상메소드 선언
	public List<BoardDto> boardlistDao();
	
	//게시판 글쓰기 추상 메서드
	public void boardWriteDao(String btitle,String bcontent,String bname);
	
	//게시판 글 삭제 추상 메서드
	public List<BoardDto> boardDeleteDao(String bnum);
	
	//모든글 갯수 가져오기 추상메서드 선언
	public int boardcountDao();
	
	//글 내용 보기 추상메서드 선언
	public BoardDto boardContentViewDao(String bnum);
	
	//글 내용 수정 추상 메서드
	public int boardModifyDao(String btitle,String bcontent,String bnum);
	
}
