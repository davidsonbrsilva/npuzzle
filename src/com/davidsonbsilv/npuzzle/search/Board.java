package com.davidsonbsilv.npuzzle.search;

import java.util.Arrays;

/**
 * Represents a board of NPuzzle game.
 * @author Davidson
 */
public class Board implements Cloneable
{
    private byte[][] set;
    
    /***
     * Create a new instance of Board.
     * @param set The set of board.
     */
    public Board(byte[][] set)
    {
        this.set = set;
    }

    public byte[][] getSet()
    {
        return set;
    }

    public void setSet(byte[][] set)
    {
        this.set = set;
    }
    
    @Override
    public Board clone() throws CloneNotSupportedException
    {
        byte[][] cloneSet = new byte[getSet().length][getSet()[0].length];

        for (int line = 0; line < getSet().length; ++line)
        {
            for (int column = 0; column < getSet()[0].length; ++column)
            {
                cloneSet[line][column] = getSet()[line][column];
            }
        }

        return new Board(cloneSet);
    }
    
    @Override
    public String toString()
    {
        String text = "";

        for (int line = 0; line < this.set.length; ++line)
        {
            for (int column = 0; column < this.set[0].length; ++column)
            {
                text += this.set[line][column] + " ";
            }

            text += "\n";
        }

        return text;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 47 * hash + Arrays.deepHashCode(this.set);
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
        final Board other = (Board) obj;
        if (!Arrays.deepEquals(this.set, other.set))
        {
            return false;
        }
        return true;
    }
}
