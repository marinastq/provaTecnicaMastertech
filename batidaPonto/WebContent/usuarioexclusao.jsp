<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
<!DOCTYPE html>
<html>
	<head>
		<title>PONTO ELETRÔNICO</title>
	</head>
	<body>
		<h1>PONTO ELETRÔNICO</h1>
		<h2>Cadastro de Usuário</h2>
		<h3>Excluir usuário </h3>
		<p><c:out value="${mensagem}" /></p>
		<form action="CadastraUsuario" method="post">
			<input name="id" type="hidden" value="${usuario.id}">
			<p> 
				ID: <c:out value="${usuario.id}" /> 
			</p>
				Nome: <c:out value="${usuario.nome}" />
			</p>
			<p>
				CPF: <c:out value="${usuario.cpf}" />
			</p>
			<p>
				E-mail:<c:out value="${usuario.email}" />
			</p>
			<p>
				Data de cadastro: 
				<fmt:formatDate value="${usuario.dataCadastro}" type="date" pattern="dd/MM/yyyy"/>
			</p>
			</br>
			<input type="submit" value="Voltar" name="action"/>
			<input type="submit" value="Excluir" name="action"/>
		</form>
	</body>
</html>