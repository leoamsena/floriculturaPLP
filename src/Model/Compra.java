package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Compra  implements Serializable {
    private float valorTotal;
    private Cliente cliente;
    private Map<Flor,Integer> flores;
    private Funcionario funcionario;

    public Compra(float valorTotal, Cliente cliente, Map<Flor,Integer> flores,Funcionario funcionario) {
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.flores = flores;
        this.funcionario = funcionario;
    }

    public Compra(Cliente cliente, Map<Flor,Integer> flores,Funcionario funcionario) {
        this.cliente = cliente;
        this.flores = flores;
        this.funcionario = funcionario;
        this.calculaValorAutomatico();
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void calculaValorAutomatico(){
        float total = 0;
        for(Flor f : flores.keySet()){
            total += f.getValorIndividual() * this.flores.get(f);
        }
        this.valorTotal = total;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Map<Flor,Integer> getFlores() {
        return this.flores;
    }

    public void setFlores(Map<Flor,Integer> flores) {
        this.flores = flores;
    }

    @Override
    public String toString() {
        return "Func.: "+this.funcionario.getNome()+" Valor: "+String.format("%.2f",this.valorTotal);
    }
}
