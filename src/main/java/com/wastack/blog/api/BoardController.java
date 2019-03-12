package com.wastack.blog.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.EnumType;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wastack.blog.domain.Board;
import com.wastack.blog.domain.ResponseData;
import com.wastack.blog.domain.Role;
import com.wastack.blog.domain.User;
import com.wastack.blog.repository.BoardRepository;
import com.wastack.blog.repository.UserRepository;
import com.wastack.blog.service.BoardSerivce;
import com.wastack.blog.service.UserService;
import com.wastack.blog.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BoardController {
	@Autowired
	private BoardSerivce boardSerive;
	
	//추가
	@PostMapping("/board")
	public ResponseData addboard(@RequestBody Board board){
		return boardSerive.add(board);
	}
	
	//조회
	@GetMapping("/board/{boardindex}")
	public ResponseData getboard(@PathVariable Integer boardindex){
		return boardSerive.view(boardindex);
	}
	
	//수정
	@PutMapping("/board")
	public ResponseData updateboard(@RequestBody Board board){
		return boardSerive.modify(board);
	}
	
	//삭제
	@DeleteMapping("/board/{boardindex}")
	public ResponseData removeboard(@PathVariable Integer boardindex){
		return boardSerive.remove(boardindex);
	}
	//전체조회
	@GetMapping("/board")
	public ResponseData allgetboard(){
		return boardSerive.all();
	}

}
