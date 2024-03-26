<%--
  Created by IntelliJ IDEA.
  User: neo
  Date: 25/03/2024
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
    <div>
    <h1>Funcionario <span>${param.nome}</span> cadastrado com sucesso!!!</h1>
    <a href="funcionarios"><button>Voltar a página inicial</button></a>
</div>
</body>
</html>