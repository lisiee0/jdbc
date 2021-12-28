package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookSelectAll {

	public static void main(String[] args) {
		
		List<BookAllVo> bookallList= new ArrayList<BookAllVo>();
		
		// SELECT - book
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
			String query= "";
			query += " select   book_id, "; 
			query += "          title, ";
			query += "          pubs, ";
			query += "          to_char(pub_date, 'YYYY-MM-DD') pub_date, ";
			query += "          a.author_id id, ";
			query += "          author_name, ";
			query += "          author_desc ";
			query += " from     book b, author a ";
			query += " where    b.author_id= a.author_id ";
			// System.out.println(query);
			
			// 문자열 쿼리문으로 만들기
			pstmt= conn.prepareStatement(query);
			
			// 바인딩--> 생략 ( ? 없음)
			
			// 실행 
			rs= pstmt.executeQuery();
			
		    // 4.결과처리
            while(rs.next()) {           
            	int bookId= rs.getInt("book_id"); 
            	String title= rs.getString("title");
            	String pubs= rs.getString("pubs");
            	String pub_date= rs.getString("pub_date");
            	int authorId= rs.getInt("id");
            	String authorName= rs.getString("author_name");
            	String authorDesc= rs.getString("author_desc");
            	// System.out.println(bookId+", "+title+", "+pubs+", "+pub_date+", "+authorId+", "+authorName+", "+authordesc);
            	
            	BookAllVo vo= new BookAllVo(bookId, title, pubs, pub_date, authorId, authorName, authorDesc);
            	bookallList.add(vo);
            }
            
            // 출력
            for(BookAllVo ba: bookallList) {
            	ba.showInfo();
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
