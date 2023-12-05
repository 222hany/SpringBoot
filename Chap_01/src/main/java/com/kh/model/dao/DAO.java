package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.DTO;

public class DAO { // 사용자를 조회하기 위해 작성할 SQL문 생성
	
	// 1. 사용자가 있는지 확인하기 위해 전체 사용자를 조회하는 SQL문 작성
	public static List<DTO> selectAllUsers() throws SQLException {
		// 1-1 커넥션 연결하기 위한 getConnection()만 작성
		Connection conn = JDBCTemplate.getConnection(); // JDBCTemplate 역할 : applicationProperties에서 SQL을 만들었던 것처럼 따로 생성.
		// 1-2 PreparedStatement 연결하기 위해 null값으로 초기화
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 1-3 List 로 조회된 내용을 모두 담을 수 있는 배열 생성
		List<DTO> userList = new ArrayList<>();
		try {
			String query = "SELECT * FROM TEST_USER";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			// 전체 출력같은 경우 while문을 이용하여 전체 출력
			while(rs.next()) {
				DTO user = new DTO();
				user.setUser_number(rs.getInt("user_number"));
				user.setUser_id(rs.getString("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_age(rs.getInt("user_age"));
				userList.add(user);
			}
		}finally{
				// close 문구 작성
				pstmt.close();
				rs.close();
				conn.close();
		}
		return userList;
	}

	// 2. 내가 검색한 사용자가 있는지 확인하기 위해 입력한 사용자를 조회하는 SQL문 작성
	public static List<DTO> selectUserById(String userId) throws SQLException{
		// 1-1 커넥션 연결하기 위한 getConnection()만 작성
		Connection conn = JDBCTemplate.getConnection(); // JDBCTemplate 역할 : applicationProperties에서 SQL을 만들었던 것처럼 따로 생성.
		// 1-2 PreparedStatement 연결하기 위해 null값으로 초기화
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 1-3 List 로 조회된 내용을 모두 담을 수 있는 배열 생성
		List<DTO> userList = new ArrayList<>();
		
		// 한명을 조회했을 경우를 SQL로 작성하고 결과를 pstmt로 받아와서 resultSet에 넣고 if문을 사용하여 result로 가져오기
		try {
			String query = "SELECT * FROM test_user WHERE user_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DTO user = new DTO();
				user.setUser_number(rs.getInt("user_number"));
				user.setUser_id(rs.getString("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_age(rs.getInt("user_age"));
				userList.add(user);
			}
		} finally {
			// close resultSet & PreparedStatement & Connection
			pstmt.close();
			rs.close();
			conn.close();
		}
		return userList;
	}
}