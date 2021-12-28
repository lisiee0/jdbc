package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorSelect {

	public static void main(String[] args) {
		
		// 리스트 생성
		List<AuthorVo> authorList= new ArrayList<AuthorVo>();
		
		
		// 작가데이터 가져오기
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		    // 3. SQL문 준비 / 바인딩 / 실행
		    // 문자열 만들기
			String query= "";
			query += " select   author_id id, "; // author_id as id
			query += "          author_name, ";
			query += "          author_desc ";
			query += " from     author ";
			// System.out.println(query);
			
			// 문자열 쿼리문으로 만들기
			pstmt= conn.prepareStatement(query);
			
			// 바인딩--> 생략 ( ? 없음)
			
			// 실행 
			rs= pstmt.executeQuery();
			
		    // 4.결과처리
            while(rs.next()) {
            	/*
            	int authorId= rs.getInt("id"); // 컬럼명이 id로 변경되었기 때문에
            	String authorName= rs.getString("author_name");
            	String authorDesc= rs.getString("author_desc");
            	System.out.println(authorId+"\t"+authorName+"\t"+authorDesc);
            	*/
            	
            	int authorId= rs.getInt(1);
            	String authorName= rs.getString(2);
            	String authorDesc= rs.getString(3);
            	
            	
            	AuthorVo vo= new AuthorVo(authorId, authorName, authorDesc);
            	authorList.add(vo);
            	
            	// System.out.println(authorId+"\t"+authorName+"\t"+authorDesc);
            }
			
            // 출력
            
            for(int i= 0; i<authorList.size(); i++) {
            	AuthorVo authorVo= authorList.get(i);
            	System.out.println(authorVo.getAuthorId()+", "+authorVo.getAuthorName()+", "+authorVo.getAuthorDesc());
            }
			
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
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
