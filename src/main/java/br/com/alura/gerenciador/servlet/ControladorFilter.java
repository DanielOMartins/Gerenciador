package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acoes.Acao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "ControladorServlet", value = "/ControladorServlet")
public class ControladorFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");
        String nomeClasse = "br.com.alura.gerenciador.acoes." + paramAcao;
        String[] endereco = new String[2];
        String nome = "";

        try {
            Class classe = Class.forName(nomeClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executar(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        endereco = nome.split(":");
        if (endereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + endereco[1]);
            rd.forward(request, response);
        }else{
            if (endereco[0].equals("redirect"))
                response.sendRedirect(endereco[1]);
        }
    }
}
