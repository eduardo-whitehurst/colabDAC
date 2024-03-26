<%--
  Created by IntelliJ IDEA.
  User: prego7k
  Date: 26/03/2024
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro Veiculo</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
    <h1>Cadastro de Veiculo</h1>
    <form action="cadastraVeiculo" method="post">
        <label>Modelo:</label>
        <input type="text" name="modelo" required>
        <br>
        <label>Marca:</label>
        <input type="text" name="marca" required>
        <br>
        <label>Ano:</label>
        <input type="number" name="ano" required>
        <br>
        <input type="submit" value="Cadastrar">
</body>
</html>
