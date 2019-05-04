package View.CreateUpdate;

import Controller.HomeController;
import Controller.MainController;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cliente implements ActionListener {
    private JFormattedTextField cpf;
    private JTextField nome;
    private JFormattedTextField telefone;
    private JTextField profissao;
    private JButton enviarButton;
    private JButton cancelarButton;
    private JPanel panel;
    private Model.Cliente cliente;

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.enviarButton){ //enviar
            try {
                String cpf = this.cpf.getText();
                String nome = this.nome.getText();
                String telefone = this.telefone.getText();
                String profissao = this.profissao.getText();
                if(cpf.equals("") || nome.equals("") || telefone.equals("") || profissao.equals(""))
                    throw new Exception("Todos os campos devem ser preenchidos!");
                if (this.cliente != null) { // editar
                    this.cliente.setCpf(cpf);
                    this.cliente.setNome(nome);
                    this.cliente.setTelefone(telefone);
                    this.cliente.setProfissao(profissao);
                } else { //criar
                    MainController.addToArrayList(new Model.Cliente(cpf,nome,telefone,profissao));
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
    public Cliente() { //criando novo
        this.enviarButton.addActionListener(this);
        this.cancelarButton.addActionListener(this);
    }

    public Cliente(Model.Cliente cliente) {
        this.enviarButton.addActionListener(this);
        this.cancelarButton.addActionListener(this);
        this.cliente = cliente;

        this.cpf.setText(cliente.getCpf());
        this.nome.setText(cliente.getNome());
        this.profissao.setText(cliente.getProfissao());
        this.telefone.setText(cliente.getTelefone());
    }

    private void createUIComponents() throws Exception{
        this.cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        this.telefone = new JFormattedTextField(new MaskFormatter("(##)####-####"));

    }
}
