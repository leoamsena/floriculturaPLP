package Controller;

import Model.*;
import View.GenericCRUDList;

import javax.swing.*;
import java.awt.*;

public class GenericCRUDListController {
    private static JDialog crud;
    public static void excluir(Object o){
        if(o instanceof Fornecedor){
            MainController.getFornecedores().remove(o);
        }else if(o instanceof Compra){
            MainController.getCompras().remove(o);
        }else if(o instanceof Cliente){
            MainController.getClientes().remove(o);
        }else if(o instanceof Flor){
            MainController.getFlores().remove(o);
        }else if(o instanceof Funcionario){
            MainController.getFuncionarios().remove(o);
        }
    }

    public static JDialog getCrud() {
        return crud;
    }
    public static void openCreate(Class<?> clazz){
        crud = new JDialog(HomeController.getListDialog(),"Criar: ",JDialog.ModalityType.DOCUMENT_MODAL);
        if (clazz == Fornecedor.class) {
            crud.setContentPane(new View.CreateUpdate.Fornecedor().getPanel());
        } else if (clazz == Compra.class) {
            crud.setContentPane(new View.CreateUpdate.Compra().getPanel());
        } else if (clazz == Cliente.class) {
            crud.setContentPane(new View.CreateUpdate.Cliente().getPanel());
        } else if (clazz == Flor.class) {
            crud.setContentPane(new View.CreateUpdate.Flor().getPanel());
        } else if (clazz == Funcionario.class) {

        }
        crud.setResizable(false);
        crud.setSize(new Dimension(500,500));
        crud.setVisible(true);
    }

    public static void openUpdate(Object o){
        crud = new JDialog(HomeController.getListDialog(),"Editar "+o.getClass().getSimpleName(),JDialog.ModalityType.DOCUMENT_MODAL);
        if (o instanceof Fornecedor) {
            crud.setContentPane(new View.CreateUpdate.Fornecedor((Fornecedor) o).getPanel());
        } else if (o instanceof Compra) {
            crud.setContentPane(new View.CreateUpdate.Compra((Compra) o).getPanel());
        } else if (o instanceof Cliente) {
            crud.setContentPane(new View.CreateUpdate.Cliente((Cliente) o).getPanel());
        } else if (o instanceof Flor) {
            crud.setContentPane(new View.CreateUpdate.Flor((Flor) o).getPanel());
        } else if (o instanceof Funcionario) {

        }
        crud.setResizable(false);
        crud.setSize(new Dimension(500,500));
        crud.setVisible(true);
    }

}
