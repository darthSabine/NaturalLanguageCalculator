package com.projects;

import java.text.DecimalFormat;
import java.util.List;

/**
 * This calculator takes in natural language commands representing number
 * values and performs basic arithmetic operations on them, returning a numeric result.
 *
 * @author Sabine Lisa Högl
 */
public class NaturalLanguageCalculator {

    /**
     * Entry point of the calculator.
     *
     * @param args supplies command-line arguments.
     */
    public static void main(String[] args) {

        Parser.setupMaps();
        while (true) {
            System.out.println("Please enter a calculation:");
            List<Element> infixList = Parser.parse();
            if (infixList != null) {
                List<Element> postfixList = Evaluator.shuntingYard(infixList);
                double result = Evaluator.calculateResult(postfixList);
                System.out.println("Result: " + new DecimalFormat("#.##").format(result));
            } else {

            }
        }
    }
}
