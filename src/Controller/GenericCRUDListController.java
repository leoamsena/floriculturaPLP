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

        } else if (clazz == Cliente.class) {

        } else if (clazz == Flor.class) {

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

        } else if (o instanceof Cliente) {

        } else if (o instanceof Flor) {

        } else if (o instanceof Funcionario) {

        }
        crud.setResizable(false);
        crud.setSize(new Dimension(500,500));
        crud.setVisible(true);
    }

}
