package edu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter{
	//Filter객체 생성시 호출됨 : 초기화
	String charset;
	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter1의 init()");
		charset= fc.getInitParameter("ko");
	}
	//매핑한 페이지 요청시 실행됨 : 실제 필터 내용 구현
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter1의 before");
		//Filter를 이용한 한글 처리
		req.setCharacterEncoding(charset);
		res.setContentType("text/html;charset="+charset);
		chain.doFilter(req, res);
		System.out.println("MyFilter1의 after");
	}
	//Filter 객체 삭제시 호출됨 : 자원해제
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
