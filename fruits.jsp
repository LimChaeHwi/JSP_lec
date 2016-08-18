<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action ="fruits_result.jsp" method="get">
	<input type="checkbox" name="fruits" value="사과">사과<br>
	<input type="checkbox" name="fruits" value="바나나">바나나<br>
	<input type="checkbox" name="fruits" value="딸기">딸기<br>
	<input type="checkbox" name="fruits" value="포도">포도<br>
	<input type="submit" value="장바구니에 담기"/>
</form>
<%
	RequestDispatcher rd = request.getRequestDispatcher("fruits_result.jsp");
	String c = request.getParameter("c");

	if(c!=null&&c.equals("1")){
		request.setAttribute("b", c);
		rd.forward(request, response);
	}
	if(c!=null&&c.equals("2")){
		request.setAttribute("b", c);
		rd.forward(request, response);
	}
	
%>