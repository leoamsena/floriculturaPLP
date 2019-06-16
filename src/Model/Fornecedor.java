package Model;

import java.io.Serializable;

public class Fornecedor implements Serializable {
    private String cnpj;
    private String nome;
    private String cidade;

    public Fornecedor() {
    }

    @Override
    public String toString() {
        return this.cnpj+" - "+this.nome;
    }

    public Fornecedor(String cnpj, String nome, String cidade) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
