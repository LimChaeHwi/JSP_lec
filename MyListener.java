package edu;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{
	
	//ServletContext��ü ������ = ���� ����
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//ServletContext��ü ȣ��� = ���� ����
	//web application ���࿡ ���� �ʱ� ȯ�� ����
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext ��ü ������!!");
	}
	
}
