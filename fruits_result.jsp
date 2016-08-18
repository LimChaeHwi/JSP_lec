<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
	*초기
	 session에 basket이름으로 list값을 대입
	*과일 추가
	 request를 통해서 fruits를 받아서 str에 넣는다.
	 list에 basket속성인 session을 대입한다. 
	 list가 null이면 basket속성 값인 session에 list를 넣는다.
	 이때까진 session이 null
	 str이 null이 아니면 str을 list에 넣는다.
	 list를 불러온다.
	*과일 삭제
	 b가 null이 아니면 list의 끝값을 삭제.
 -->
<%
	request.setCharacterEncoding("utf-8");
	//선택한 과일을 str에 담는다.
	String[] str = request.getParameterValues("fruits");
	
	ArrayList<String> list = null;
	//session의 basket을 list에 넣는다.
	list = (ArrayList<String>) session.getAttribute("basket");
	//b값이 넘어오면 리스트에서 하나씩 삭제
	if(request.getAttribute("b")!=null&&((String)request.getAttribute("b")).equals("1")){
		list.remove(list.size()-1);
	}
	if(request.getAttribute("b")!=null&&((String)request.getAttribute("b")).equals("2")){
		list.clear();
	}
	//basket이 비워져 있다면 session에 list로 추가
	if (list == null) {
		list = new ArrayList<String>();
		session.setAttribute("basket", list);
	}
	//session에 있는 list에 과일 추가
	if (str != null) {
		for(int i = 0; i<str.length;i++)
			list.add(str[i]);
	}
	//list에 들어있는 과일을 list크기만큼 돌려서 불러온다.
	for (int i = 0; list.size() > 0 && i < list.size(); i++) {
		out.print("<h3>" + list.get(i)+"</h3>");
	}
%>
<br>
<a href="fruits.jsp"><h4>과일 추가</a>&nbsp;&nbsp;&nbsp;
<%if(list.size()>0){ %>
	<a href="fruits.jsp?c=1">과일 제거</a>
	<a href="fruits.jsp?c=2">전체 제거</h4></a>
<%}%>