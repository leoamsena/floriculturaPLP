package View;

import Controller.HomeController;
import Controller.MainController;
import Model.Cliente;
import Model.Compra;
import Model.Flor;
import Model.Fornecedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home implements ActionListener {
    private JPanel panel;
    private JLabel homeLabel;
    private JButton floresButton;
    private JButton clientesButton;
    private JButton fornecedoresButton;
    private JButton comprasButton;
    private JButton saveBtn;
    private JButton loadBtn;


    public JDialog getDialog(){
        return (JDialog) this.panel.getParent();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == this.comprasButton) {
                HomeController.openGenericCRUD((MainController.getCompras()), Compra.class);
            } else if (e.getSource() == this.fornecedoresButton) {
                HomeController.openGenericCRUD((MainController.getFornecedores()), Fornecedor.class);
            } else if (e.getSource() == this.clientesButton) {
                HomeController.openGenericCRUD((MainController.getClientes()), Cliente.class);
            } else if (e.getSource() == this.floresButton) {
                HomeController.openGenericCRUD((MainController.getFlores()), Flor.class);
            } else if (e.getSource() == this.saveBtn) {
                MainController.save();
                JOptionPane.showMessageDialog(this.panel,"Salvo com sucesso!");
            } else if (e.getSource() == this.loadBtn) {
                MainController.load();
                JOptionPane.showMessageDialog(this.panel,"Carregado com sucesso!");
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this.panel,ex.getMessage());
        }

    }

    public JPanel getPanel() {
        return panel;
    }

    public Home() {
        this.comprasButton.addActionListener(this);
        this.floresButton.addActionListener(this);
        this.clientesButton.addActionListener(this);
        this.fornecedoresButton.addActionListener(this);
        this.saveBtn.addActionListener(this);
        this.loadBtn.addActionListener(this);
    }
}
