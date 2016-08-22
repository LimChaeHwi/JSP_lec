package edu;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{
	
	//ServletContext객체 삭제시 = 서버 중지
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//ServletContext객체 호출시 = 서버 시작
	//web application 실행에 관한 초기 환경 세팅
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ServletContext 객체 생성됨!!");
	}
	
}
