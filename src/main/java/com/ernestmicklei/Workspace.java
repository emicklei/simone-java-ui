package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

public class Workspace extends JFrame {
    public Workspace() {
        JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));

        JPopupMenu popup = textArea.getPopupMenu();
        popup.add(new JMenuItem(new EvalAction(textArea)), 0);
        popup.add(new JMenuItem(new InspectAction(textArea)), 1);
        popup.add(new JPopupMenu.Separator(), 2);

        cp.add(sp);

        setContentPane(cp);
        setTitle("Simone - Workspace");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}