<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arquivo</title>
</head>
<body>
	<div>
		<a href="heroi">Consulte seus herois</a>
	</div>
	<br />
	<div align="center">
		<h1>ARQUIVO</h1>
	</div>
	<br />
	<div align = "center">
		<form action="arquivo" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="text" placeholder="Path do Arquivo" id="arquivo" name="arquivo">
				</td>
				<tr>
					<td>
						<input type="submit" id = "botao" name="botao" value="enviarArquivo">
					</td>
			</table>
		</form>
	</div>
	<br>
	<br>
	<div align="center">
		<c:if test="${not empty saida }">
			<c:out value="${saida }" />
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty erro }">
			<c:out value="${erro }" />
		</c:if>
	</div>
</body>
</html>