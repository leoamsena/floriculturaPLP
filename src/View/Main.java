package View;

import Controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener{
    private JPanel mainPanel;
    private JTextField email;
    private JPasswordField senha;
    private JButton login;
    private JButton cadastrar;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.login){ //logar
            try{
                String email = this.email.getText();
                String senha = new String(this.senha.getPassword());
                if(email.equals("") || senha.equals(""))
                    throw new Exception("Senha e/ou email em branco!");
                MainController.logar(email,senha);

            }catch (Exception ex){
                JOptionPane.showMessageDialog(this.mainPanel,ex.getMessage(),"Erro!",JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == this.cadastrar){ //cadastrar
            MainController.cadastrar();
        }
    }

    public Main() {

        this.login.addActionListener(this);
        this.cadastrar.addActionListener(this);
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here



    }
}
