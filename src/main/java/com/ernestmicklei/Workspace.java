package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.autocomplete.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Workspace extends JFrame {
    public Workspace(String source) {
        JPanel cp = new JPanel(new BorderLayout());

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setText(source);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_ACTIONSCRIPT);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        textArea.getKeymap().addActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK),
                new InspectAction(textArea));
        textArea.getKeymap().addActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK),
                new EvalAction(textArea));
        // textArea.getKeymap().addActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,InputEvent.CTRL_DOWN_MASK),
        //         new AutoCompleteAction(textArea));

        // CompletionProvider provider = createCompletionProvider();
        // AutoCompletion ac = new AutoCompletion(provider);
        // ac.install(textArea);

        JPopupMenu popup = textArea.getPopupMenu();
        JMenuItem evalItem = new JMenuItem(new EvalAction(textArea));        
        evalItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        popup.add(evalItem, 0);

        JMenuItem inspectItem = new JMenuItem(new InspectAction(textArea));
        inspectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        popup.add(inspectItem, 1);
        popup.add(new JPopupMenu.Separator(), 2);

        cp.add(sp);

        // menu
        // https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html

        JMenuBar menuBar;
        JMenu menu;

        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuBar.add(menu);
        {
            JMenuItem menuItem;
            menuItem = new JMenuItem("Open", KeyEvent.VK_O);
            // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
            // ActionEvent.ALT_MASK));
            menu.add(menuItem);
        }
        {
            JMenuItem menuItem;
            menuItem = new JMenuItem("Save", KeyEvent.VK_S);
            // menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
            // ActionEvent.ALT_MASK));
            menu.add(menuItem);
        }
        setJMenuBar(menuBar);

        setContentPane(cp);
        setTitle("Simone - Workspace");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
    private CompletionProvider createCompletionProvider() {

        DefaultCompletionProvider provider = new DefaultCompletionProvider();

        // Add completions for all Java keywords. A BasicCompletion is just
        // a straightforward word completion.
        provider.addCompletion(new BasicCompletion(provider, "Func"));
        return provider;
    }
}
