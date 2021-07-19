package com.sen.javaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainView7 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("test");
		
		Pane pane = new Pane();
		MenuBar menuBar = new MenuBar();

		Menu menu1 = new Menu("1");
		Menu menu2 = new Menu("2");
		Menu menu3 = new Menu("3");
		menuBar.getMenus().add(menu1);
		menuBar.getMenus().addAll(menu2, menu3);

		MenuItem menuItem1 = new MenuItem("하위메뉴1");
		MenuItem menuItem2 = new MenuItem("하위메뉴2");
		menu1.getItems().addAll(menuItem1, menuItem2);
		Menu menu4 = new Menu("메뉴4");
		MenuItem menuItem3 = new MenuItem("하위메뉴3");
		SeparatorMenuItem separate = new SeparatorMenuItem();
		MenuItem menuItem4 = new MenuItem("하위메뉴4");
		menu4.getItems().addAll(menuItem3,separate,menuItem4);
		menu2.getItems().add(menu4);
		
		pane.getChildren().add(menuBar);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

	}
	public static void main(String[] args) {
		Application.launch(MainView7.class);
	}
}
