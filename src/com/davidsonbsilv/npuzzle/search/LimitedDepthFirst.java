package com.davidsonbsilv.npuzzle.search;

import java.util.ArrayList;

public class LimitedDepthFirst extends DepthFirst
{
    private Integer limit;
    
    public LimitedDepthFirst(Path path, Integer limit)
    {
        super(path);
        this.limit = limit;
    }
    
    @Override
    public void search()
    {
        Node start = new Node(getPath().getFrom());
        getFrontier().add(start);
        
        while (!getFrontier().isEmpty())
        {
            Node current = pull();
            
            if (current.getCost() >= this.limit)
            {
                continue;
            }
            
            /*if (getSeen().contains(current))
            {
                continue;
            }
            
            getSeen().add(current);*/
            
            if (current.getState().equals(getPath().getTo()))
            {
                setSolution(current);
                return;
            }
            
            ArrayList<Node> sucessors = getSucessorsOf(current);
            
            for (int i = 0; i < sucessors.size(); ++i)
            {
                push(sucessors.get(i));
            }
        }
    }

    public Integer getLimit()
    {
        return limit;
    }

    public void setLimit(Integer limit)
    {
        this.limit = limit;
    }
    
    
}
