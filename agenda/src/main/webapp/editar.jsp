<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	

	
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Agenda de Contatos</title>
		<link rel="icon" href="imagens/iconTelefone.png">
		<link rel="styLesheet" href="style.css">
	</head>
	<body>
		<h1>Editar Contato</h1>
	
		<form name="frmContato" action="update">
			<table>
				<tr>
					<td><input type="text" id="caixa3" name="idcom" readonly="readonly" 
					value="<% out.print(request.getAttribute("idcom"));%>"></td>
				</tr>
				<tr>
					<td><input type="text" class="Caixa1" name="nome"
					value="<% out.print(request.getAttribute("nome"));%>"></td>
				</tr>
	
				<tr>
					<td><input type="text" class="Caixa2" name="fone"
					value="<% out.print(request.getAttribute("fone"));%>"></td>
				</tr>
	
				<tr>
					<td><input type="text" class="Caixa1" name="email"
					value="<% out.print(request.getAttribute("email"));%>"></td>
				</tr>
			</table>
			<input type="button" class="Botao1" value="Atualizar"
				onclick="validar()">
		</form>
		<script type="text/javascript" src="scripts/validador.js"></script>
	</body>
</html>