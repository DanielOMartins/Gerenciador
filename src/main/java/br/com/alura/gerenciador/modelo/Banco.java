package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static List<Empresa> listaEmpresas = new ArrayList<>();
    private static List<Usuario> listaUsuarios = new ArrayList<>();
    private static Integer id = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setNome("Alura");
        empresa.setId(id++);
        Empresa empresa2 = new Empresa();
        empresa2.setNome("google");
        empresa2.setId(id++);

        listaEmpresas.add(empresa);
        listaEmpresas.add(empresa2);

        Usuario u1 = new Usuario();
        u1.setLogin("Daniel");
        u1.setSenha("1811");
        Usuario u2 = new Usuario();
        u2.setLogin("Bianca");
        u2.setSenha("1408");

        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(id++);
        listaEmpresas.add(empresa);
    }

    public void remover(Integer id){
        listaEmpresas.removeIf(empresa -> empresa.getId() == id);
    }

    public Empresa buscaEmpresaId(Integer id){
        for (Empresa empresa : listaEmpresas){
            if(empresa.getId() == id)
                return empresa;
        }
        return null;
    }

    public List<Empresa> getEmpresas(){
        return Banco.listaEmpresas;
    }

    public Usuario usuarioExiste(String login, String senha){
        for (Usuario usuario:listaUsuarios){
            if(usuario.igualLogin(login) && usuario.igualSenha(senha)){
                return usuario;
            }
        }

        return null;
    }
}
