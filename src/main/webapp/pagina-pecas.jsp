<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="br.com.colabdac.colabdac.entities.Peca" %>
<%@ page import ="java.util.List"%>
<%
    List<Peca> pecas = (List<Peca>) request.getAttribute("pecas");
%>
<html>
<head>
    <title>Página de Peças</title>
</head>
<body>
<table id="tabela">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Valor</th>
    </tr>
    </thead>
    <tbody>
    <% for(int k=0; k < pecas.size(); k++){%>
    <tr>
        <td><%=pecas.get(k).getId()%></td>
        <td><%=pecas.get(k).getNome()%></td>
        <td><%=pecas.get(k).getValor()%></td>
        <td>
            <a href="selecionaPeca?idPeca=<%=pecas.get(k).getId()%>"><button>Editar</button></a>
            <a href="removePeca?idPeca=<%=pecas.get(k).getId()%>"><button class="remover">Remover</button></a>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>