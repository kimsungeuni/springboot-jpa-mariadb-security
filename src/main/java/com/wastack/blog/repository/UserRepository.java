package com.wastack.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wastack.blog.domain.User;
import java.lang.String;

public interface UserRepository extends JpaRepository<User, Integer>{
	//id중복확인
	User findByEmail(String email);
	//nicname중복확인
	User findBynicname(String nicname);
	//로그인
	User findByEmailAndPassword(String email, String password);
	//회원가입
	User save(User user);
	//회원탈퇴
	int deleteByUserindexAndPassword(Integer userindex,String password);
	
	
}
