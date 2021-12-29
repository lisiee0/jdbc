package com.javaex.ex04;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		List<AuthorVo> list;
		AuthorDao authorDao= new AuthorDao();
		
		AuthorVo vo01= new AuthorVo("이문열", "경북 영양");		
		authorDao.authorInsert(vo01);
		
		AuthorVo vo02= new AuthorVo("박경리", "경상남도 통영");
		authorDao.authorInsert(vo02);
		
		AuthorVo vo03= new AuthorVo("유시민", "17대 국회의원");
		authorDao.authorInsert(vo03);
		
		
		System.out.println("---------------------------------------");
		list= authorDao.authorSelect();
		for(AuthorVo av: list) {
			av.showInfo();
		}
		System.out.println("---------------------------------------");
		
		
		// 작가수정
		AuthorVo authorVo= new AuthorVo(2, "박경리(수정)", "경상남도 통영(수정)");
		authorDao.authorUpdate(authorVo);
		
		System.out.println("---------------------------------------");
		list= authorDao.authorSelect();
		for(AuthorVo av: list) {
			av.showInfo();
		}
		System.out.println("---------------------------------------");
		
		
		// 작가삭제
		authorDao.authorDelete(2);
		
		System.out.println("---------------------------------------");
		list= authorDao.authorSelect();
		for(AuthorVo av: list) {
			av.showInfo();
		}
		System.out.println("---------------------------------------");
		
	}

}
