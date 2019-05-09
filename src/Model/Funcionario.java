package Model;

import java.io.Serializable;

public class Funcionario extends Pessoa  implements Serializable {
    private String cargo;
    private String email;
    private String senha;

    public Funcionario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Funcionario(String cpf, String nome, String telefone, String cargo, String email, String senha) {
        super(cpf, nome, telefone);
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
