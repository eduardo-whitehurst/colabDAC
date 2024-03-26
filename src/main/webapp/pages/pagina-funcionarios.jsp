<%--
  Created by IntelliJ IDEA.
  User: lacer
  Date: 25/03/2024
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="br.com.colabdac.colabdac.entities.Funcionario" %>
<%@ page import ="java.util.List"%>
<%
    List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("funcionarios");
%>
<html>
<head>
    <title>Página de Funcionários</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<table id="tabela">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Função</th>
        <th>Cpf</th>
    </tr>
    </thead>
    <tbody>
    <% if (funcionarios != null) { %>
    <% for(int k=0; k < funcionarios.size(); k++){%>
    <tr>
        <td><%=funcionarios.get(k).getId()%></td>
        <td><%=funcionarios.get(k).getNome()%></td>
        <td><%=funcionarios.get(k).getFuncao()%></td>
        <td><%=funcionarios.get(k).getCpf()%></td>
        <td>
            <a href="selecionaFuncionarios?idFuncionario=<%=funcionarios.get(k).getId()%>"><button>Editar</button></a>
            <a href="removeFuncionarios?idFuncionario=<%=funcionarios.get(k).getId()%>"><button>Remover</button></a>
        </td>
    </tr>
    <% } %>
    <% } else { %>
    <!-- Handle the case where funcionarios is null, e.g., display a message -->
    <tr><td colspan="2">No data available</td></tr>
    <% } %>

    </tbody>
</table>
</body>
</html>