<%@ page import="java.util.List" %>
<%@ page import="br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista de empresas</title>
</head>
<body>

    <h3>usuário: ${usuarioLogado.login}</h3>

    <c:if test="${not empty nomeEmpresa}">
        <h2>Empresa ${nomeEmpresa} cadastrada com sucesso</h2>
    </c:if>

    <h3>Lista de Empresas:</h3>

    <ul>
        <c:forEach items="${listaEmpresas}" var="empresa">
            <fmt:formatDate value="${empresa.data}" var="dataFormatada" pattern="dd/MM/yyyy"/>
            <li>
                ${empresa.nome} - ${dataFormatada}
                    <a href="/gerenciador_war_exploded/ControladorServlet?id=${empresa.id}&acao=MostrarEmpresas">Editar</a>
                    <a href="/gerenciador_war_exploded/ControladorServlet?id=${empresa.id}&acao=RemoverEmpresas">Deletar</a>
            </li>
        </c:forEach>
    </ul>
    <c:import url="logout-Parc.jsp"/>
</body>
</html>
