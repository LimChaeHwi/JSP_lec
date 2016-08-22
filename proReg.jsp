<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<jsp:useBean id="p" class="edu.Product" />
<jsp:getProperty property="code" name="p"/><br>
<jsp:getProperty property="name" name="p"/><br>
<jsp:getProperty property="price" name="p"/><br>

<jsp:setProperty property="*" name="p"/>


<hr>

<jsp:getProperty property="code" name="p"/><br>
<jsp:getProperty property="name" name="p"/><br>
<jsp:getProperty property="price" name="p"/><br>