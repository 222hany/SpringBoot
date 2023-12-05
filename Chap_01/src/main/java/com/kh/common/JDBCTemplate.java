package com.kh.common; // common으로 끝나는 패키지명은 여러 코드에서 공통으로 사용되는 기능을 담당하는 역할로 패키지명을 쓰기도 함.
					   //또는 common 대신 util이라는 이름을 사용하기도 함.
import java.sql.Connection;
import java.sql.SQLException;


public class JDBCTemplate {
	// Connection을 연결하기위해 객체를 생성
	public static Connection getConnection() throws SQLException{  // 예외처리를 위해 SQLException을 throws 해줌
		return OracleConnectionProvider.getConnection();
	}
}