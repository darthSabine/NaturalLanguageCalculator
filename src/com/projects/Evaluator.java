package com.projects;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Evaluator class allowing for the user input to be evaluated and intermittently stored
 * using the Shunting Yard algorithm.
 */
public class Evaluator {


    /**
     * Shunting Yard algorithm to convert elements of the infix list into elements of
     * the postfix list, using a stack to store the operators.
     *
     * @param infixList containing the numbers and operators to be converted
     * @return postfix list
     */
    public static List<Element> shuntingYard(List<Element> infixList) {
        Deque<Operator> operatorStack = new LinkedList<>();
        List<Element> postfixList = new LinkedList<>();

        for (Element e : infixList) {
            if (e.getPrecedence() > 0) {
                // this must be an operator
                if (!operatorStack.isEmpty()) {
                    if (e.lowerPrecedenceThan(operatorStack.peek())) {
                        postfixList.add(operatorStack.pop());
                    }
                }
                operatorStack.push((Operator) e);
            } else {
                postfixList.add(e);
                // this must be a number
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixList.add(operatorStack.pop());
        }
        return postfixList;
    }

    /**
     * Method to calculate the result by reversely iterating through the postfix list and
     * evaluating the elements of the list.
     *
     * @param postfixList containing the numbers and operators in reverse Polish notation.
     * @return result
     */
    public static double calculateResult(List<Element> postfixList) {
        double result = 0.0;
        ListIterator<Element> iterator = postfixList.listIterator();

        while (iterator.hasNext()) {

            Element e = iterator.next();
            if (e.getPrecedence() > 0) {
                Operator op = (Operator) e;
                iterator.remove();
                e = iterator.previous();
                Number b = (Number) e;
                iterator.remove();
                e = iterator.previous();
                Number a = (Number) e;
                iterator.remove();
                iterator.add(new Number(op.evaluate(a, b)));
            }

            if (postfixList.size() == 1) {
                result = ((Number) postfixList.get(0)).getValue();
                break;
            }
        }


        return result;
    }

}
