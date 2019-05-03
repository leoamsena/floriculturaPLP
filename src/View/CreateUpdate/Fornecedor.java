package View.CreateUpdate;

import Controller.HomeController;
import Controller.MainController;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fornecedor implements ActionListener {
    private JTextField nome;
    private JFormattedTextField cnpj;
    private JButton cancelarButton;
    private JButton enviarButton1;
    private JPanel panel;
    private Model.Fornecedor fornecedor;

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.enviarButton1){ //enviar
            try {
                String cnpj = this.cnpj.getText();
                String nome = this.nome.getText();
                if(cnpj.equals("") || nome.equals(""))
                    throw new Exception("CPNJ e/ou nome devem ser preenchidos!");
                if (this.fornecedor != null) { // editar
                    this.fornecedor.setCnpj(cnpj);
                    this.fornecedor.setNome(nome);
                } else { //criar
                    MainController.addToArrayList(new Model.Fornecedor(cnpj,nome));
                }
                JOptionPane.showMessageDialog(this.panel,"Criado/editado com sucesso!!!");
                (HomeController.genericCRUDList).refreshPainelComponents();
                Component component = (Component) e.getSource();
                ((JDialog) SwingUtilities.getRoot(component)).dispose();

                //((JDialog) this.panel.get()).dispose();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this.panel,ex.getMessage());
            }
        }else if(e.getSource() == this.cancelarButton){ // cancelar
            Component component = (Component) e.getSource();
            ((JDialog) SwingUtilities.getRoot(component)).dispose();
        }

    }
    public Fornecedor() { //criando novo
        this.enviarButton1.addActionListener(this);
        this.cancelarButton.addActionListener(this);
    }

    public Fornecedor(Model.Fornecedor fornecedor) {
        this.enviarButton1.addActionListener(this);
        this.cancelarButton.addActionListener(this);
        this.fornecedor = fornecedor;
        this.cnpj.setText(fornecedor.getCnpj());
        this.nome.setText(fornecedor.getNome());
    }

    private void createUIComponents() throws Exception{
        this.cnpj = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));

    }
}
