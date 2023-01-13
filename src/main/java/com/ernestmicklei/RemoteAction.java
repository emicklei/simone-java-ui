package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import javax.swing.text.TextAction;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class RemoteAction extends TextAction {
    protected RSyntaxTextArea _textArea;

    public RemoteAction(String name, RSyntaxTextArea textArea) {
        super(name);
        this._textArea = textArea;
    }

    abstract String urlAction();

    public void actionPerformed(ActionEvent e) {
        String entry = this._textArea.getSelectedText();
        if (entry == null || entry.isEmpty()) {
            try {
                // try select whole line
                int from = _textArea.getLineStartOffset(_textArea.getCaretLineNumber());
                int to = _textArea.getLineEndOffset(_textArea.getCaretLineNumber());
                _textArea.select(from,to);
            } catch (Exception ex) {
                System.out.println(ex);
                return;
            }
            // retry
            entry = this._textArea.getSelectedText();
            if (entry == null || entry.isEmpty()) {
                return;
            }
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.BodyPublisher bp = HttpRequest.BodyPublishers.ofString(entry);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9119/v1?action=" + urlAction()))
                .POST(bp)
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(this::handleResponse)
                .exceptionally(this::handlError)
                .join();
    }

    abstract void handleResponse(String json);

    private Void handlError(Throwable ex) {
        System.out.println(ex.toString());
        return null;
    }
}
