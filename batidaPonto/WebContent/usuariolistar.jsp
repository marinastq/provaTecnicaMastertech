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
	<h2>Usuários cadastrados</h2>
		<table>
	 		<tr>
	   			<th>ID</th>
	   			<th>Nome</th>
	   			<th>CPF</th>
	   			<th>E-mail</th>
	   			<th>Data cadastro</th>   			
	   			<th colspan=3></th>
	 		</tr>
			<c:forEach var="u" items="${listaUsuario}">
				<form action="CadastraUsuario" method="post">
					<tr>
			   			<td class="idtabela"><c:out value="${u.id}" /></td>
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