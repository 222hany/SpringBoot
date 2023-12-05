<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.kh.model.vo.DTO" %>
<%@ page import="java.util.List" %>
<%
	List<DTO> userList = (List<DTO>) request.getAttribute("userList");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>검색 결과</title>
	</head>
	<body>
		<h1>검색 결과</h1>
		<table border="1">
			<thead>
				<tr> 
					<th>회원 번호</th>
					<th>회원 ID</th>
					<th>회원 이름</th>
					<th>회원 나이</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(DTO user : userList){
				%>
				<tr>
					<td><%= user.getUser_number() %></td>
					<td><%= user.getUser_id() %></td>
					<td><%= user.getUser_name() %></td>
					<td><%= user.getUser_age() %></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</body>
</html>