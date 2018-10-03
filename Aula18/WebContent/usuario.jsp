<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste Formulário</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>

	<div class="col-sm-6">
		<div class="panel panel-primary painel-cadastro">
			<div class="panel-heading">Usuário:</div>
			<div class="panel-body">
				<form name="frmAddUser" method="post" action="usuarioControler">
					<fieldset>
						<div class="form-group">
							<label for="usuarioCodigo">Código:</label>
							 <input type="number"  readonly="readonly" 
								name="usuarioCodigo"  value="${usuario.codigo}" class="form-control">
						</div>
						<div class="form-group">
							<label for="nome">Nome:</label> 
							<input type="text"  name="nome" placeholder="Nome" value="${usuario.nome}" class="form-control">
						</div>
						<div class="form-group">
							<label>login:</label> <input type="text" value="${usuario.login}"
								name="login" placeholder="Login" class="form-control">
						</div>
						<div class="form-group">
							<label>Matrícula:</label> <input type="number" value="${usuario.matricula}"
								name="matricula" placeholder="Matrícula" class="form-control">
						</div>

					</fieldset>
					<input type="submit" value="Gravar" class="btn btn-primary">
				</form>

			</div>

		</div>
	</div>


</body>
</html>