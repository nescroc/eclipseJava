package com.sen.server.util;

import com.sen.server.service.Packet;
import com.sen.server.viewload.ServerViewLoader;

import javafx.application.Platform;

public class LogWriter {
	public static void logWrite(Packet packet) {
		Platform.runLater(()->{
			ServerViewLoader.svc0.txtDisplay.appendText(
					packet.getCid());
		});
	}
}
