package com.javaex.ex07;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		List<BookVo> list;
		BookDao bookDao= new BookDao();
		
		// 책등록
		BookVo vo01= new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);		
		bookDao.bookInsert(vo01);
		
		BookVo vo02= new BookVo("삼국지", "민음사", "2002-03-01", 1);		
		bookDao.bookInsert(vo02);
		
		BookVo vo03= new BookVo("토지", "마로니에북스", "2012-08-15", 2);		
		bookDao.bookInsert(vo03);
		
		BookVo vo04= new BookVo("유시민의 글쓰기 특강", "생각의길", "2015-04-01", 3);		
		bookDao.bookInsert(vo04);
		
		BookVo vo05= new BookVo("패션왕", "중앙북스(books)", "2012-02-22", 4);		
		bookDao.bookInsert(vo05);
		
		BookVo vo06= new BookVo("순정만화", "재미주의", "2011-08-03", 5);		
		bookDao.bookInsert(vo06);
		
		BookVo vo07= new BookVo("오직두사람", "문학동네", "2017-05-04", 6);		
		bookDao.bookInsert(vo07);
		
		BookVo vo08= new BookVo("26년", "재미주의", "2012-02-04", 4);		
		bookDao.bookInsert(vo08);
		
		System.out.println("INSERT TEST--------------------------------------");
		list= bookDao.bookSelect();
		for(BookVo bv: list) {
			bv.showInfo();
		}
		System.out.println("-------------------------------------------------");
		
		
		// 책수정
		BookVo bookVo= new BookVo("우리들의 일그러진 엄석대", "다림출판사", "2012-12-12", 1, 1);
		bookDao.bookUpdate(bookVo);
		
		System.out.println("UPDATE TEST--------------------------------------");
		list= bookDao.bookSelect();
		for(BookVo bv: list) {
			bv.showInfo();
		}
		System.out.println("-------------------------------------------------");
		
		// 책삭제
		bookDao.bookDelete(2);
		
		System.out.println("DELETE TEST--------------------------------------");
		list= bookDao.bookSelect();
		for(BookVo bv: list) {
			bv.showInfo();
		}
		System.out.println("-------------------------------------------------");
		
		// 책리스트 출력
		System.out.println("-------------------------------------------------");
		list= bookDao.bookSelect();
		for(BookVo bv: list) {
			bv.showInfo();
		}
		System.out.println("-------------------------------------------------");
	}
}
