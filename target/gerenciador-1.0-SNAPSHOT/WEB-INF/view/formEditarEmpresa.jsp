<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/ControladorServlet" var="controladorServlet"/>
<html>
<head>
    <title>Editar Empresa</title>
</head>
<body>
<form action="${controladorServlet}?acao=AtualizaEmpresa" method="post">
    <input type="text" name="id" value="${id}" readonly>
    <label name=""></label>
    <label>Nome</label>
    <input type="text" name="nome" value="${nomeEmpresa}">
    <br/>
    <label>Data de abertura</label>
    <input type="text" name="data" value="<fmt:formatDate value="${data}" pattern="dd/MM/yyyy"/>">

    <button type="submit">Cadastrar</button>
</form>
<c:import url="logout-Parc.jsp"/>
</body>
</html>
