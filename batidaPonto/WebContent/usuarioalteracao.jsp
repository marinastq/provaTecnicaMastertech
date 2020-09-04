<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>PONTO ELETR�NICO</title>
	</head>
	<body>
		<h1>PONTO ELETR�NICO</h1>
		<h2>Cadastro de Usu�rio</h2>
		<h3>Alterar usu�rio </h3>
		<form action="CadastraUsuario" method="post">
			<input name="id" type="hidden" value="${usuario.id}">
			<p> 
				ID: <c:out value="${usuario.id}" />
			</p>
			<p>
				Nome: 
				<input type="text" name="nome" value="${usuario.nome}" size="50" required/>
			</p>
			<p>
				CPF: 
				<input type="text" name="cpf" value="${usuario.cpf}" size="15" required/>
			</p>
			<p>
				E-mail: 
				<input type="text" name="email" value="${usuario.email}" required/>
			</p>
			<p>
				Data de cadastro: 
				<fmt:formatDate value="${usuario.dataCadastro}" type="date" pattern="dd/MM/yyyy hh:mm"/>
			</p>
			<br>
			<input type="submit" value="Voltar" name="action"/>
			<input type="submit" value="Alterar" name="action"/>
		</form>
	</body>
</html>