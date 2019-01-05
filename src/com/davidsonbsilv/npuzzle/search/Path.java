package com.davidsonbsilv.npuzzle.search;

import java.util.Objects;

/***
 * Represents a value pair between two states.
 * @author Davidson
 */
public class Path
{
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private Board from;
    private Board to;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Path(Board from, Board to)
    {
        this.from = from;
        this.to = to;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Overrided Methods">
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.from);
        hash = 23 * hash + Objects.hashCode(this.to);
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
        final Path other = (Path) obj;
        if (!Objects.equals(this.from, other.from))
        {
            return false;
        }
        if (!Objects.equals(this.to, other.to))
        {
            return false;
        }
        return true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Board getFrom()
    {
        return from;
    }
    
    public Board getTo()
    {
        return to;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setFrom(Board from)
    {
        this.from = from;
    }

    public void setTo(Board to)
    {
        this.to = to;
    }
    // </editor-fold>
}
