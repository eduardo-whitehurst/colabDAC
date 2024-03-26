<%--
  Created by IntelliJ IDEA.
  User: lacer
  Date: 25/03/2024
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="br.com.colabdac.colabdac.entities.Veiculo" %>
<%@ page import ="java.util.List"%>
<%
    List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("veiculos");
%>
<html>
<head>
    <title>Página de Veiculos</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<table id="tabela">
    <thead>
    <tr>
        <th>Id</th>
        <th>Modelo</th>
        <th>Marca</th>
        <th>Ano</th>
    </tr>
    </thead>
    <tbody>
    <% if (veiculos != null) { %>
    <% for(int k=0; k < veiculos.size(); k++){ %>
    <tr>
        <td><%=veiculos.get(k).getId()%></td>
        <td><%=veiculos.get(k).getModelo()%></td>
        <td><%=veiculos.get(k).getMarca()%></td>
        <td><%=veiculos.get(k).getAno()%></td>
        <td>
            <a href="selectVeiculo?idVeiculo=<%=veiculos.get(k).getId()%>"><button>Editar</button></a>
            <a href="selectDelVeiculo?idVeiculo=<%=veiculos.get(k).getId()%>"><button class="remover">Remover</button></a>
        </td>
    </tr>
    <% } %>
    <% } else { %>
    <!-- Handle the null case, perhaps by showing a message -->
    <tr><td colspan="2">No vehicles available</td></tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
