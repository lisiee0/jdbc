package com.javaex.ex03;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao= new AuthorDao();
		
		AuthorVo vo01= new AuthorVo("이문열", "경북 영양");
		
		authorDao.authorInsert(vo01);

	}

}
