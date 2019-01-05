package com.davidsonbsilv.npuzzle.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

/**
 * Abstract class for a search tree method.
 * @author Davidson
 * @param <TFrontier> The frontier.
 */
public abstract class Search<TFrontier extends Collection>
{
    private TFrontier frontier;
    private HashSet<Node> seen;
    private Path path;
    private Node solution;
    private Integer expanded;
    
    public Search(Path path)
    {
        this.path = path;
        this.seen = new HashSet<>();
        this.solution = null;
        this.expanded = 0;
    }
    
    public Search(Board from, Board to)
    {
        this(new Path(from, to));
    }
    
    public abstract void search();
    
    protected Node pull()
    {
        if (this.frontier instanceof Stack)
        {
            Stack stack = (Stack)this.frontier;
            return (Node)stack.pop();
        }
        else if (this.frontier instanceof Queue)
        {
            Queue queue = (Queue)this.frontier;
            return (Node)queue.poll();
        }

        return null;
    }
    
    protected void push(Node element)
    {
        if (this.frontier instanceof Stack)
        {
            Stack stack = (Stack)this.frontier;
            stack.push(element);
        }
        else if (this.frontier instanceof Queue)
        {
            Queue queue = (Queue)this.frontier;
            queue.offer(element);
        }
        
        this.expanded++;
    }
    
    public Integer getExpanded()
    {
        return this.expanded;
    }
    
    public void setExpanded(int expanded)
    {
        this.expanded = expanded;
    }
    
    protected ArrayList<Node> getSucessorsOf(Node current)
    {
        for (byte line = 0; line < current.getState().getSet().length; ++line)
        {
            for (byte column = 0; column < current.getState().getSet()[0].length; ++column)
            {
                if (current.getState().getSet()[line][column] == 0)
                {
                    ArrayList<Node> neighbors = new ArrayList<>();

                    int up = line - 1;
                    int down = line + 1;
                    int left = column - 1;
                    int right = column + 1;

                    if (up >= 0)
                    {
                        try
                        {
                            Board upBoard = current.getState().clone();
                            upBoard.getSet()[line][column] = upBoard.getSet()[up][column];
                            upBoard.getSet()[up][column] = 0;
                            neighbors.add(new Node(upBoard, current, current.getCost() + 1));
                        }
                        catch(CloneNotSupportedException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    if (down < current.getState().getSet().length)
                    {                        
                        try
                        {
                            Board downBoard = current.getState().clone();
                            downBoard.getSet()[line][column] = downBoard.getSet()[down][column];
                            downBoard.getSet()[down][column] = 0;
                            neighbors.add(new Node(downBoard, current, current.getCost() + 1));
                        }
                        catch(CloneNotSupportedException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    if (left >= 0)
                    {
                        try
                        {
                            Board leftBoard = current.getState().clone();
                            leftBoard.getSet()[line][column] = leftBoard.getSet()[line][left];
                            leftBoard.getSet()[line][left] = 0;
                            neighbors.add(new Node(leftBoard, current, current.getCost() + 1));
                        }
                        catch(CloneNotSupportedException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    if (right < current.getState().getSet()[0].length)
                    {
                        try
                        {
                            Board rightBoard = current.getState().clone();
                            rightBoard.getSet()[line][column] = rightBoard.getSet()[line][right];
                            rightBoard.getSet()[line][right] = 0;
                            neighbors.add(new Node(rightBoard, current, current.getCost() + 1));
                        }
                        catch(CloneNotSupportedException e)
                        {
                            System.out.println(e.getMessage());
                        }                        
                    }

                    return neighbors;
                }
            }
        }
        
        return null;
    }

    public TFrontier getFrontier()
    {
        return frontier;
    }

    public HashSet<Node> getSeen()
    {
        return seen;
    }

    public Path getPath()
    {
        return path;
    }

    public Node getSolution()
    {
        return solution;
    }

    public void setFrontier(TFrontier frontier)
    {
        this.frontier = frontier;
    }

    public void setSeen(HashSet<Node> seen)
    {
        this.seen = seen;
    }

    public void setPath(Path path)
    {
        this.path = path;
    }

    public void setSolution(Node solution)
    {
        this.solution = solution;
    }
}
