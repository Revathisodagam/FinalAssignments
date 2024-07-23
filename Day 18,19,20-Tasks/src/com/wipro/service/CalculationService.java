package com.wipro.service;

import com.wipro.model.CalculationRequest;

public class CalculationService {

    public static int performCalculation(CalculationRequest request) {
        int num1 = request.getNum1();
        int num2 = request.getNum2();
        String operation = request.getOperation();

        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
}
