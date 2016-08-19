<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<script>
	function dollar(money){
		var num = document.getElementById("money").value;
		
		if(money==100){
			alert(num);
			num = num + 100;
			document.getElementById("money").value=num;
		}	
		if(money==500){
			
			alert(num);
			num = num+ 500;
			document.getElementById("money").value=num;
		}
		if(money==1000){
			
			alert(num);
			num = num+ 1000;
			document.getElementById("money").value=num;
		}	
	}
</script>
</head> 
<body>   
<h1>주문입력</h1>
<div id="one" onclick="dollar(100)">100</div>
<div id="two" onclick="dollar(500)">500</div>
<div id="three" onclick="dollar(1000)">1000</div>
<form action="orderOutput.jsp" method="get">
	<table border="1">
		<tr>
			<td colspan="2">음료 자판기</td>
		</tr>
		<tr>
			<td colspan="2">금액입력
				<input type="number" id="money" name="money" >
			</td>
		</tr>
		<tr>
			<td colspan="2">상품을 선택하세요.</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="checkbox" name="ba" value="콜라(500원)"/>콜라(500원)&nbsp;
				<input type="checkbox" name="ba" value="사이다(600원)"/>사이다(600원)<br>
				<input type="checkbox" name="ba" value="환타(500원)"/>환타(500원)&nbsp;
				<input type="checkbox" name="ba" value="맥스웰(400원)"/>맥스웰(400원)<br>
				<input type="checkbox" name="ba" value="봉봉(900원)"/>봉봉(900원)&nbsp;
				<input type="checkbox" name="ba" value="밀키스(700원)"/>밀키스(700원)
				
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="주문"/>
				<input type="reset" value="다시하기"/>
			</td>
		</tr>					
	</table>
</form>
</body>
</html>