package com.ernestmicklei;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Inspector extends JFrame {

    public Inspector(InspectResult result) {
        JPanel cp = new JPanel(new BorderLayout());

        if (result.object == null) {
            Debug.log("result.object null");
            // TODO show dialog
            return;
        }
        if (result.object.isEmpty()) {
            Debug.log("result.object empty");
            // TODO show dialog or flash msg
            return;
        }
        String[] keys = new String[result.object.size()];
        Debug.log("result.object.size", keys.length);
        int row = 0;
        for (Iterator<String> it = result.object.keySet().iterator(); it.hasNext();) {
            keys[row] = it.next();
            row++;
        }
        if (result.is_array) {
            Arrays.sort(keys, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
                }
            });
        } else {
            Arrays.sort(keys);
        }
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
        table.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        table.setColumnSelectionAllowed(true);
        // table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setMinWidth(200);
        table.getColumnModel().getColumn(0).setMaxWidth(200);

        cp.setBorder(new EmptyBorder(2, 2, 2, 2));

        int preferredHeight = keys.length * 16;
        // wrap in scrollable if larger than
        if (preferredHeight > 800) {
            JScrollPane scroll_table = new JScrollPane(table);
            scroll_table.setBounds(5, 10, 300, 150);
            scroll_table.setVisible(true);
            cp.add(scroll_table);
        } else {
            cp.add(table);
        }

        setContentPane(cp);
        setMinimumSize(new Dimension(600, Math.min(800, preferredHeight)));
        setTitle(result.datatype + " - Inspector");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
