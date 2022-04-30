package br.com.alura.gerenciador.acoes;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MostrarEmpresas implements Acao{
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Banco banco = new Banco();

        String paramId = request.getParameter("id");
        Integer id = Integer.parseInt(paramId);

        Empresa empresa = banco.buscaEmpresaId(id);

        request.setAttribute("nomeEmpresa", empresa.getNome());
        request.setAttribute("data", empresa.getData());
        request.setAttribute("id", empresa.getId());

        return "forward:formEditarEmpresa.jsp";
    }
}
