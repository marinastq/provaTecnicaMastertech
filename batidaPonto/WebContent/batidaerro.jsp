<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PONTO ELETRÔNICO</title>
</head>
<body>
	<p>Erro:</p>
	<p style="color:red;"><b><c:out value="${mensagem}" /></b></p>
	
	<input type="submit" value="Voltar" name="action"/>
</body>
</html>