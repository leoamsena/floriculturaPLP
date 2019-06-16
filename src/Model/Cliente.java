package Model;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
    private String profissao;
    private String estadoCivil;

    public Cliente(String cpf, String nome, String telefone, String profissao, String estadoCivil) {
        super(cpf, nome, telefone);
        this.profissao = profissao;
        this.estadoCivil = estadoCivil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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
