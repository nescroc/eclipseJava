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
		Button btn1 = new Button("�˸�â");
		btn1.setPrefSize(100, 30);
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION, "�˸����� ���޹���");
				alert.setHeaderText("���̾�α� �Ӹ���");
				alert.show();
			}
		});

		Button btn2 = new Button("�����˾�");
		btn2.setPrefSize(100, 30);
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION, "��/�ƴϿ�");
				ButtonType btnType1 = new ButtonType("��");
				ButtonType btnType2 = new ButtonType("�ƴϿ�");
				ButtonType btnType3 = new ButtonType("���", ButtonData.CANCEL_CLOSE);
				alert.getButtonTypes().setAll(btnType1, btnType2, btnType3);

				Optional<ButtonType> result = alert.showAndWait();

				if (result.get() == btnType1) {
					System.out.println("�� ����");
				} else if (result.get() == btnType2) {
					System.out.println("�ƴϿ� ����");
				} else if (result.get() == btnType3) {
					System.out.println("��� ����");
				}

			}
		});
		
		Button btn3 = new Button("Input�˾�");
		btn3.setPrefSize(100, 3);
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				TextInputDialog alert
				= new TextInputDialog("�Է��ϰ��� �ϴ� ���� �̰��� �Է��Ͻÿ�.");
				
				alert.setHeaderText("�Ӹ��� �Է� ��");
				alert.setContentText("�˸����� �Է� ��");
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
