package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        CalculatorController controller = new CalculatorController();
        CalculatorUI calculatorUI = new CalculatorUI(controller);

        Scene scene = new Scene(calculatorUI.createUI(), 300, 400);
        scene.setOnKeyPressed(event -> controller.handleKeyInput(event.getCode()));

        primaryStage.setTitle("JavaFX Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
