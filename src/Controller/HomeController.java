package Controller;

import Model.Flor;
import View.GenericCRUDList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomeController {
    private static JDialog listDialog;
    public static GenericCRUDList genericCRUDList;

    public static void openGenericCRUD(ArrayList a,Class<?> clazz){
        listDialog = new JDialog(MainController.getFrame(),"Lista: ",JDialog.ModalityType.DOCUMENT_MODAL);
        genericCRUDList = new GenericCRUDList(a, clazz);
        listDialog.setContentPane(genericCRUDList.getPanel());
        listDialog.setResizable(false);
        listDialog.setSize(new Dimension(500,500));
        listDialog.setVisible(true);
    }


    public static JDialog getListDialog() {
        return listDialog;
    }
}
