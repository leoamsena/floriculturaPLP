package View;

import Controller.GenericCRUDListController;
import Model.Fornecedor;
import View.Util.JButtonWithObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GenericCRUDList implements ActionListener {
    private ArrayList<Object> array;
    private Class<?> clazz;
    private JPanel painel;
    private JPanel panel;
    private JButton voltarButton1;

    private JLabel nameLabel;
    private JButton criarNovoButton1;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButtonWithObject){
            JButtonWithObject jb = (JButtonWithObject) e.getSource();
            if((jb).getText().equals("Excluir")){ //clicou no botão excluir
                int op = JOptionPane.showConfirmDialog(this.panel,"Tem certeza que deseja excluir?");
                if(op == JOptionPane.YES_OPTION){
                    GenericCRUDListController.excluir(jb.getObject());
                    this.refreshPainelComponents();
                }
            }else if((jb).getText().equals("Editar")){ //clicou no botão editar
                GenericCRUDListController.openUpdate(jb.getObject());
            }
        }else{
            if(e.getSource() == this.voltarButton1){
                Component component = (Component) e.getSource();
                ((JDialog) SwingUtilities.getRoot(component)).dispose();
            }else if(e.getSource() == this.criarNovoButton1){ //clicou para criar um novo elemento
                GenericCRUDListController.openCreate(this.clazz);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public GenericCRUDList(ArrayList<Object> array, Class<?> clazz) {

        this.array = array;
        this.clazz = clazz;
        this.nameLabel.setText("Listagem de "+this.clazz.getSimpleName());
        this.voltarButton1.addActionListener(this);
        this.criarNovoButton1.addActionListener(this);

    }

    public JPanel getPainel() {
        return painel;
    }
    public void refreshPainelComponents(){
        this.painel.removeAll();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        int cont = 0;
        for(Object o : this.array){
            c.gridy = cont;
            c.gridx = 0;
            c.weightx = 2;
            this.painel.add(new JLabel(o.toString(),SwingConstants.LEFT),c);
            c.weightx = 0;
            c.gridx = 1;
            JButtonWithObject jbo = new JButtonWithObject("Editar",o);
            jbo.addActionListener(this);
            this.painel.add(jbo,c);
            c.gridx = 2;
            jbo = new JButtonWithObject("Excluir",o);
            jbo.addActionListener(this);
            this.painel.add(jbo,c);
            cont++;
        }
        this.painel.revalidate();
        this.painel.repaint();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        this.painel = new JPanel();
        this.painel.setLayout(new GridBagLayout());
        this.refreshPainelComponents();



    }
}
