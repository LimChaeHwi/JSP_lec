<%@page import="edu.EmployeeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action = "searchList" method="get">
	<input type="hidden" name="url" value="/empList.jsp">
	<input type="submit" value="검색"/>
</form>    
<%
	if(request.getAttribute("list")!=null){
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();	
		list = (ArrayList<EmployeeVO>)request.getAttribute("list");
		if(list.size()>0){
%>
<table border="1">
	<tr>
		<td>사번</td>
		<td>이름</td>
		<td>직무</td>
		<td>관리자</td>
		<td>입사일</td>
		<td>급여</td>
		<td>수수료</td>
		<td>부서</td>
	</tr>
<% 			
		for (int i = 0; i < list.size(); i++) {
			EmployeeVO vo = list.get(i);
%>		
	

	<tr>
		<td><%=vo.getEmpno() %></td>
		<td><%=vo.getEname()%></td>
		<td><%=vo.getJob()%></td>
		<td><%=vo.getMgr()%></td>
		<td><%=vo.getHiredate()%></td>
		<td><%=vo.getSal()%></td>
		<td><%=vo.getComm()%></td>
		<td><%=vo.getDeptno()%></td>
	</tr>	
			
<% 
			}
%>
</table>
<% 			
		}else{
%>			
	<h3>해당 사원번호가 존재하지 않습니다.</h3>
<% 			
		}
	}
%>