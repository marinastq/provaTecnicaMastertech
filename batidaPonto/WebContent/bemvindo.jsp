<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
<!DOCTYPE html>
<html>
	<head>
		<title>PONTO ELETRÔNICO</title>
	</head>
	<body>
		<h1>PONTO ELETRÔNICO</h1>
		<form action="Controles" method="post">
			<p><input type="submit" value="Gestão de Usuários" name="action"/></p>
			<p><input type="submit" value="Batida de Ponto" name="action"/></p>
		</form>
	</body>
</html>