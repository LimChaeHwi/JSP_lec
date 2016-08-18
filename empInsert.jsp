<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="empInsert" method="post">
	사번:<input type="number" name="empno"><br>
	이름:<input type="text" name="ename"><br>
	직무:<input type="text" name="job"><br>
	관리자:<input type="number" name="mgr"><br>
	입사일:<input type="date" name="hiredate"><br>
	급여:<input type="number" name="sal"><br>
	성과금:<input type="number" name="comm"><br>
	부서번호:<input type="number" name="deptno"><br>
	<input type="submit" value="등록"/>
</form>
<%
	if(request.getAttribute("result")!=null){
		if((boolean)request.getAttribute("result")==true){
%>
	"<%=request.getAttribute("ename")%>" 등록 완료!
<%			
		}
	}
%>