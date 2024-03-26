<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Venda</title>
</head>
<body>
<h1>Editar Venda</h1>
<form name="formEditaVenda" action="editaVenda">
    <input type="text" name="id" readonly="readonly" value="<% out.print(request.getAttribute("idVenda"));%>"/><br />
    <input type="text" name="data" value="<% out.print(request.getAttribute("data"));%>"/><br />
    <input type="text" name="cliente" value="<% out.print(request.getAttribute("idCliente"));%>"/><br />
    <input id="button" type="submit" value="Salvar"/>
</form>
</body>
</html>
