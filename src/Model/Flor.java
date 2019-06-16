package Model;

import java.io.Serializable;

public class Flor implements Serializable {
    private static int lastCodigo = 1;
    private int codigo;
    private String nome;
    private String cor;
    private float valorIndividual;
    private Fornecedor fornecedor;


    public Flor(String nome, String cor, float valorIndividual, Fornecedor fornecedor) {
        this.codigo = lastCodigo++;
        this.nome = nome;
        this.cor = cor;
        this.valorIndividual = valorIndividual;
        this.fornecedor = fornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getValorIndividual() {
        return valorIndividual;
    }

    public void setValorIndividual(float valorIndividual) {
        this.valorIndividual = valorIndividual;
    }


    @Override
    public String toString() {
        return this.codigo+" - "+this.nome;
    }
}
