package Model;

public class Fornecedor{
    private String cnpj;
    private String nome;

    public Fornecedor() {
    }

    @Override
    public String toString() {
        return this.cnpj+" - "+this.nome;
    }

    public Fornecedor(String cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
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
