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
public class UserController {
	@Autowired
	private UserService userService;
	
	//로그인
	@GetMapping("/user")
	public ResponseData userlogin(String email,String password) {
		return userService.login(email, password);
	}
	//회원가입
	@PostMapping("/user")
	public ResponseData userregister(@RequestBody User user) {
		return userService.register(user);
	}
	//회원수정
	@PutMapping("/user")
	public ResponseData modifyuser(@RequestBody User user) {
		return userService.modify(user);
	}
	//회원탈퇴
	@DeleteMapping("/user")
	public ResponseData userdelete(Integer userindex,String password) {
		return userService.remove(userindex, password);
	}
}
