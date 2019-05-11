package Model;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
    private String profissao;


    public Cliente(String cpf, String nome, String telefone, String profissao) {
        super(cpf, nome, telefone);
        this.profissao = profissao;
    }


    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return this.getCpf()+" - "+this.getNome();
    }
}
