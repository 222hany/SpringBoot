package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.DAO;
import com.kh.model.vo.DTO;

@WebServlet("/selectUser")
public class UserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자로부터 입력받은 데이터 처리 및 DAO 호출 작업을 수행
		// List로 조회된 결과를 가지고 옴
		try {
			// 전체조회 : List<DTO> userList = DAO.selectAllUsers(); // 전체조회는 input 값을 넣을 필요가 없기 때문에 doPost가 아닌 doGet으로 써줌
			// id 1개 조회 : 사용자가 입력한 ID 가져오기
			String userId= request.getParameter("userId");
			List<DTO> userList = DAO.selectUserById(userId);
			// 2. 값이 일치할 경우 
			
			if(userList != null && !userList.isEmpty()) { // 1. if문이 만약 비어있지 않거나 null 값이 아닐 때는 전체 조회 (while문을 먼저 작성했기 때문에 먼저 함)
				request.setAttribute("userList", userList);
				request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
			} else { // 3. 검색 결과가 없을 때
				request.getRequestDispatcher("/searchError.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 만약 문제가 생겼을 경우
			response.sendRedirect(request.getContextPath() + "/err.jsp");
		}
	}

}