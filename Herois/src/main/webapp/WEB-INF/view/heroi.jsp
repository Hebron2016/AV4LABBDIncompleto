<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Heroi</title>
</head>
<body>
	<div>
		<a href="arquivo">Upload de arquivo</a>
	</div>
	<br />
	<div align="center">
		<h1>HEROI</h1>
	</div>
	<br />
	<div align = "center">
		<form action="heroi" method="post">
			<table>
				<tr>
				<td colspan="4">
					<input type="number" step="1" min="0" placeholder="#id" id="id" name="id"
					value='<c:out value ="${heroi.id }"></c:out>'>
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Nome" id="name" name="name"
					value='<c:out value ="${heroi.name }"></c:out>'>
					<input type="submit" id = "botao" name="botao" value="BuscarPorNome">
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="text" placeholder="Genero" id="gender" name="gender"
					value='<c:out value ="${heroi.gender }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Cor dos olhos" id="eyeColor" name="eyeColor"
					value='<c:out value ="${heroi.eyeColor }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Raça" id="race" name="race"
					value='<c:out value ="${heroi.race }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Cor do cabelo" id="hairColor" name="hairColor"
					value='<c:out value ="${heroi.hairColor }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" placeholder="Altura" id="height" name="height"
					value='<c:out value ="${heroi.height }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Publicadora" id="publish" name="publish"
					value='<c:out value ="${heroi.publish }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Cor da pele cabelo" id="skinColor" name="skinColor"
					value='<c:out value ="${heroi.skinColor }"></c:out>'>
				</td>
				</tr>	
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Alinhamento" id="alignment" name="alignment"
					value='<c:out value ="${heroi.alignment }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" placeholder="Peso" id="weight" name="weight"
					value='<c:out value ="${heroi.weight }"></c:out>'>
					<input type="submit" id = "botao" name="botao" value="<">
					<input type="submit" id = "botao" name="botao" value="=">
					<input type="submit" id = "botao" name="botao" value=">">
				</td>
				</tr>			
				<tr>
					<td>
						<input type="submit" id = "botao" name="botao" value="Inserir">
					</td>
					<td>
						<input type="submit" id = "botao" name="botao" value="Atualizar">
					</td>
					<td>
						<input type="submit" id = "botao" name="botao" value="Excluir">
					</td>
					<td>
						<input type="submit" id = "botao" name="botao" value="Listar">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id = "botao" name="botao" value="listarPorPublisher">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
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
		<div align="center">
		<c:if test="${not empty herois }">
			<table border="1">
				<thead>
					<tr>
						<th>#id</th>
						<th>nome</th>
						<th>genero</th>
						<th>cor dos olhos</th>
						<th>raça</th>
						<th>cor do cabelo</th>
						<th>altura</th>		
						<th>Publicadora</th>		
						<th>Cor da pele</th>						
						<th>Alinhamento</th>						
						<th>Peso</th>						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="heroi" items="${herois }">
					<tr>
						<td><c:out value="${heroi.id }" /></td>
						<td><c:out value="${heroi.name }" /></td>
						<td><c:out value="${heroi.gender }" /></td>
						<td><c:out value="${heroi.eyeColor }" /></td>
						<td><c:out value="${heroi.race }" /></td>
						<td><c:out value="${heroi.hairColor }" /></td>
						<td><c:out value="${heroi.height }" /></td>
						<td><c:out value="${heroi.publish }" /></td>
						<td><c:out value="${heroi.skinColor }" /></td>
						<td><c:out value="${heroi.alignment }" /></td>
						<td><c:out value="${heroi.weight}" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>