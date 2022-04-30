package br.com.alura.gerenciador.acoes;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Realizando login");

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Banco banco = new Banco();
        Usuario usuario = banco.usuarioExiste(login, senha);

        if(usuario != null){
            System.out.println(usuario.getLogin());
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:ControladorServlet?acao=ListaEmpresas";
        }

        return "redirect:ControladorServlet?acao=FormLogin";

    }
}
