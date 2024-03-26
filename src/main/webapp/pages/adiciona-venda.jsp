<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="br.com.colabdac.colabdac.entities.Cliente" %>
<%@ page import ="java.util.List"%>
<%
  List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
%>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Adiciona venda</title>
</head>
<body>
<form action="cadastraVenda" method="POST">
  Data: <input type="text" name="data" /><br />
  Cliente:
  <select name="idCliente">
    <% for(int k=0; k < clientes.size(); k++){%>
    <option value="<%=clientes.get(k).getId()%>">
      <%=clientes.get(k).getId()%> - <%=clientes.get(k).getNome() %>
    </option>
    <% } %>
  </select>
  <br />
  <input type="hidden" name="logica" value="AdicionaVenda" />
  <input type="submit" value="Gravar"/>
</form>
</body>
</html>