package com.ernestmicklei;

import java.awt.*;
import javax.swing.*;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

/**
 * A simple example showing how to use RSyntaxTextArea to add Java syntax
 * highlighting to a Swing application.
 */
public class SimonUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public SimonUI() {

        JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));

        JPopupMenu popup = textArea.getPopupMenu();
        popup.add(new JMenuItem(new EvalAction(textArea)),0);
        popup.add(new JMenuItem(new InspectAction(textArea)),1);
        popup.add(new JPopupMenu.Separator(),2);

        cp.add(sp);

        setContentPane(cp);
        setTitle("Simone");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        // Start all Swing applications on the EDT.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimonUI().setVisible(true);
            }
        });
    }
}