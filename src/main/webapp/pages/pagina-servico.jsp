<%--
  Created by IntelliJ IDEA.
  User: lacer
  Date: 25/03/2024
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="br.com.colabdac.colabdac.entities.Servico" %>
<%@ page import ="java.util.List"%>
<%
    List<Servico> clientes = (List<Servico>) request.getAttribute("servicos");
%>
<html>
<head>
    <title>Página de Clientes</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<table id="tabela">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Valor</th>
        <th>ID Funcionário</th>
    </tr>
    </thead>
    <tbody>
    <% for(int k=0; k < clientes.size(); k++){%>
    <tr>
        <td><%=clientes.get(k).getId()%></td>
        <td><%=clientes.get(k).getNome()%></td>
        <td><%=clientes.get(k).getDescricao()%></td>
        <td><%=clientes.get(k).getValor()%></td>
        <td><%=clientes.get(k).getIdFuncionario()%></td>
        <td>
            <a href="selectServico?idServico=<%=clientes.get(k).getId()%>"><button>Editar</button></a>
            <a href="selectDelServico?idServico=<%=clientes.get(k).getId()%>"><button class="remover">Remover</button></a>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>
