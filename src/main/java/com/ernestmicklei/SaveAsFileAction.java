package com.ernestmicklei;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveAsFileAction implements java.awt.event.ActionListener {

    private Workspace _workspace;

    public SaveAsFileAction(Workspace w) {
        super();
        _workspace = w;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Workspace - Simone Dialog");
        fileChooser.setSelectedFile(new File("test.sim"));
        fileChooser.setFileFilter(new FileNameExtensionFilter(".sim", "sim"));

        int result = fileChooser.showSaveDialog(_workspace);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile);

            // FileWriter outFile = new FileWriter(file);
            // PrintWriter file = new PrintWriter(new File(path+"EncryptedMessage.txt"));

            // for (int i = 0; i <EncryptCodes.length; i++) {
            // file.write(EncryptCodes[i]+ " \r\n");
            // }
            // file.close();
        }
    }

}
