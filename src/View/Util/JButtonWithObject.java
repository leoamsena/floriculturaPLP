package View.Util;

import javax.swing.*;

public class JButtonWithObject extends JButton {
    private Object object;

    public JButtonWithObject(String text, Object object) {
        super(text);
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
