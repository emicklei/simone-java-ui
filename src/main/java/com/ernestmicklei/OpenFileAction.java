package com.ernestmicklei;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenFileAction implements java.awt.event.ActionListener {

    private Workspace _workspace;

    public OpenFileAction(Workspace w) {
        super();
        _workspace = w;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Workspace - Simone Dialog");
        fileChooser.setFileFilter(new FileNameExtensionFilter(".sim", "sim"));
        int result = fileChooser.showOpenDialog(_workspace);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile);
        }
    }
    
}
