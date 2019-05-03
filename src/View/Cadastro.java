package View;

import Controller.CadastroController;
import Controller.MainController;
import Model.Funcionario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Cadastro implements ActionListener {
    private JPanel panel;
    private JFormattedTextField cpf;
    private JTextField nome;
    private JTextField telefone;
    private JTextField cargo;
    private JTextField email;
    private JPasswordField senha;
    private JPasswordField confirmaSenha;
    private JButton cadastrarButton;

    public Cadastro() {
        this.cadastrarButton.addActionListener(this);
    }

    public JPanel getPanel() {
        return panel;
    }
    public void actionPerformed(ActionEvent e) {
        try{
            String cpf = this.cpf.getText();
            String nome = this.nome.getText();
            String telefone = this.telefone.getText();
            String cargo = this.cargo.getText();
            String email = this.email.getText();
            String senha = new String(this.senha.getPassword());
            String confirmaSenha = new String(this.confirmaSenha.getPassword());
            if(cpf.equals("") || nome.equals("") || telefone.equals("") || cargo.equals("") || email.equals("") || senha.equals("") || confirmaSenha.equals(""))
                throw new Exception("Todos os campos devem ser preenchidos!");
            else if(!senha.equals(confirmaSenha))
                throw new Exception("As senhas digitadas não são iguais!");
            CadastroController.cadastrar(cpf,nome,telefone,cargo,email,senha);
            JOptionPane.showMessageDialog(this.panel,"Funcionário cadastrado com sucesso!","Sucesso!!!",JOptionPane.INFORMATION_MESSAGE);
            ((JDialog) this.panel.getRootPane().getParent()).dispose();

        }catch (Exception ex){
            JOptionPane.showMessageDialog(this.panel,ex.getMessage(),"Erro!",JOptionPane.ERROR_MESSAGE);
            /*for(StackTraceElement s : ex.getStackTrace()){
                System.out.println(s);
            }*/
        }
    }

    private void createUIComponents() throws ParseException {
        // TODO: place custom component creation code here
        this.telefone = new JFormattedTextField(new MaskFormatter("(##)####-####"));
        this.cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
    }
}
