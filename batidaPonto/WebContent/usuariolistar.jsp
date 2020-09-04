<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>PONTO ELETRÔNICO</title>
</head>
<body>
	<h1>Usuários cadastrados</h1>
		<table>
	 		<tr>
	   			<td>ID</td>
	   			<td>NOME</td>
	   			<td>CPF</td>
	   			<td>E-MAIL</td>
	   			<td>DATA CADASTRO</td>   			
	   			<td colspan=3></td>
	 		</tr>
			<c:forEach var="u" items="${listaUsuario}">
				<form action="CadastraUsuario" method="post">
					<tr>
			   			<td><c:out value="${u.id}" /></td>
			   			<td><c:out value="${u.nome}" /></td>
			   			<td><c:out value="${u.cpf}" /></td>
			   			<td><c:out value="${u.email}" /></td>
			   			<td><fmt:formatDate value="${u.dataCadastro}" type="date" pattern="dd/MM/yyyy hh:mm:ss"/></td>
			   			<td><input type="submit" value="Alterar" name="actionTable"/></td>
			   			<td><input type="submit" value="Excluir" name="actionTable"/></td>
			   			<td><input name="id" type="hidden" value="${u.id}"></td> 
					</tr>
				</form>
			</c:forEach>
		</table>
		<br>
		<form action="CadastraUsuario" method="post">
			<input type="submit" value="Voltar" name="action"/>
		</form>	
</body>
</html>