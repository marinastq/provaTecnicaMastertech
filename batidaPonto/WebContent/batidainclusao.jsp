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
		<h2>Batida de Ponto</h2>
		<form action="BatidaPonto" method="post">
			<p>
				ID Usuário: 
				<input type="text" name="id" value="${batida.id}" size="10"/>
			</p>
			<p>
				Data: 
				<input type="datetime-local" name="dataBatida" value="${batida.dataBatida}" size="20"/>
				
			</p>
			<p>
				Tipo Batida:
				<input type="radio" name="tipo" value="E"/>Entrada
				<input type="radio" name="tipo" value="S"/>Saída
			</p>
			
			<input type="submit" value="Voltar" name="action"/>
			<input type="submit" value="Ok" name="action"/>
		</form>
		<br>
		<h2>Consulta</h2>
		<form action="BatidaPonto" method="post">
			<p>
				ID Usuário: 
				<input type="text" name="id" value="${batida.id}" size="10"/>
			</p>
			<input type="submit" value="Voltar" name="action"/>
			<input type="submit" value="Consultar" name="action"/>
		</form>
		
		
</body>
</html>