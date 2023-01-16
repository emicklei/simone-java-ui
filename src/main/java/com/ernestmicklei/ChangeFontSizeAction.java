package com.ernestmicklei;

import java.awt.event.ActionEvent;

import javax.swing.text.TextAction;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class ChangeFontSizeAction extends TextAction {
    protected RSyntaxTextArea _textArea;

    public ChangeFontSizeAction(RSyntaxTextArea textArea) {
        super("Change Font");
        this._textArea = textArea;
    }

    public void actionPerformed(ActionEvent e) {
        java.awt.Font f = _textArea.getFont();
        int delta = 1;
        if (e.getActionCommand().equals("-")) {
            delta = -1;
        }
        int newsize = Math.max(8, Math.min(f.getSize() + delta, 36));
        java.awt.Font n = f.deriveFont(f.getStyle(), newsize);
        _textArea.setFont(n);
    }
}
