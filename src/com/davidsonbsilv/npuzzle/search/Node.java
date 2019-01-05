package com.davidsonbsilv.npuzzle.search;

import java.util.Objects;

/***
 * Represents the unit of search tree.
 * @author Davidson
 */
public class Node implements Comparable
{
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private Node parent;
    private Board state;
    private Integer cost;
    private Float factor;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Node(Board state)
    {
        this.state = state;
        this.cost = 0;
    }
    
    public Node(Board state, Node parent, Integer cost)
    {
        this.state = state;
        this.parent = parent;
        this.cost = cost;
    }
    
    public Node(Board state, Node parent, Integer cost, Float factor)
    {
        this(state, parent, cost);
        this.factor = factor;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Node getParent()
    {
        return parent;
    }

    public Board getState()
    {
        return state;
    }

    public Integer getCost()
    {
        return cost;
    }

    public Float getFactor()
    {
        return factor;
    }
    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setParent(Node parent)
    {
        this.parent = parent;
    }

    public void setState(Board state)
    {
        this.state = state;
    }

    public void setCost(Integer cost)
    {
        this.cost = cost;
    }

    public void setFactor(Float factor)
    {
        this.factor = factor;
    }
    
    // </editor-fold>

    @Override
    public int compareTo(Object o)
    {
        if (this == o)
        {
            return 0;
        }
        
        if (o instanceof Node)
        {
            Node otherNode = (Node) o;
            
            if (this.factor < otherNode.factor)
            {
                return -1;
            }
            else if(this.factor > otherNode.factor)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        
        return -1;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.state);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Node other = (Node) obj;
        if (!Objects.equals(this.state, other.state))
        {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString()
    {
        return "Cost: " + getCost() + "\n" + getState();
    }
}
