package com.projects;

/**
 * Number class allowing for a required numeric value.
 */
public class Number extends Element {

    private final double value;

    /**
     * Basic constructor for Number.
     *
     * @param value allows for a numeric value
     */
    public Number(double value) {
        super(0);
        this.value = value;
    }

    /**
     * Method to return the numeric value of Number as a String.
     *
     * @return value
     */
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Getter for value.
     *
     * @return value
     */
    public double getValue() {
        return value;
    }
}
