/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsonbsilv.npuzzle.search;

import java.util.Stack;

/**
 * Concrete class for Depth First search method.
 * @author Davidson
 */
public class DepthFirst extends UninformedSearch
{
    /***
     * Create a new instance of Depth First method.
     * @param path The path to be solved.
     */
    public DepthFirst(Path path)
    {
        super(path);
        setFrontier(new Stack<>());
    }
    
}
