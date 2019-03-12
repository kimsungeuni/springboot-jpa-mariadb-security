package com.wastack.blog.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wastack.blog.domain.ResponseData;
import com.wastack.blog.domain.User;
import com.wastack.blog.repository.UserRepository;

public interface UserService{
	//로그인
	ResponseData login(String email,String password);
	//회원가입
	ResponseData register(User user);
	//회원정보수정
	ResponseData modify(User user);
	//회원탕퇴
	ResponseData remove(Integer userindex,String password);
}
