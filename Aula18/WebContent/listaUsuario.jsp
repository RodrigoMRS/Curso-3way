<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem Livros</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form name="frmAddLivro" method="post" action="livroControler">
		<input type="text"	name="buscarLivro" placeholder="Título"  />
		<input type="submit" value="pesquisar" class="btn btn-primary"/>
	</form>
	<table border=1>		
		
		<thread>
			<tr>
				<th class="list-group-item disabled">Código Usuário</th>
				<th>Nome</th>
				<th>Login</th>
				<th>Matrícula</th>
				<th colspan=2> Action</th>
			</tr>
		</thread>
		<tbody >
			<c:forEach items="${usuarios}" var="usuario">
				
			<tr >
				
				<td><c:out value="${usuario.codigo}"/></td>
				<td><c:out value="${usuario.nome}"/></td>
				<td><c:out value="${usuario.login}"/></td>
				<td><c:out value="${usuario.matricula}"/></td>
				<td><a href='usuarioControler?action=editar&codigoUsuario=<c:out value="${usuario.codigo}"/>'>Update</a></td>
				<td><a href='usuarioControler?action=deletar&codigoUsuario=<c:out value="${usuario.codigo}"/>'>Delete</a></td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>
<p><a href="usuarioControler?action=insert">Adicionar Usuário</a></p>
</body>
</html>