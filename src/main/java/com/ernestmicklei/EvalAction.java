package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.text.TextAction;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EvalAction extends TextAction {

    private RSyntaxTextArea _textArea;

    public EvalAction(RSyntaxTextArea textArea) {
        super("Do It");
        this._textArea = textArea;
    }

    public void actionPerformed(ActionEvent e) {
        String entry = this._textArea.getSelectedText();
        if (entry == null || entry.isEmpty()) {
            return;
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.BodyPublisher bp = HttpRequest.BodyPublishers.ofString(entry);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9119/v1?action=eval"))
                .POST(bp)
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(this::handleEvalResponse)
                .exceptionally(this::handlError)
                .join();
    }

    private Void handlError(Throwable ex) {
        System.out.println(ex.toString());
        return null;
    }

    private void handleEvalResponse(String json) {
        EvalResult r = new EvalResult(json);
        //System.out.println(r.parsedData());
        new Inspector().setVisible(true);
    }
}
