package com.ernestmicklei;

import javax.swing.*;
import java.awt.*;

public class Inspector extends JFrame {

    public Inspector() {
        JPanel cp = new JPanel(new BorderLayout());

        // String[] columnNames = {"Name", "Age", "Student"};
        String[] columnNames = {"Name", "Value"};

        Object[][] data = {
                {"Ken", 5},
                {"joe", 12.1234},
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
