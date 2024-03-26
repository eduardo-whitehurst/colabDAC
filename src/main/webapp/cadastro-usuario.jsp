<%--
  Created by IntelliJ IDEA.
  User: prego7k
  Date: 25/03/2024
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro Usuário</title>
    <style>
        body {
            background: linear-gradient(90deg, #1CB5E0 0%, #000851 100%);
            display: flex;
            flex-direction: column;
            gap: 5rem;
            justify-content: center;
            align-items: center;
        }
        h1 {
            text-align: center;
            color: white;
        }

        form {
            width: 14rem;
            height: 20rem;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: white;
            padding: 4rem;
            border-radius: 10px;
        }

        label {
            margin-top: 10px;
            text-align: left;
            width: 100%;
        }

        .input {
            margin-top: 5px;
            width: 100%;
            height: 2.5rem;
            border: 0.2px solid #606060;
            border-radius: 2px;
        }
        .cadastrar_button {
            background: #1CB5E0;
            padding: 1rem 2rem;
            color: white;
            border: none;
            border-radius: 5px;
            margin-bottom: 2rem;
        }
        .logar {
            color: #606060;
            cursor: pointer;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <h1>Cadastrar Usuario</h1>

    <form action="usuario" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" class="input" required>
        <br>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" class="input" required>
        <br>
        <label for="senha-confirmar">Repita a senha:</label>
        <input type="password" id="senha-confirmar" name="senha-confirmar" class="input" required>
        <br>
        <input type="submit" value="Cadastrar" class="cadastrar_button">
        <p class="logar">Ja tem uma conta?
            <a style="text-decoration: underline" href="login">Faça login</a>
        </p>
    </form>
</body>
</html>
