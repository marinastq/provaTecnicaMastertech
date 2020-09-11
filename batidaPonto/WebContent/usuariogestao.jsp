<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
<!DOCTYPE html>
<html>
	<head>
		<title>PONTO ELETRONICO</title>
	</head>
	<body>
		<h1>PONTO ELETRÔNICO</h1>
		<h2>Cadastro de Usuario</h2>
		<h3>Pesquisar usuario </h3>
		<p>Clique em pesquisar sem preencher o campo ID para listar todos ou informe o ID</p>	
		<form action="CadastraUsuario" method="post">
			<p> 
				ID: 
				<input type="text" name="id"/>
				<input type="submit" value="Pesquisar" name="action"/>
			</p>
			</br>
			<h3>Incluir usuario </h3>
			<p>
				Nome: 
				<input type="text" name="nome"/>
			</p>
			<p>
				CPF: 
				<input type="text" name="cpf"/>
			</p>
			<p>
				E-mail: 
				<input type="text" name="email"/>
			</p>
			<input type="submit" value="Voltar" name="action"/>
			<input type="submit" value="Incluir" name="action"/>
			
		</form>
	</body>
</html>