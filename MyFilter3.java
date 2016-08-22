package edu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter3 implements Filter{
	//Filter객체 생성시 호출됨 : 초기화
	ServletContext sc;
	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		sc = fc.getServletContext();
		System.out.println("MyFilter3의 init()");
	}
	//매핑한 페이지 요청시 실행됨 : 실제 필터 내용 구현
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter3의 before");
		long st = System.currentTimeMillis();
		chain.doFilter(req, res);
		long en = System.currentTimeMillis();
		System.out.println("MyFilter3의 after");
		System.out.println("수행시간: "+(en-st));
		sc.log("IP :"+req.getRemoteAddr());
		sc.log("수행시간: "+(en-st));
	}
	//Filter 객체 삭제시 호출됨 : 자원해제
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
