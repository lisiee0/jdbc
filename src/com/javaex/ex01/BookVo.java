package com.javaex.ex01;

public class BookVo {
	
	// 필드
	private int bookId;
	private String title;
	private String pubs;
	private String pub_date;
	private int authorId;
	
	// 생성자
	public BookVo() {
		
	}
	
	public BookVo(int bookId, String title, String pubs, String pub_date, int authorId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.authorId = authorId;
	}
	
	
	// 메소드 gs
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPub_date() {
		return pub_date;
	}

	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	// 메소드 일반
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pub_date=" + pub_date
				+ ", authorId=" + authorId + "]";
	}
	
	public void showInfo() {
		System.out.println(this.getBookId()+", "+this.getTitle()+", "+this.getPubs()+", "+this.getPub_date()+", "+this.getAuthorId());
	}
	
	
	
	
	
}
