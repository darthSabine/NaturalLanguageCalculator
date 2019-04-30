package com.projects;

import java.util.function.BinaryOperator;

/**
 * Operator class allowing for the required operators to be used in calculations.
 */
public class Operator extends Element {

    private final BinaryOperator<Double> op;

    /**
     * Basic constructor for the Operator.
     *
     * @param op         Operator
     * @param precedence precedence
     */
    public Operator(BinaryOperator<Double> op, int precedence) {
        super(precedence);
        this.op = op;
    }

    /**
     * Method to return the Operator as a String.
     *
     * @return Operator
     */
    public String toString() {
        return op.toString();
    }


    /**
     * Method to evaluate the Number in order to get their numeric value.
     *
     * @param a representing the first number in a given arithmetic operation.
     * @param b representing the second number in a given arithmetic operation.
     * @return numeric value of Number a and Number b
     */
    public double evaluate(Number a, Number b) {
        return op.apply(a.getValue(), b.getValue());
    }
}
