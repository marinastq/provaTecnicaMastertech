<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PONTO ELETR�NICO</title>
	</head>
	<body>
		<h1>PONTO ELETR�NICO</h1>
		<h2>Batida de Ponto</h2>
		<form action="BatidaPonto" method="post">
			<p>
				ID Usu�rio: 
				<input type="text" name="id" value="${batida.id}" size="10"/>
			</p>
			<p>
				Data: 
				<input type="datetime-local" name="dataBatida" value="${batida.dataBatida}" size="20"/>
				
			</p>
			<p>
				Tipo Batida:
				<input type="radio" name="tipo" value="E"/>Entrada
				<input type="radio" name="tipo" value="S"/>Sa�da
			</p>
			
			<input type="submit" value="Voltar" name="action"/>
			<input type="submit" value="Ok" name="action"/>
		</form>
		<br>
		<h2>Consulta</h2>
		<form action="BatidaPonto" method="post">
			<p>
				ID Usu�rio: 
				<input type="text" name="id" value="${batida.id}" size="10"/>
			</p>
			<input type="submit" value="Voltar" name="action"/>
			<input type="submit" value="Consultar" name="action"/>
		</form>
		
		
</body>
</html>