package com.projects;

/**
 * Superclass Element to allow for both Number and Operator to be stored throughout
 * the application in the same data structure.
 */
public abstract class Element {

    private final int precedence;

    /**
     * Basic constructor for precedence.
     *
     * @param precedence
     */
    public Element(int precedence) {
        this.precedence = precedence;
    }

    /**
     * Getter for precedence.
     *
     * @return precedence
     */
    public int getPrecedence() {
        return precedence;
    }

    /**
     * Boolean to return higher precedence.
     *
     * @param that is used for comparison purposes.
     * @return higher precedence
     */
    public boolean lowerPrecedenceThan(Element that) {
        return this.precedence < that.precedence;
    }
}
