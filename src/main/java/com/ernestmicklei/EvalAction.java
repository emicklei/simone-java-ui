package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class EvalAction extends RemoteAction {

    public EvalAction(RSyntaxTextArea textArea) {
        super("Do It",textArea);
    }

    String urlAction() {
        return "eval";
    }

    void handleResponse(String json) {
        EvalResult r = new EvalResult(json);
        if (r.error != "") {
            int before = _textArea.getCaretPosition();
            _textArea.append(r.error);
            int end = before+r.error.length();
            _textArea.select(before, end);
        }
        //System.out.println(r.parsedData());
        //new Inspector(r).setVisible(true);
    }
}
