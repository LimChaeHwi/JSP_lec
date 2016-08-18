<%@page import="edu.EmployeeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action = "searchEmpno" method="get">
	사번 : 
	<input type="text" name="empno">
	<input type="hidden" name="url" value="/employee.jsp">
	<input type="submit" value="검색"/>
</form>

<%
	if(request.getAttribute("list")!=null){
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();	
		list = (ArrayList<EmployeeVO>)request.getAttribute("list");
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				EmployeeVO vo = list.get(i);
%>			
			<h3><%=vo.getEmpno() %>
				<%=vo.getEname()%>
				<%=vo.getJob()%>
				<%=vo.getMgr()%>
				<%=vo.getHiredate()%>
				<%=vo.getSal()%>
				<%=vo.getComm()%>
				<%=vo.getDeptno()%></h3>
<% 
			}
		}else{
%>			
	<h3>해당 사원번호가 존재하지 않습니다.</h3>
<% 			
		}
	}
%>
