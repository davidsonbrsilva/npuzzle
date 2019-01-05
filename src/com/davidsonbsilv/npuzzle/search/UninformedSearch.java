package com.davidsonbsilv.npuzzle.search;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Davidson
 * @param <TFrontier> A frontier type to store the expanded nodes.
 */
public abstract class UninformedSearch<TFrontier extends Collection> extends Search<TFrontier>
{
    public UninformedSearch(Path path)
    {
        super(path);
    }
    
    public UninformedSearch(Board from, Board to)
    {
        super(new Path(from, to));
    }
    
    @Override
    public void search()
    {
        Node start = new Node(getPath().getFrom());
        getFrontier().add(start);
        
        while (!getFrontier().isEmpty())
        {
            Node current = pull();
            
            if (getSeen().contains(current))
            {
                continue;
            }
            
            getSeen().add(current);
            
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
}
