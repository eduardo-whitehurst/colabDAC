<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="br.com.colabdac.colabdac.entities.Venda" %>
<%@ page import ="java.util.List"%>
<%
    List<Venda> vendas = (List<Venda>) request.getAttribute("vendas");
%>
<html>
<head>
    <title>Página de Vendas</title>
</head>
<body>
<table id="tabela">
    <thead>
    <tr>
        <th>Id</th>
        <th>Data</th>
        <th>Cliente</th>
    </tr>
    </thead>
    <tbody>
    <% for(int k=0; k < vendas.size(); k++){%>
    <tr>
        <td><%=vendas.get(k).getId()%></td>
        <td><%=vendas.get(k).getData()%></td>
        <td><%=vendas.get(k).getIdCliente()%></td>
        <td>
            <a href="selecionaVenda?idVenda=<%=vendas.get(k).getId()%>"><button>Editar</button></a>
            <a href="removeVenda?idVenda=<%=vendas.get(k).getId()%>"><button class="remover">Remover</button></a>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>
