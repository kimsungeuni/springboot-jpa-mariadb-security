package com.wastack.blog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wastack.blog.domain.ResponseData;
import com.wastack.blog.domain.User;
import com.wastack.blog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseData login(String email,String password) {
		ResponseData rd=new ResponseData();
		try {
			User user=userRepository.findByEmailAndPassword(email,password);
			rd.setFlag(true);
			rd.setMessage(user.getNicname()+"님 반갑습니다.");
			rd.setData(user);
		}catch(Exception e){
			rd.setFlag(false);
			rd.setMessage("회원정보가 맞지 않습니다.");
		}
		return rd;
	}

	@Override
	public ResponseData register(User user) {
		//jpa pk값 초기화
		user.setUserindex(null);
		
		ResponseData rd=new ResponseData();
		try {
			rd.setData(userRepository.save(user));
			rd.setMessage("회원가입 성공!");
			rd.setFlag(true);
			
		}catch(Exception e){
			rd.setFlag(false);
			if(userRepository.findByEmail(user.getEmail())!=null) {
				System.out.println("중복");
				rd.setMessage("이메일 중복되었습니다.");
			}
			else if(userRepository.findBynicname(user.getNicname())!=null) {
				rd.setMessage("닉네임 중복되었습니다.");
				rd.setFlag(false);
			}
			else {
				rd.setMessage("서버오류");
				rd.setFlag(false);
			}
		}
		return rd;
	}

	@Override
	public ResponseData modify(User user) {
		ResponseData rd=new ResponseData();
		try {
			if(user.getUserindex()!=null) {
				rd.setData(userRepository.save(user));
				rd.setFlag(true);
				rd.setMessage(user.getNicname()+"님 회원가입 완료");
			}else {
				throw new Exception();
			}
		}catch(Exception e){
			rd.setFlag(false);
			rd.setMessage("회원가입실패");
		}
		return rd;
	}

	@Override
	public ResponseData remove(Integer userindex,String password) {
		ResponseData rd=new ResponseData();
		
		try {
			if(userRepository.deleteByUserindexAndPassword(userindex,password)==1) {
				rd.setMessage("회원탈퇴하셨습니다");
				rd.setFlag(true);
			}else {
				throw new Exception();
			}
		}catch(Exception e){
			rd.setMessage("회원탈퇴 오류");
			rd.setFlag(false);
		}
		return rd;
	}
}
