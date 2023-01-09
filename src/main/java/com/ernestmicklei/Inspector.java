package com.ernestmicklei;

import javax.swing.*;
import java.awt.*;

public class Inspector extends JFrame {

    public Inspector() {
        JPanel cp = new JPanel(new BorderLayout());

        String[] columnNames = {"Name", "Age", "Student"};

        Object[][] data = {
                {"Ken", new Integer(5), new Boolean(false)},
                {"Tom", new Integer(3), new Boolean(true)},
                {"Susam", new Integer(2), new Boolean(false)},
                {"Mark", new Integer(20), new Boolean(true)},
                {"Joe", new Integer(10), new Boolean(false)}
        };
        JTable table = new JTable(data, columnNames);

        cp.add(table);

        setContentPane(cp);
        setTitle("Simone - Inspector");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
