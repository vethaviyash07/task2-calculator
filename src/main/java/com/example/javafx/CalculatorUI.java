package com.example.javafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalculatorUI {

    private final CalculatorController controller;
    private final TextField display;

    public CalculatorUI(CalculatorController controller) {
        this.controller = controller;
        this.display = new TextField();
        controller.setDisplay(display);
    }

    public VBox createUI() {
        display.setEditable(false);
        display.setPrefHeight(50);
        display.setStyle("-fx-font-size: 18px;");
        display.setAlignment(Pos.CENTER_RIGHT);

        GridPane grid = createButtons();

        VBox root = new VBox(10, display, grid);
        root.setPadding(new Insets(10));
        return root;
    }

    private GridPane createButtons() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        String[] buttons = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", "C", "=", "/"
        };

        int index = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                String text = buttons[index++];
                Button btn = new Button(text);
                btn.setPrefSize(60, 60);
                btn.setStyle("-fx-font-size: 18px;");
                btn.setTooltip(new Tooltip("Button: " + text));
                btn.setOnAction(e -> controller.process(text));
                grid.add(btn, col, row);
            }
        }
        return grid;
    }
}
