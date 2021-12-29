package com.javaex.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	public BookDao() {
		
	}
	
	public void bookInsert(String title, String pubs, String pubdate, int authorId) {
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
		    query += "insert into book";
		    query += " values(seq_book_id.nextval, ?, ?, ?, ?) ";
		    
		    // 문자열 쿼리문으로 만들기
		    pstmt= conn.prepareStatement(query);
		    
		    // 바인딩
		    pstmt.setString(1, title); // title
		    pstmt.setString(2, pubs); // pubs
		    pstmt.setString(3, pubdate); // pub_date		   
		    pstmt.setInt(4, authorId); // author_id

		    // 실행
		    int count= pstmt.executeUpdate();	    
		    		   
		    // 4.결과처리	    
		   System.out.println(count+"건이 저장되었습니다. (책)");
		        	    
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
	
	public void bookUpdate(String title, String pubs, String pubdate, int authorId, int bookId) {
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
		    query += " update 	book ";
		    query += " set 		title= ?, ";
		    query += " 	   		pubs= ?, ";
		    query += " 	   		pub_date= ?, ";
		    query += " 	   		author_id= ? ";
		    query += " where	book_id= ? ";
			
		    // 문자열 쿼리문으로 만들기
		    pstmt= conn.prepareStatement(query);
		    
		    // 바인딩
		    pstmt.setString(1, title);
		    pstmt.setString(2, pubs);
		    pstmt.setString(3, pubdate);
		    pstmt.setInt(4, authorId);
		    pstmt.setInt(5, bookId);
		    
		    int count= pstmt.executeUpdate();
		    
		    // 4.결과처리
		    System.out.println(count+"건이 수정되었습니다.");
		    
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
	
	public void bookDelete(int bookId) {
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
		    query += " delete from book ";
		    query += " where	   book_id= ? ";
			
		    // 문자열 쿼리문으로 만들기
		    pstmt= conn.prepareStatement(query);
		    
		    // 바인딩
		    pstmt.setInt(1, bookId);
		    
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
	
	public List<BookVo> bookSelect() {
		List<BookVo> bookList= new ArrayList<BookVo>();
		
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
			query += "          to_char(pub_date, 'YYYY-MM-DD') pubdate, ";
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
            	String pubdate= rs.getString("pubdate");
            	int authorId= rs.getInt("id");
            	String authorName= rs.getString("author_name");
            	String authorDesc= rs.getString("author_desc");
            	// System.out.println(bookId+", "+title+", "+pubs+", "+pub_date+", "+authorId+", "+authorName+", "+authordesc);
            	
            	BookVo vo= new BookVo(bookId, title, pubs, pubdate, authorId, authorName, authorDesc);
            	bookList.add(vo);
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
		return bookList;
	}
}
