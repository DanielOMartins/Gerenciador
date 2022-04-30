<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/ControladorServlet" var="Controlador"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Formulário Nova Empresa</title>
</head>
<body>
<form action="${Controlador}?acao=Login" method="post">
    <label>Login</label>
    <input type="text" name="login">
    <label>Senha</label>
    <input type="password" name="senha">

    <button type="submit">Cadastrar</button>
</form>
</body>
</html>