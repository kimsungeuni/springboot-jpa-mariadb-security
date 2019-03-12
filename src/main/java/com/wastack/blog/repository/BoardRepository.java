package com.wastack.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wastack.blog.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	//게시판 등록 및 수정
	Board save(Board board);
	
	//게시판 뷰
	Board findByBoardindex(Integer boardindex);
	
	//게시판 삭제
	Integer deleteByBoardindex(Integer boardindex);
	
	//전체조회
	List<Board> findAll();
	//
	
	
}
