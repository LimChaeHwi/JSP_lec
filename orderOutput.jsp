<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int mn(String[] ba, HttpServletRequest req){
	int sum =0;

	
		for(int i = 0;i<ba.length;i++){
			switch(ba[i]){
			case "콜라(500원)": sum+=500; break;
			case "환타(500원)": sum+=500; break;
			case "봉봉(900원)": sum+=900; break;
			case "사이다(600원)": sum+=600; break;
			case "밀키스(700원)": sum+=700; break;
			case "맥스웰(400원)": sum+=400; break;
			}
		}
	
	return sum;
	}
%>
<h1>주문결과</h1>
<table border="1">
	<tr>
		<td colspan="2">음료 자판기</td>
	</tr>
	<tr>
		<td>넣은 금액</td>
		<td>${param.money }</td>
	</tr>
	<tr>
		<td>선택 상품</td>
		<td>
<%
	String[] str = request.getParameterValues("ba");
	for(int i = 0;i<str.length;i++){
%>		
	<%=str[i] %><br>
	<%} %>
		</td>
	</tr>
	<tr>
		<td>잔액</td>
		<td>
		<%
		int sum =Integer.parseInt(request.getParameter("money"))-mn(str,request);
		%>
		
		<%=sum %>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="orderInput.jsp">
				<input type="submit" value="자판기화면">
			</a>
		</td>
	</tr>
</table>