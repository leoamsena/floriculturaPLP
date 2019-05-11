package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Compra  implements Serializable {
    private float valorTotal;
    private Cliente cliente;
    private ArrayList<Flor> flores;
    private Funcionario funcionario;

    public Compra(float valorTotal, Cliente cliente, ArrayList<Flor> flores,Funcionario funcionario) {
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.flores = flores;
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
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

    public ArrayList<Flor> getFlores() {
        return this.flores;
    }

    public void setFlores(ArrayList<Flor> flores) {
        this.flores = flores;
    }
}
