package com.sen.client.service;

import com.sen.client.viewload.ViewLoader;

import javafx.application.Platform;

public class TextWriter {
	public static void write(String message) {
		Platform.runLater(()->{
			ViewLoader.roomListController.roomchatArea.appendText(message+"\n");
		});
	}
}
