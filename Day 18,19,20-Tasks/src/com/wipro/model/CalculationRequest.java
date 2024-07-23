package com.wipro.model;

import java.io.Serializable;

public class CalculationRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private int num1;
    private int num2;
    private String operation;

    public CalculationRequest(int num1, int num2, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "CalculationRequest{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operation='" + operation + '\'' +
                '}';
    }
}
