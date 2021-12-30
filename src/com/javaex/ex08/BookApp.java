package com.javaex.ex08;

import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		
		List<BookVo> bookList;
		BookDao bookDao= new BookDao();
		
		List<AuthorVo> authorList;
		AuthorDao authorDao= new AuthorDao();
		
		Scanner sc= new Scanner(System.in);
		
		// 작가등록
		AuthorVo vo01= new AuthorVo("이문열", "경북 영양");		
		authorDao.authorInsert(vo01);
		
		AuthorVo vo02= new AuthorVo("박경리", "경상남도 통영");
		authorDao.authorInsert(vo02);
		
		AuthorVo vo03= new AuthorVo("유시민", "17대 국회의원");
		authorDao.authorInsert(vo03);
		
		AuthorVo vo04= new AuthorVo("기안84", "기안동에서 산 84년생");		
		authorDao.authorInsert(vo04);
		
		AuthorVo vo05= new AuthorVo("강풀", "온라인 만화가 1세대");
		authorDao.authorInsert(vo05);
		
		AuthorVo vo06= new AuthorVo("김영하", "알쓸신잡");
		authorDao.authorInsert(vo06);
		
		AuthorVo vo07= new AuthorVo("이고잉", "개발자");
		authorDao.authorInsert(vo07);

		// 책등록
		BookVo bo01= new BookVo("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);		
		bookDao.bookInsert(bo01);
		
		BookVo bo02= new BookVo("삼국지", "민음사", "2002-03-01", 1);		
		bookDao.bookInsert(bo02);
		
		BookVo bo03= new BookVo("토지", "마로니에북스", "2012-08-15", 2);		
		bookDao.bookInsert(bo03);
		
		BookVo bo04= new BookVo("자바프로그래밍 입문", "위키북스", "2015-04-01", 7);		
		bookDao.bookInsert(bo04);
		
		BookVo bo05= new BookVo("패션왕", "중앙북스(books)", "2012-02-22", 4);		
		bookDao.bookInsert(bo05);
		
		BookVo bo06= new BookVo("순정만화", "재미주의", "2011-08-03", 5);		
		bookDao.bookInsert(bo06);
		
		BookVo bo07= new BookVo("오직두사람", "문학동네", "2017-05-04", 6);		
		bookDao.bookInsert(bo07);
		
		BookVo bo08= new BookVo("26년", "재미주의", "2012-02-04", 4);		
		bookDao.bookInsert(bo08);
		
		/*
		// 책수정
		BookVo bookVo= new BookVo("우리들의 일그러진 엄석대", "다림출판사", "2012-12-12", 1, 1);
		bookDao.bookUpdate(bookVo);
		
		// 책삭제
		bookDao.bookDelete(2);
		*/
		
		// 책리스트 출력
		System.out.println("-------------------------------------------------");
		bookList= bookDao.bookSelect();
		for(BookVo bv: bookList) {
			bv.showInfo();
		}
		System.out.println("-------------------------------------------------");
		
		System.out.print("검색어를 입력해주세요: ");
		
		String search= sc.nextLine();

		for(BookVo bv: bookList) {
			if(bv.getTitle().contains(search) || bv.getPubs().contains(search) 
			|| bv.getAuthorName().contains(search)) {
				bv.showInfo();
			}
		
		sc.close();
		}
	}
}
