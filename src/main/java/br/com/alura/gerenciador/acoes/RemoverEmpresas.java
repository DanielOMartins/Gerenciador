package br.com.alura.gerenciador.acoes;

import br.com.alura.gerenciador.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoverEmpresas implements Acao{
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramId = request.getParameter("id");
        Integer id = Integer.parseInt(paramId);

        Banco banco = new Banco();
        banco.remover(id);

        return "redirect:ControladorServlet?acao=ListaEmpresas";
    }
}
