<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/ListaEmpresas" var="listaEmpresas"/>
<html>
<head>
    <title>Nova Empresa Criada</title>
</head>
<body>
    <c:if test="${not empty nomeEmpresa}">
        <h3>Empresa ${nomeEmpresa} cadastrada com sucesso</h3>
    </c:if>

    <c:if test="${empty nomeEmpresa}">
        <h3>Nenhuma empresa cadastrada</h3>
    </c:if>

    <form action="${listaEmpresas}">
        <button type="submit">Mostrar Empresas Cadastradas</button>
    </form>
    <c:import url="logout-Parc.jsp"/>
</body>
</html>
