package com.sen.javaFxml4;



import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainView extends Application {

	public class PropertyVo{
		private IntegerProperty value = new SimpleIntegerProperty();
		public int getValue() {return value.get();};
		public void setValue(int value){this.value.set(value);};
		public IntegerProperty valueProperty() {return value;};
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
		flowPane.setAlignment(Pos.CENTER);
		flowPane.setPadding(new Insets(10));
		flowPane.setVgap(10);
		
		Label label = new Label("텍스트변경");
		label.setPrefWidth(200);
		flowPane.getChildren().add(label);
		
		TextField textField = new TextField();
		textField.prefWidth(200);
		flowPane.getChildren().add(textField);
		
		PropertyVo propertyVo = new PropertyVo();
		textField.textProperty().bind(propertyVo.valueProperty().asString());
		
		Button btn = new Button("1씩증가");
		flowPane.getChildren().add(btn);
		btn.setPrefWidth(100);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				propertyVo.setValue(propertyVo.getValue()+1);
			}
		});
		stage.setScene(new Scene(flowPane,250,150));
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
