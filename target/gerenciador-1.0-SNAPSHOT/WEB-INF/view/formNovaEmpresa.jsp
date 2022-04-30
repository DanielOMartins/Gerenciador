<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/ControladorServlet" var="Controlador"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Formulário Nova Empresa</title>
</head>
<body>
<form action="${Controlador}?acao=NovaEmpresa" method="post">
    <label>Nome</label>
    <input type="text" name="nome">
    <br/>
    <label>Data de abertura</label>
    <input type="text" name="data">

    <button type="submit">Cadastrar</button>
</form>
<c:import url="logout-Parc.jsp"/>
</body>
</html>