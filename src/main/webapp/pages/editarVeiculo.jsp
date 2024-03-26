<%--
  Created by IntelliJ IDEA.
  User: lacer
  Date: 25/03/2024
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Veiculo</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<h1>Editar Veiculo</h1>
<form name="formAddVeiculo" action="editarVeiculo">
    <input type="text" name="id" readonly="readonly" value="<% out.print(request.getAttribute("idVeiculo"));%>"/><br />
    <input type="text" name="modelo" value="<% out.print(request.getAttribute("modelo"));%>"/><br />
    <input type="text" name="marca" value="<% out.print(request.getAttribute("marca"));%>"/><br />
    <input type="text" name="ano" value="<% out.print(request.getAttribute("ano"));%>"/><br />
    <input id="button" type="submit" value="Salvar"/>
</form>
</body>
</html>
