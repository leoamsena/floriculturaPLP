package View.CreateUpdate;

import Controller.HomeController;
import Controller.MainController;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Flor implements ActionListener {
    private Model.Flor flor;
    private JTextField nome;
    private JTextField qtd;
    private JPanel panel;
    private JTextField cor;
    private JComboBox fornecedor;
    private JFormattedTextField valor;
    private JButton enviarButton;
    private JButton cancelarButton;

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.enviarButton){ //enviar
            try {
                String nome = this.nome.getText();
                int qtd = Integer.valueOf(this.qtd.getText());
                String  cor = this.cor.getText();
                float valor = Float.valueOf(this.valor.getText().substring(3).trim());
                Model.Fornecedor fornecedor = (Model.Fornecedor) this.fornecedor.getSelectedItem();
                if(qtd < 0 || valor < 0)
                    throw new Exception("Quantidade e/ou valor não pode(m) ser negativo(s)!");
                if(nome.equals("") || cor.equals(""))
                    throw new Exception("Todos os campos devem ser preenchidos!");
                if (this.flor != null) { // editar
                    this.flor.setNome(nome);
                    this.flor.setCor(cor);
                    this.flor.setFornecedor(fornecedor);
                    this.flor.setQtdEmEstoque(qtd);
                    this.flor.setValorIndividual(valor);
                } else { //criar
                    MainController.addToArrayList(new Model.Flor(nome,qtd,cor,valor,fornecedor));
                }
                JOptionPane.showMessageDialog(this.panel,"Criado/editado com sucesso!!!");
                (HomeController.genericCRUDList).refreshPainelComponents();
                Component component = (Component) e.getSource();
                ((JDialog) SwingUtilities.getRoot(component)).dispose();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this.panel,ex.getMessage());
            }
        }else if(e.getSource() == this.cancelarButton){ // cancelar
            Component component = (Component) e.getSource();
            ((JDialog) SwingUtilities.getRoot(component)).dispose();
        }

    }
    public Flor() { //criando novo
        this.enviarButton.addActionListener(this);
        this.cancelarButton.addActionListener(this);
    }

    public Flor(Model.Flor flor) {
        this.enviarButton.addActionListener(this);
        this.cancelarButton.addActionListener(this);
        this.flor = flor;

       this.nome.setText(flor.getNome());
       this.qtd.setText(Integer.toString(flor.getQtdEmEstoque()));
       this.cor.setText(flor.getCor());
       this.valor.setText(Float.toString(flor.getValorIndividual()));
       this.fornecedor.setSelectedItem(flor.getFornecedor());

    }

    private void createUIComponents() throws Exception{
        this.valor = new JFormattedTextField(new MaskFormatter("R$ ##.##"));
        this.fornecedor = new JComboBox(MainController.getFornecedores().toArray());
    }
}
