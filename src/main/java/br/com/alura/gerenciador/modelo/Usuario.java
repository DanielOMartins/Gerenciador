package br.com.alura.gerenciador.modelo;

public class Usuario {
    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean igualLogin(String login) {
        if (this.login.equals(login))
            return true;

        return false;
    }
    public boolean igualSenha(String senha){
        if (this.senha.equals(senha))
            return true;
        return false;
    }

}
