package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.mapper.UserMapper;
import com.kh.springdb.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	//전체 회원 조회 가져오기
	public List<User> getAllUsers(){
		return userMapper.getAllUsers();
	}
	
	//하나의 회원정보 가져오기
	public User getUserById(int id){
		return userMapper.getUserById(id);
	}
	
	//하나의 회원정보 DB에 저장하기
	public void insertUser(User user){
		userMapper.insertUser(user);
	}
	
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }
	
	//회원의 정보 수정해서 DB에 저장하기
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}
	
	//회원 정보 DB에서 삭제하기
	public void deleteUser(int mno) {
		userMapper.deleteUser(mno);
	}
}
