<%--
  Created by IntelliJ IDEA.
  User: lacer
  Date: 25/03/2024
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="br.com.colabdac.colabdac.entities.Cliente" %>
<%@ page import ="java.util.List"%>
<%
    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
%>
<html>
<head>
    <title>Página de Clientes</title>
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
    <% for(int k=0; k < clientes.size(); k++){%>
    <tr>
        <td><%=clientes.get(k).getId()%></td>
        <td><%=clientes.get(k).getNome()%></td>
        <td><%=clientes.get(k).getCpf()%></td>
        <td>
            <a href="selectCliente?idCliente=<%=clientes.get(k).getId()%>"><button>Editar</button></a>

        </td>
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>
