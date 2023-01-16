package com.ernestmicklei;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveAsFileAction implements java.awt.event.ActionListener {

    private Workspace _workspace;
    private boolean _forceNewFile;

    public SaveAsFileAction(Workspace w, boolean forceNew) {
        super();
        _workspace = w;
        _forceNewFile = forceNew;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_workspace.hasFilename()) {
            if (!_forceNewFile) {
                this.saveContentsTo(_workspace.getFilename());
                return;
            }
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Workspace - Simone Dialog");
        fileChooser.setSelectedFile(new File(_workspace.getFilename()));
        fileChooser.setFileFilter(new FileNameExtensionFilter(".sim", "sim"));

        int result = fileChooser.showSaveDialog(_workspace);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this._workspace.setFilename(selectedFile.getAbsolutePath());
            this.saveContentsTo(this._workspace.getFilename());
        }
    }

    private void saveContentsTo(String filename) {
        try {
            PrintWriter file = new PrintWriter(new File(filename));
            file.write(_workspace.getContents());
            file.close();
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }
}
