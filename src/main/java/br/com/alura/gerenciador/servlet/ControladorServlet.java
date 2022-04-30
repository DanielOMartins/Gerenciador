package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acoes.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ControladorServlet", value = "/ControladorServlet")
public class ControladorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
