/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsonbsilv.npuzzle.search;

public class IteractiveDepthFirst extends DepthFirst
{
    private int limit;
    
    public IteractiveDepthFirst(Path path)
    {
        super(path);
        limit = 1;
    }
    
    @Override
    public void search()
    {
        LimitedDepthFirst lDepth = new LimitedDepthFirst(getPath(), limit);

        while (lDepth.getSolution() == null)
        {
            System.out.println(limit);
            lDepth.setLimit(limit);
            lDepth.getFrontier().clear();
            lDepth.getSeen().clear();
            lDepth.search();
            ++limit;
        }
        
        setSolution(lDepth.getSolution());
        setExpanded(lDepth.getExpanded());
    }
    
    public int getLimit()
    {
        return this.limit;
    }
}
