<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
1
<%
	long st = System.currentTimeMillis();
	for(int i = 2;i<10;i++){
		for(int j=1 ;j<10;j++){
			out.print(i+"*"+j+"="+(i*j));%>
			<br>
<%			
		}
%>
	<br><br>
<%	
	out.flush();
	Thread.sleep(1000);
	}
	long en = System.currentTimeMillis();
	out.print(en-st);
%>