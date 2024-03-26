<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Serviço</title>
</head>
<body>
<h1>Editar Serviço</h1>
<form name="formEditaServico" action="editarServico">
    <input type="text" name="id" readonly="readonly" value="<% out.print(request.getAttribute("idServico"));%>"/><br />
    <input type="text" name="nome" value="<% out.print(request.getAttribute("nome"));%>"/><br />
    <input type="text" name="descricao" value="<% out.print(request.getAttribute("descricao"));%>"/><br />
    <input type="text" name="valor" value="<% out.print(request.getAttribute("valor"));%>"/><br />
    <input type="text" name="idFuncionario" readonly="readonly" value="<% out.print(request.getAttribute("id_funcionario"));%>"/><br />
    <input id="button" type="submit" value="Salvar"/>
</form>
</body>
</html>
