package com.davidsonbsilv.npuzzle.search;

import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class InformedSearch extends Search<PriorityQueue<Node>>
{
    private Heuristic heuristic;
    
    public InformedSearch(Path path)
    {
        super(path);
        setFrontier(new PriorityQueue<>());
    }
    
    public InformedSearch(Path path, Heuristic heuristic)
    {
        this(path);
        this.heuristic = heuristic;
    }
    
    public InformedSearch(Board from, Board to)
    {
        super(new Path(from, to));
    }
    
    @Override
    public void search()
    {
        Node start = new Node(getPath().getFrom());
        
        Float priority = evaluate(start);
        start.setFactor(priority);        
        push(start);
        
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
                priority = evaluate(sucessors.get(i));
                sucessors.get(i).setFactor(priority);
                push(sucessors.get(i));
            }
        }
    }
    
    public abstract float evaluate(Node node);

    public Heuristic getHeuristic()
    {
        return heuristic;
    }

    public void setHeuristic(Heuristic heuristic)
    {
        this.heuristic = heuristic;
    }
}
