package com.sen.javaFx;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class MainView9 extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Button btn1 = new Button("알림창");
		btn1.setPrefSize(100, 30);
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION, "알림내용 전달문구");
				alert.setHeaderText("다이얼로그 머리글");
				alert.show();
			}
		});

		Button btn2 = new Button("선택팝업");
		btn2.setPrefSize(100, 30);
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION, "예/아니오");
				ButtonType btnType1 = new ButtonType("예");
				ButtonType btnType2 = new ButtonType("아니오");
				ButtonType btnType3 = new ButtonType("취소", ButtonData.CANCEL_CLOSE);
				alert.getButtonTypes().setAll(btnType1, btnType2, btnType3);

				Optional<ButtonType> result = alert.showAndWait();

				if (result.get() == btnType1) {
					System.out.println("예 선택");
				} else if (result.get() == btnType2) {
					System.out.println("아니오 선택");
				} else if (result.get() == btnType3) {
					System.out.println("취소 선택");
				}

			}
		});
		
		Button btn3 = new Button("Input팝업");
		btn3.setPrefSize(100, 3);
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				TextInputDialog alert
				= new TextInputDialog("입력하고자 하는 값을 이곳에 입력하시오.");
				
				alert.setHeaderText("머리글 입력 값");
				alert.setContentText("알림내용 입력 값");
				alert.getDialogPane().setPrefSize(450, 200);
				
				Optional<String> result = alert.showAndWait();
				
				if (result.isPresent()) {
					System.out.println(result.get());
				}
			}
		
			
		});
		FlowPane pane = new FlowPane(Orientation.VERTICAL,btn1,btn2,btn3);
		Scene scene = new Scene(pane,300,300);
		stage.setScene(scene);
		stage.show();
		
	}

}
