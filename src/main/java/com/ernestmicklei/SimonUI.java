package com.ernestmicklei;

import javax.swing.*;

public class SimonUI  {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Workspace().setVisible(true);
            }
        });
    }
}