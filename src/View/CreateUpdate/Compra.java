package View.CreateUpdate;

import Controller.HomeController;
import Controller.MainController;
import View.Util.JButtonWithObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Compra implements ActionListener {
    private JPanel panel;
    private JCheckBox checkValor;
    private JFormattedTextField valorTotal;
    private JComboBox floresCombo;
    private JButton add;
    private JPanel listaFlores;
    private JButton enviarButton;
    private JButton cancelarButton;
    private JComboBox cliente;
    private boolean visivel;
    private Model.Compra compra;


    private Map<Model.Flor,Integer> listaTemporaria;
    private void refreshList(){
        this.listaFlores.removeAll();
        int cont = 0;
        for (Model.Flor o : this.listaTemporaria.keySet()) {
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;

            c.gridy = cont;
            c.gridx = 0;
            c.weightx = 2;
            this.listaFlores.add(new JLabel(o.toString() + "| Qtd: " + this.listaTemporaria.get(o), SwingConstants.LEFT), c);
            c.weightx = 0;
            c.gridx = 1;
            JButtonWithObject jbo = new JButtonWithObject("Diminuir um", o);
            jbo.setName("diminuir");
            jbo.addActionListener(this);
            this.listaFlores.add(jbo, c);
            c.gridx = 2;
            jbo = new JButtonWithObject("Excluir da lista", o);
            jbo.setName("excluir");
            jbo.addActionListener(this);
            this.listaFlores.add(jbo, c);
            cont++;
        }
        this.listaFlores.revalidate();
        this.listaFlores.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.checkValor) {
            visivel = !visivel;
            this.valorTotal.setVisible(visivel);
            //this.panel.repaint();
            this.panel.revalidate();
        } else if (e.getSource() == this.add) {
            try {
                Object ob = this.floresCombo.getSelectedItem();
                int valor = 1;

                if (this.listaTemporaria.containsKey(ob)) {
                    valor = this.listaTemporaria.get(ob) + 1;
                    this.listaTemporaria.replace((Model.Flor) ob, valor);
                } else {
                    this.listaTemporaria.put((Model.Flor) ob, valor);
                }
                refreshList();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this.panel, ex.getMessage());
            }
        }else if(e.getSource() instanceof JButtonWithObject){ // é para diminuir ou excluir da lista de flores
            JButtonWithObject bt = (JButtonWithObject) e.getSource();
            int novoValor = this.listaTemporaria.get(bt.getObject());
            if(bt.getName().equals("excluir") || novoValor <= 1 ){
                this.listaTemporaria.remove(bt.getObject());
            }else if(bt.getName().equals("diminuir")){
                 novoValor -= 1;
                this.listaTemporaria.replace((Model.Flor) bt.getObject(), novoValor);
            }
            refreshList();
        }else if(e.getSource() == this.enviarButton){
            float valor = -1;
            if(!this.checkValor.isSelected()) {
                valor = Float.valueOf(this.valorTotal.getText().substring(3).trim());
            }
            if(this.compra != null){ //editando
                this.compra.setCliente((Model.Cliente)this.cliente.getSelectedItem());
                this.compra.setFlores(this.listaTemporaria);
                this.compra.setFuncionario(MainController.getUsuarioLogado());
                if(valor != -1)
                    this.compra.setValorTotal(valor);
                else
                    this.compra.calculaValorAutomatico();
            }else{ //criando
                if(valor == -1) {
                    MainController.addToArrayList(new Model.Compra((Model.Cliente) this.cliente.getSelectedItem(), this.listaTemporaria, MainController.getUsuarioLogado()));
                }else {
                    MainController.addToArrayList(new Model.Compra(valor, (Model.Cliente) this.cliente.getSelectedItem(), this.listaTemporaria, MainController.getUsuarioLogado()));
                }
            }
            JOptionPane.showMessageDialog(this.panel,"Criado/editado com sucesso!!!");
            (HomeController.genericCRUDList).refreshPainelComponents();
            Component component = (Component) e.getSource();
            ((JDialog) SwingUtilities.getRoot(component)).dispose();

        }else if(e.getSource() == this.cancelarButton){
            Component component = (Component) e.getSource();
            ((JDialog) SwingUtilities.getRoot(component)).dispose();
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    public Compra(){
        visivel = true;
        this.valorTotal.setVisible(visivel);
        this.listaTemporaria = new HashMap<Model.Flor,Integer>();
        this.checkValor.addActionListener(this);
        this.add.addActionListener(this);
        this.enviarButton.addActionListener(this);
        this.cancelarButton.addActionListener(this);
    }
    public Compra(Model.Compra compra){
        this.compra = compra;
        visivel = true;
        this.valorTotal.setVisible(visivel);
        this.listaTemporaria = new HashMap<Model.Flor,Integer>();
        this.checkValor.addActionListener(this);
        this.add.addActionListener(this);
        this.enviarButton.addActionListener(this);
        this.cancelarButton.addActionListener(this);
        this.listaTemporaria = this.compra.getFlores();
        refreshList();
        this.cliente.setSelectedItem(this.compra.getCliente());
        this.valorTotal.setText(Float.toString(this.compra.getValorTotal()));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.floresCombo = new JComboBox(MainController.getFlores().toArray());
        this.cliente = new JComboBox(MainController.getClientes().toArray());
        this.listaFlores = new JPanel();
        this.listaFlores.setLayout(new GridBagLayout());
    }
}
