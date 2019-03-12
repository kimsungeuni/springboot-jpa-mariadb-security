package com.wastack.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wastack.blog.domain.Board;
import com.wastack.blog.domain.ResponseData;
import com.wastack.blog.repository.BoardRepository;

@Service
@Transactional
public class BoardServiceImpl implements BoardSerivce{
	@Autowired
	BoardRepository boardRp;

	@Override
	public ResponseData add(Board board) {
		ResponseData rd=new ResponseData();
		try {
			//jpa초기화
			board.setBoardindex(null);
			rd.setData(boardRp.save(board));
			rd.setFlag(true);
			rd.setMessage("게시판등록완료");
		}catch(Exception e) {
			rd.setFlag(false);
			rd.setMessage("게시판등록실패");
		}
		return rd;
	}

	@Override
	public ResponseData modify(Board board) {
		ResponseData rd=new ResponseData();
		try {
			if(board.getBoardindex()==null) {
				throw new Exception();
			}
			rd.setData(boardRp.save(board));
			rd.setFlag(true);
			rd.setMessage("게시판등록완료");
		}catch(Exception e) {
			rd.setFlag(false);
			rd.setMessage("게시판등록실패");
		}
		return rd;
	}

	@Override
	public ResponseData view(Integer boardindex) {
		ResponseData rd=new ResponseData();
		try {
			rd.setData(boardRp.findByBoardindex(boardindex));
			rd.setFlag(true);
		}catch(Exception e) {
			rd.setFlag(false);
			rd.setMessage("게시판등록실패하였습니다.");
		}
		return rd;
	}

	@Override
	public ResponseData all() {
		ResponseData rd=new ResponseData();
		try {
			rd.setData(boardRp.findAll());
			rd.setFlag(true);	
		}catch(Exception e) {
			rd.setFlag(false);	
			rd.setMessage("서버오류");
		}
		return rd;
	}

	@Override
	public ResponseData remove(Integer boardindex) {
		ResponseData rd=new ResponseData();
		try {
			rd.setData(boardRp.deleteByBoardindex(boardindex));
			rd.setFlag(true);	
			rd.setMessage("삭제성공");
		}catch(Exception e) {
			rd.setFlag(false);	
			rd.setMessage("삭제에 실패 하였습니다");
		}
		return rd;
	}

}
