<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.seeyon.apps.portal.test.*" %>
<%@ page import="com.seeyon.apps.portal.test.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>黑桃二组开发环境搭建</h1>
<jsp:useBean id="u" class="com.seeyon.apps.portal.test.User" scope="request"></jsp:useBean>
         
      <jsp:setProperty property="*" name="u"/> 
   
      <%
      	
         User user =(User) request.getAttribute("u");
         response.getWriter().write(user.toString()); 
       %>
       <c:forEach items="${users}" var="user">
          
        </c:forEach>
	<jsp:forE>
</body>
</html>