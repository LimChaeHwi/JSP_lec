package edu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter2 implements Filter{
	//Filter��ü ������ ȣ��� : �ʱ�ȭ
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter2�� init()");
	}
	//������ ������ ��û�� ����� : ���� ���� ���� ����
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter2�� before");
		chain.doFilter(req, res);
		System.out.println("MyFilter2�� after");
	}
	//Filter ��ü ������ ȣ��� : �ڿ�����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
