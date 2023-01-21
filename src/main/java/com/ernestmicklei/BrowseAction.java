package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class BrowseAction extends RemoteAction {

    public BrowseAction(RSyntaxTextArea textArea) {
        super("Browse It",textArea);
    }

    String urlAction() {
        return "browse";
    }

    void handleResponse(String json) {
        Debug.log("Browsing JSON", json); 
    }
}
