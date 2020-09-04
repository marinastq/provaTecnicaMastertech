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
	<h1>PONTO ELETRÔNICO</h1>
	<h2>Batida de Ponto</h2>
		<table>
	 		<tr>
	   			<td>ID</td>
	   			<td>DATA/HORA</td>
	   			<td>TIPO</td>
	 		</tr>
			<c:forEach var="b" items="${listaBatida}">
				<form action="BatidaPonto" method="post">
					<tr>
			   			<td><c:out value="${b.id}" /></td>
			   			<td><fmt:formatDate value="${b.dataBatida}" type="date" pattern="dd/MM/yyyy hh:mm:ss"/></td>
			   			<td>
				   			<c:choose>
	    						<c:when test="${b.tipo=='E'}">Entrada</c:when>    
	    						<c:otherwise>Saída</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</form>
			</c:forEach>
		</table>
		<br>
		<form action="BatidaPonto" method="post">
			<p>Horas trabalhadas: <c:out value="${horasTrabalhadas}" /></p>
			<input type="submit" value="Voltar" name="action"/>
		</form>	
</body>
</html>