<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import= "model.JavaBeans" %>
<%@ page import= "java.util.ArrayList" %>

<%
    @SuppressWarnings("unchecked")
    ArrayList<JavaBeans> contatos = (ArrayList<JavaBeans> ) request.getAttribute("contatos");
   
%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Agenda de Contatos</title>
		<link rel="icon" href="imagens/iconTelefone.png">
		<link rel="styLesheet" href="style.css">
	</head>
	<body>
		<h1>Agenda de Contatos</h1>
		<a href="novo.html" class="Botao1" >Novo Contato</a>
		
		<a href="report" class="Botao2" >Relatório</a>
		
		<table id="tabela">
			  <thead>
			     <tr>
			       <th>Id</th>
			       <th>Nome</th>
			       <th>Fone</th>
			       <th>E-mail</th>
			       <th id="acoes">Ações</th>
			       
			     </tr>
			  </thead>
			  <tbody>
			    <% for(int i = 0; i < contatos.size(); i++) {%>
			      <tr>
			       	<td><%= contatos.get(i).getIdcom()%></td>
			       	<td><%= contatos.get(i).getNome()%></td>
			       	<td><%= contatos.get(i).getFone()%></td>
			       	<td><%= contatos.get(i).getEmail()%></td>
			       	<td>
				       	<a href="select?idcom=<%=contatos.get(i).getIdcom() %>" class="Botao1" > Editar</a>
				       	<a href="javascript: confirmar(<%=contatos.get(i).getIdcom() %>)" class="Botao2" > Excluir</a>
			       	</td>
			      </tr>
			      
			    <%} %>
			  </tbody>
		</table>
		 <script  src="scripts/confirmador.js"></script>
	</body>
</html>