package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class InspectAction extends RemoteAction {

    public InspectAction(RSyntaxTextArea textArea) {
        super("Inspect It",textArea);
    }

    String urlAction() {
        return "inspect";
    }

    void handleResponse(String json) {
        Debug.log("Inspecting JSON", json);
        InspectResult r = new InspectResult(json);
        new Inspector(r).setVisible(true);
    }
}
