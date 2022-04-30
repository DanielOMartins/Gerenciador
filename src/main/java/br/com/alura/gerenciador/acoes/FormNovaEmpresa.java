package br.com.alura.gerenciador.acoes;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormNovaEmpresa implements Acao{
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Formulário nova empresa");


        return "forward:formNovaEmpresa.jsp";
    }
}
