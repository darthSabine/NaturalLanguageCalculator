package com.projects;

import java.io.IOError;
import java.util.*;

/**
 * Parser class to set up the Number and Operator Hashmaps, getting user input and parsing it.
 */
public class Parser {

    private static final Map<String, Number> numberMap = new HashMap<>();
    private static final Map<String, Operator> operatorMap = new HashMap<>();


    /**
     * Method to set up the numberMap and operatorMap.
     */
    public static void setupMaps() {

        numberMap.put("zero", new Number(0));
        numberMap.put("one", new Number(1));
        numberMap.put("two", new Number(2));
        numberMap.put("three", new Number(3));
        numberMap.put("four", new Number(4));
        numberMap.put("five", new Number(5));
        numberMap.put("six", new Number(6));
        numberMap.put("seven", new Number(7));
        numberMap.put("eight", new Number(8));
        numberMap.put("nine", new Number(9));
        numberMap.put("ten", new Number(10));

        Operator plus = new Operator((a, b) -> a + b, 1);
        Operator minus = new Operator((a, b) -> a - b, 1);
        Operator multiply = new Operator((a, b) -> a * b, 2);
        Operator divide = new Operator((a, b) -> a / b, 2);

        operatorMap.put("plus", plus);
        operatorMap.put("add", plus);
        operatorMap.put("minus", minus);
        operatorMap.put("subtract", minus);
        operatorMap.put("less", minus);
        operatorMap.put("multiplied-by", multiply);
        operatorMap.put("times", multiply);
        operatorMap.put("divided-by", divide);
        operatorMap.put("over", divide);
    }

    private static ArrayList readUserInput() {
        Scanner sc = new Scanner(System.in);

        try {
            if (sc.hasNextLine()) {
                String input = sc.nextLine().toLowerCase();
                String[] tokenised = input.split("\\s+");
                ArrayList<String> inputList = new ArrayList<>(Arrays.asList(tokenised));
                return inputList;
            }
        } catch (IOError ioError) {
            sc.close();
        }
        return null;
    }

    /**
     * Method to parse the user input and to return a tokenised list with numbers and operators.
     *
     * @return tokenised list
     */
    public static List<Element> parse() {
        List<String> inputList = readUserInput();
        List<Element> tokenisedList = new ArrayList<>();

        if (inputList != null) {
            for (int i = 0; i < inputList.size(); i++) {
                if (i % 2 == 0) {
                    // has to be a number
                    Number n = numberMap.get(inputList.get(i));
                    if (n != null) {
                        tokenisedList.add(n);
                    } else {
                        System.out.println("Input \'" + inputList.get(i) + "\' detected when a number is expected." +
                            " \nPlease enter in the format:\n" +
                            "number operator number\n");
                        return null;
                    }

                } else {
                    // has to be an operator
                    Operator op = operatorMap.get(inputList.get(i));
                    if (op != null) {
                        tokenisedList.add(op);
                    } else {
                        System.out.println("Input \'" + inputList.get(i) + "\' detected when an operator is expected." +
                            " \nPlease enter in the format:\n" +
                            "number operator number\n");
                        return null;
                    }
                }
            }

        }
        return tokenisedList;
    }
}
