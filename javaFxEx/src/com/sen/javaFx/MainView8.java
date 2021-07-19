package com.sen.javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView8 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("title");

		BorderPane root = new BorderPane();
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("�޴�1");
		Menu menu2 = new Menu("�޴�2");
		Menu menu3 = new Menu("�޴�3");
		menuBar.getMenus().add(menu1);/* �޴���� */
		menuBar.getMenus().addAll(menu2, menu3);/* �޴��ϰ���� */
		MenuItem menuItem11 = new MenuItem("�����޴�11");
		MenuItem menuItem12 = new MenuItem("�����޴�12");
		menu1.getItems().addAll(menuItem11, menuItem12);

		Menu menu4 = new Menu("�޴�4");
		MenuItem menuItem21 = new MenuItem("�����޴�21");
		SeparatorMenuItem separate = new SeparatorMenuItem();
		MenuItem menuItem22 = new MenuItem("�����޴�22");
		menu4.getItems().addAll(menuItem21, separate, menuItem22);
		menu2.getItems().add(menu4);

		menu1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				/* �̺�Ʈ ���� �����ۼ� */
				System.out.println("�޴�1 Ŭ�� �̺�Ʈ ��������");
			}
		});

		menuItem11.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("�����޴�11 Ŭ�� �̺�Ʈ ��������");
			}
		});

		root.setTop(menuBar);

		Scene scene = new Scene(root, 500, 400);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(new MainView8().getClass());
	}
}
