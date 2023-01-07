package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.text.TextAction;
import java.awt.event.ActionEvent;

public class InspectAction extends TextAction {

    private RSyntaxTextArea _textArea;

    public InspectAction(RSyntaxTextArea textArea) {
        super("Inspect It");
        this._textArea = textArea;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(this._textArea.getSelectedText());
    }
}
