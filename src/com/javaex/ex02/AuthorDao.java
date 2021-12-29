package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDao {
	
	public AuthorDao() {
		
	}
	
	public void authorInsert(String authorName, String authorDesc) {		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
		    
			String query= "";
		    // query= query+"문자열"
		    query += "insert into author";
		    query += " values(seq_author_id.nextval, ?, ?) ";
		    
		    // 문자열 쿼리문으로 만들기
		    pstmt= conn.prepareStatement(query);
		    
		    // 바인딩
		    pstmt.setString(1, authorName);  // 첫번째 물음표의 데이터
		    pstmt.setString(2, authorDesc); // 두번째 물음표의 데이터
		    
		    // 실행
		    int count= pstmt.executeUpdate();	    
		    		   
		    // 4.결과처리	    
		    System.out.println(count+ "건이 저장되었습니다. (작가)");

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {               
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }
		}
	}
	
	public void authorDelete(int authorId) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query= "";
		    query += " delete from author ";
		    query += " where	   author_id= ? ";		 
			
		    // 문자열 쿼리문으로 만들기
		    pstmt= conn.prepareStatement(query);
		    
		    // 바인딩
		    pstmt.setInt(1, authorId);
		    
		    int count= pstmt.executeUpdate();
		    
		    // 4.결과처리
		    System.out.println(count+"건이 삭제되었습니다.");
		     
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try { 
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }
		}
	}
}
