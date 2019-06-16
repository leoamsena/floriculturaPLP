package Model;

import java.io.Serializable;

public class Estoque implements Serializable {
    private Flor flor;
    private int qtdEmEstoque;

    public Estoque(Flor flor, int qtdEmEstoque) {
        this.flor = flor;
        this.qtdEmEstoque = qtdEmEstoque;
    }

    public Flor getFlor() {
        return flor;
    }

    public void setFlor(Flor flor) {
        this.flor = flor;
    }

    public int getQtdEmEstoque() {
        return qtdEmEstoque;
    }

    public void setQtdEmEstoque(int qtdEmEstoque) {
        this.qtdEmEstoque = qtdEmEstoque;
    }

    public void diminuiEstoque(int qtd){
        this.qtdEmEstoque -= qtd;
    }
    public void diminuiEstoque(){
        this.qtdEmEstoque--;
    }

    @Override
    public String toString() {
        return this.flor.getCodigo()+" - "+this.qtdEmEstoque;
    }
}
