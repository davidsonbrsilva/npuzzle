package com.davidsonbsilv.npuzzle.search;

/***
 * Concrete class for Hamming heuristic.
 * @author Davidson
 */
public class Hamming implements Heuristic
{
    @Override
    public Float calculate(Path path)
    {
        Float tiles = 0f;

        for (byte i = 0; i < path.getFrom().getSet().length; ++i)
        {
            for (byte j = 0; j < path.getFrom().getSet()[0].length; ++j)
            {
                if (path.getFrom().getSet()[i][j] != path.getTo().getSet()[i][j])
                {
                    ++tiles;
                }
            }
        }

        return tiles;
    }
}
