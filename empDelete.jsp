<%@page import="edu.EmployeeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action = "searchEmpno" method="post">
	사번 : 
	<input type="text" name="empno">
	<input type="hidden" name="url" value="/empDelete.jsp">
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
			<h3>사원 정보 삭제</h3>
<form action="empDelete" method="post">
	사번:<input type="number" name="empno" value="<%=vo.getEmpno() %>" readonly><br>
	이름:<input type="text" name="ename" value="<%=vo.getEname()%>" readonly><br>
	직무:<input type="text" name="job" value="<%=vo.getJob()%>" readonly><br>
	관리자:<input type="number" name="mgr" value="<%=vo.getMgr()%>" readonly><br>
	입사일:<input type="date" name="hiredate" value="<%=vo.getHiredate()%>" readonly><br>
	급여:<input type="number" name="sal" value="<%=vo.getSal()%>" readonly><br>
	성과금:<input type="number" name="comm" value="<%=vo.getComm()%>" readonly><br>
	부서번호:<input type="number" name="deptno" value="<%=vo.getDeptno()%>" readonly><br>
	<input type="submit" value="정보삭제"/>
</form>
<% 
			}
		}else{
%>			
	<h3>해당 사원번호가 존재하지 않습니다.</h3>
<% 			
		}
	}

	if(request.getAttribute("result")!=null){
		if((boolean)request.getAttribute("result")==true){
%>
	"<%=request.getAttribute("empno")%>" 삭제 완료!
<%			
		}else{
			
		}
	}
%>