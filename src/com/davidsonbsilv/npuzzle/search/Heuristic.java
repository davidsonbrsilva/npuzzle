package com.davidsonbsilv.npuzzle.search;

/**
 * Abstract class that represents a heuristic.
 * @author Davidson
 */
public interface Heuristic
{
    /***
     * Calculate the value of path.
     * @param path The path to be calculated.
     * @return The calculated value of path.
     */
    abstract Float calculate(Path path);
}
