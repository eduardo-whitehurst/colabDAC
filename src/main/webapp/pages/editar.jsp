<%--
  Created by IntelliJ IDEA.
  User: lacer
  Date: 25/03/2024
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Cliente</title>
</head>
<body>
    <h1>Editar Cliente</h1>
    <form name="formAddPaciente" action="editarCliente">
        <input type="text" name="id" readonly="readonly" value="<% out.print(request.getAttribute("idCliente"));%>"/><br />
        <input type="text" name="nome" value="<% out.print(request.getAttribute("nome"));%>"/><br />
        <input type="text" name="cpf" value="<% out.print(request.getAttribute("cpf"));%>"/><br />
        <input id="button" type="submit" value="Salvar"/>
    </form>
</body>
</html>
