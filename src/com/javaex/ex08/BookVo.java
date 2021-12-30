package com.javaex.ex08;

public class BookVo {
	
	// 필드
	private int bookId;
	private String title;
	private String pubs;
	private String pubdate;
	private int authorId;
	private String authorName;
	private String authorDesc;
	
	// 생성자
	public BookVo() {
		
	}
	public BookVo(String title, String pubs, String pubdate, int authorId) {
		this.title = title;
		this.pubs = pubs;
		this.pubdate = pubdate;
		this.authorId = authorId;
	}
	
	public BookVo(String title, String pubs, String pubdate, int authorId, int bookId) {
		this.title = title;
		this.pubs = pubs;
		this.pubdate = pubdate;
		this.authorId = authorId;
		this.bookId = bookId;
	}
	public BookVo(int bookId, String title, String pubs, String pubdate, int authorId, String authorName,
			String authorDesc) {
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubdate = pubdate;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
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

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	
	// 메소드 일반
	@Override
	public String toString() {
		return "BookAllVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pub_date=" + pubdate
				+ ", authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}

	public void showInfo() {
		System.out.println(this.getBookId()+", "+this.getTitle()+", "+this.getPubs()+", "+this.getPubdate()+", "+this.getAuthorId()
							+", "+this.getAuthorName()+", "+this.getAuthorDesc());
	}
	
}
