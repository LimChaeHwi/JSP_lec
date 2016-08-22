package edu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter{
	//Filter��ü ������ ȣ��� : �ʱ�ȭ
	String charset;
	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter1�� init()");
		charset= fc.getInitParameter("ko");
	}
	//������ ������ ��û�� ����� : ���� ���� ���� ����
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter1�� before");
		//Filter�� �̿��� �ѱ� ó��
		req.setCharacterEncoding(charset);
		res.setContentType("text/html;charset="+charset);
		chain.doFilter(req, res);
		System.out.println("MyFilter1�� after");
	}
	//Filter ��ü ������ ȣ��� : �ڿ�����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
