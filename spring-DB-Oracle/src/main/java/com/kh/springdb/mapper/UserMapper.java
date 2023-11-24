package com.kh.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springdb.model.User;

@Mapper
public interface UserMapper {
	List<User> getAllUsers(); //모든 유저 조회	
	User getUserById(int id); //유저 한명 조회
	
	void insertUser(User user); //유저 추가
}