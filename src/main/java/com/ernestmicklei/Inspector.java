package com.ernestmicklei;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;

public class Inspector extends JFrame {

    public Inspector(InspectResult result) {
        JPanel cp = new JPanel(new BorderLayout());

        if (result.object == null) {
            // TODO show dialog
            return;
        }
        String[] keys = new String[result.object.size()];
        int row = 0;
        for (Iterator<String> it = result.object.keySet().iterator(); it.hasNext();) {
            keys[row] = it.next();
            row++;
        }
        Arrays.sort(keys);
        Object[][] data = new Object[result.object.size()][2];
        row = 0;
        for (row = 0; row < keys.length; row++) {
            String key = keys[row];
            Object value = result.object.get(key);
            data[row][0] = key;
            data[row][1] = value;
        }
        String[] columnNames = { "Name", "Value" };
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        table.setColumnSelectionAllowed(true);

        cp.setBorder(new EmptyBorder(4, 4, 4, 4));
        cp.add(table);

        setContentPane(cp);
        setTitle("Simone - Inspector");
        setMinimumSize(new Dimension(200, 300));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
