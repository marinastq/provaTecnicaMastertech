<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PONTO ELETRÔNICO</title>
	</head>
	<body>
		<h1>PONTO ELETRÔNICO</h1>
		<h2>Erro:</h2>
		<form action="Controles" method="post">
			<p style="color:red;"><b><c:out value="${erro}" /></b></p>
			
			<input type="submit" value="Voltar" name="action"/>
			</form>
</body>
</html>