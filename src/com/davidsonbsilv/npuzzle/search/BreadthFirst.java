package com.davidsonbsilv.npuzzle.search;

import java.util.LinkedList;

/**
 * Concrete class for Breadth First search method.
 * @author Davidson
 */
public class BreadthFirst extends UninformedSearch<LinkedList<Node>>
{
    /***
     * Create a new instance of BreadthFirst search method.
     * @param path The path to be solved.
     */
    public BreadthFirst(Path path)
    {
        super(path);
        setFrontier(new LinkedList<>());
    }
}
