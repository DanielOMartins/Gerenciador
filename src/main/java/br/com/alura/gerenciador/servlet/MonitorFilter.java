package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(filterName = "ControladorServlet", value = "/ControladorServlet")
public class MonitorFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        long antes = System.currentTimeMillis();

        String acao = request.getParameter("acao");

        //Executa a ação
        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de execução da " + acao + ": "+ (depois - antes));
    }
}
