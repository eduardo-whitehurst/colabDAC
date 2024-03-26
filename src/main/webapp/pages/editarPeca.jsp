<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Editar Peca</title>
</head>
<body>
<h1>Editar Peca</h1>
<form name="formEditaPeca" action="editaPeca">
  <input type="text" name="id" readonly="readonly" value="<% out.print(request.getAttribute("idPeca"));%>"/><br />
  <input type="text" name="nome" value="<% out.print(request.getAttribute("nome"));%>"/><br />
  <input type="text" name="valor" value="<% out.print(request.getAttribute("valor"));%>"/><br />
  <input id="button" type="submit" value="Salvar"/>
</form>
</body>
</html>
