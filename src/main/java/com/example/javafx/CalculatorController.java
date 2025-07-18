package com.example.javafx;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class CalculatorController {

    private TextField display;
    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    public void setDisplay(TextField display) {
        this.display = display;
    }

    public void process(String value) {
        if ("0123456789".contains(value)) {
            if (start) {
                display.clear();
                start = false;
            }
            display.appendText(value);
        } else if ("+-*/".contains(value)) {
            operator = value;
            num1 = Double.parseDouble(display.getText());
            display.clear();
        } else if ("=".equals(value)) {
            try {
                double num2 = Double.parseDouble(display.getText());
                calculate(num2);
            } catch (NumberFormatException e) {
                display.setText("Error");
            }
        } else if ("C".equals(value)) {
            display.clear();
            start = true;
            operator = "";
            num1 = 0;
        }
    }

    private void calculate(double num2) {
        double result;
        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    display.setText("Cannot divide by 0");
                    return;
                }
                result = num1 / num2;
            }
            default -> {
                display.setText("Error");
                return;
            }
        }
        display.setText(String.valueOf(result));
        start = true;
    }

    public void handleKeyInput(KeyCode keyCode) {
        switch (keyCode) {
            case DIGIT0, NUMPAD0 -> process("0");
            case DIGIT1, NUMPAD1 -> process("1");
            case DIGIT2, NUMPAD2 -> process("2");
            case DIGIT3, NUMPAD3 -> process("3");
            case DIGIT4, NUMPAD4 -> process("4");
            case DIGIT5, NUMPAD5 -> process("5");
            case DIGIT6, NUMPAD6 -> process("6");
            case DIGIT7, NUMPAD7 -> process("7");
            case DIGIT8, NUMPAD8 -> process("8");
            case DIGIT9, NUMPAD9 -> process("9");
            case ADD -> process("+");
            case SUBTRACT -> process("-");
            case MULTIPLY -> process("*");
            case DIVIDE -> process("/");
            case ENTER, EQUALS -> process("=");
            case BACK_SPACE -> process("C");
        }
    }
}
