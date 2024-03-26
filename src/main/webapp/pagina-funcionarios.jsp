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
<table id="tabela">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Cpf</th>
    </tr>
    </thead>
    <tbody>
    <% for(int k=0; k < funcionarios.size(); k++){%>
    <tr>
        <td><%=funcionarios.get(k).getId()%></td>
        <td><%=funcionarios.get(k).getNome()%></td>
        <td><%=funcionarios.get(k).getFuncao()%></td>
        <td><%=funcionarios.get(k).getCpf()%></td>
        <td>
            <a href="selecionaFuncionarios?idFuncionario=<%=funcionarios.get(k).getId()%>"><button>Editar</button></a>

        </td>
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>