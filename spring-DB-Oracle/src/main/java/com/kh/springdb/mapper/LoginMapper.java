package com.kh.springdb.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springdb.model.User;

@Mapper
//interface LoginMapper : 
//             데이터베이스와 관련된 로그인 작업에 대한 메서드를 정의할 것
public interface LoginMapper {
					/*    로그인을 하기 위해 필요한   
						  아이디와 비밀번호 대신
						  mname과 memail을 활용해서 로그인 */
// loginByMnameAndMemail : 로그인을 할 경우 사용되는 사용자 이름과
//    이메일을 입력받아 데이터베이스에서 해당 정보를 조회하고, 그 결과를
//    User 객체를 통해 반환할 것으로 지정해 준 것
	User loginByMnameAndMemail(String mname,String memail);
}