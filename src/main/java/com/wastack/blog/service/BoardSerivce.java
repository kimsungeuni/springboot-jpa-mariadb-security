package com.wastack.blog.service;

import java.util.List;

import com.wastack.blog.domain.Board;
import com.wastack.blog.domain.ResponseData;

public interface BoardSerivce {
	//등록
	ResponseData add(Board board);
	
	//수정
	ResponseData modify(Board board);
	
	//상세보기
	ResponseData view(Integer boardindex);
		
	//삭제
	ResponseData remove(Integer boardindex);
	
	//전체조회
	ResponseData all();
	
}
