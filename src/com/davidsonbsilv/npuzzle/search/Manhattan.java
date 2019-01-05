package com.davidsonbsilv.npuzzle.search;

public class Manhattan implements Heuristic
{
    @Override
    public Float calculate(Path path)
    {
        int deltaLine;
        int deltaColumn;
        Float distance = 0f;

        for (byte line = 0; line < path.getFrom().getSet().length; ++line)
        {
            for (byte column = 0; column < path.getFrom().getSet()[0].length; ++column)
            {
                byte[] position = findPositionOf(path.getFrom().getSet()[line][column], path.getTo());

                if (position != null)
                {
                    deltaLine = Math.abs(position[0] - line);
                    deltaColumn = Math.abs(position[1] - column);
                    distance += deltaLine + deltaColumn;
                }
            }
        }

        return distance;
    }
    
    private byte[] findPositionOf(byte tile, Board target)
    {
        if (tile != 0)
        {
            for (byte line = 0; line < target.getSet().length; ++line)
            {
                for (byte column = 0; column < target.getSet()[0].length; ++column)
                {
                    if (tile == target.getSet()[line][column])
                    {
                        return new byte[] { line, column };
                    }
                }
            }
        }

        return null;
    }
}
