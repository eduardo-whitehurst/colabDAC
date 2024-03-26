<%--
  Created by IntelliJ IDEA.
  User: prego7k
  Date: 25/03/2024
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f4f8; /* Um azul muito claro como fundo */
            margin: 0;
            padding: 20px;
            color: #333; /* Cor do texto */
        }

        #content {
            background-color: #ffffff; /* Fundo branco para o conteúdo */
            border: 1px solid #dbe2e8; /* Borda sutil */
            border-radius: 8px; /* Bordas arredondadas */
            padding: 20px;
            max-width: 800px; /* Largura máxima do conteúdo */
            margin: 40px auto; /* Centraliza o conteúdo */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Sombra suave */
        }

        #content h2 {
            color: #0077b6; /* Azul */
            margin-bottom: 20px; /* Espaçamento abaixo do título */
        }

        #content p {
            line-height: 1.6; /* Espaçamento entre linhas do parágrafo */
            color: #555; /* Cor do texto um pouco mais escura para contraste */
        }

    </style>
</head>
<body>
    <jsp:include page="components/header.jsp"/>
    <div id="content">
        <h2>Bem-vindo à nossa loja de autopeças!</h2>
        <p>Aqui você encontrará uma ampla variedade de peças para o seu veículo. Navegue pelo nosso site para descobrir mais.</p>
    </div>
</body>
</html>
