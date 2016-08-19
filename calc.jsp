<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!public int cal(int a, int b, char exp){
		int result=0;
		String er;
		switch(exp){
			case '+': result = a+b; break;
			case '-': result = a-b; break;
			case '*': result = a*b; break;
			case '/': if(b!=0){ result = a/b; break;}else{er = "0으로 나눌수 없습니다."; break;}
			default : er="연산자를 선택해주세요."; 
		}
		return result;
	}
%>
<form action ="calc.jsp" method="get">
	<input type="number" name="a"><br>
	<select name="exp">
		<option value="">연산자</option>
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
	</select><br>
	<input type="number" name="b"><br>
	<input type="submit" value="계산"/><br>
</form>
<%
	if(request.getParameter("a")!=null){
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		char exp = request.getParameter("exp").charAt(0);
		String str = a+" "+exp+" "+b+" = "+cal(a,b,exp);
		ArrayList<String> list = null;
		list = (ArrayList<String>) session.getAttribute("e");
		if(list==null){
			list = new ArrayList<String>();
			session.setAttribute("e", list);
		}
		if(str!=null){
			list.add(str);
		}
%>		
		<table>
			<tr>
				<td>
				<%=a %>&nbsp;<%=exp %>&nbsp;<%=b %>&nbsp;=&nbsp;
				<b><%=cal(a,b,exp)%></b>
				</td>
			</tr>
			<tr>
				<td>
<%
for (int i = 0; list.size() > 0 && i < list.size(); i++) {
%>	
	<%= list.get(i)%><br>
<%	
}
%>
				</td>
			</tr>	
		</table>
<%		
	}
%>