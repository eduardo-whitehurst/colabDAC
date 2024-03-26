<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="br.com.colabdac.colabdac.entities.Funcionario" %>
<%@ page import ="java.util.List"%>
<%
    List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("funcionarios");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Adiciona Serviços</title>
</head>
<body>
<form action="cadastraServico" method="POST">
    Nome: <input type="text" name="nome" /><br />
    Descrição: <input type="text" name="descricao" /><br />
    Valor: <input type="text" name="valor" /><br />
    ID do funcionário:
    <select name="id_funcionario" >
        <% for(int k = 0; k<funcionarios.size(); k++) {%>
        <option value="<%=funcionarios.get(k).getId()%>">
            <%=funcionarios.get(k).getId()%> - <%=funcionarios.get(k).getNome()%>
        </option>
        <%}%>
    </select>
    <br />

    <input type="hidden" name="logica" value="AdicionaPeca" />
    <input type="submit" value="Gravar"/>
</body>
</html>