package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

public class EvalAction extends TextAction {

    private RSyntaxTextArea _textArea;

    public EvalAction(RSyntaxTextArea textArea) {
        super("Do It");
        this._textArea = textArea;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(this._textArea.getSelectedText());
    }
}
