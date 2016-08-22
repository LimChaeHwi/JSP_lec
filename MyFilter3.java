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
	//Filter��ü ������ ȣ��� : �ʱ�ȭ
	ServletContext sc;
	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		sc = fc.getServletContext();
		System.out.println("MyFilter3�� init()");
	}
	//������ ������ ��û�� ����� : ���� ���� ���� ����
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter3�� before");
		long st = System.currentTimeMillis();
		chain.doFilter(req, res);
		long en = System.currentTimeMillis();
		System.out.println("MyFilter3�� after");
		System.out.println("����ð�: "+(en-st));
		sc.log("IP :"+req.getRemoteAddr());
		sc.log("����ð�: "+(en-st));
	}
	//Filter ��ü ������ ȣ��� : �ڿ�����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
