package com.ernestmicklei;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.BodyPublisher bp = HttpRequest.BodyPublishers.ofString(this._textArea.getSelectedText());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9119/v1?action=eval"))
                .POST(bp)
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(this::handleEvalResponse)
                .join();
    }
    private void handleEvalResponse(String json) {
        new SimonUI().setVisible(true);
    }
}
