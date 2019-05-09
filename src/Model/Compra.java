package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Compra  implements Serializable {
    private float valorTotal;
    private Cliente cliente;
    private static ArrayList<Flor> flores;

    public Compra(float valorTotal, Cliente cliente) {
        this.valorTotal = valorTotal;
        this.cliente = cliente;
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

    public static ArrayList<Flor> getFlores() {
        return flores;
    }

    public static void setFlores(ArrayList<Flor> flores) {
        Compra.flores = flores;
    }
}
