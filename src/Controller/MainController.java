package Controller;

import Model.*;
import View.Cadastro;
import View.Home;
import View.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class  MainController {
    private static JFrame frame;
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static ArrayList<Compra> compras = new ArrayList<>();
    private static ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Flor> flores = new ArrayList<>();

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Flor> getFlores() {
        return flores;
    }

    public static Funcionario getUsuarioLogado() {
        return usuarioLogado;
    }

    private static Funcionario usuarioLogado;

    public static ArrayList<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static ArrayList<Compra> getCompras() {
        return compras;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void addToArrayList(Object o){
        if(o instanceof Funcionario)
            funcionarios.add((Funcionario) o);
        else if (o instanceof Fornecedor)
            fornecedores.add((Fornecedor) o);
        else if(o instanceof Flor)
            flores.add((Flor) o);
        else if(o instanceof Compra)
            compras.add((Compra) o);
        else if(o instanceof Cliente)
            clientes.add((Cliente) o);
    }

    public static boolean logar(String email, String senha) throws Exception{
        for(Funcionario f: funcionarios){
            if(f.getEmail().equals(email) && f.getSenha().equals(senha)){ //loguei
                usuarioLogado = f;
                JPanel newPanel = new Home().getPanel();
                frame.setContentPane(newPanel);
                frame.pack();
                return true;
            }

        }
        throw new Exception("Email e/ou senha inválido(s)!");

    }

    public static void main(String[] args) {
        frame = new JFrame("SGF");
        frame.setContentPane(new Main().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        // CADASTRO PARA TESTE
        funcionarios.add(new Funcionario("1111", "1", "1", "1", "1", "1"));
        fornecedores.add(new Fornecedor("111","nome"));
        fornecedores.add(new Fornecedor("222","nome aa"));
    }



    public static void cadastrar(){
        JDialog cadastro = new JDialog(frame,"Cadastre-se!",JDialog.ModalityType.DOCUMENT_MODAL);
        cadastro.setContentPane(new Cadastro().getPanel());
        cadastro.setResizable(false);
        cadastro.setSize(new Dimension(500,500));
        cadastro.setVisible(true);
    }
}
