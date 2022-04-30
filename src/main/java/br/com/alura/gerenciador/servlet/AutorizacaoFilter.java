package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "ControladorServlet", value = "/ControladorServlet")
public class AutorizacaoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String paramAcao = request.getParameter("acao");


        HttpSession session = request.getSession();
        boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
        boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("FormLogin"));

        if(acaoProtegida && usuarioNaoEstaLogado) {
            response.sendRedirect("ControladorServlet?acao=FormLogin");
            return;
        }

        chain.doFilter(servletRequest, servletResponse);
    }
}
