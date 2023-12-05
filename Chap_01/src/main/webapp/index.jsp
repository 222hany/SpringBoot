<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>유저 정보 조회</title>
	</head>
	<body>
		<h1>사용자 조회</h1>
		<!-- 사용자에게서 입력받은 폼은 action 을 통해 전달 -->
		<form action="selectUser" method="post">
			<label for="userId">사용자 ID : </label>
			<input type="text" id="userId" name="userId" required/>
			<button type="submit">조회</button>
		</form>
	</body>
</html>