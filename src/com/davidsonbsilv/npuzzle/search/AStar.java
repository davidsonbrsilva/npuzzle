package com.davidsonbsilv.npuzzle.search;

/***
 * Concrete class for A* search method.
 * @author Davidson
 */
public class AStar extends InformedSearch
{

    /***
     * Create a new instance of A* search method.
     * @param path The path to be solved.
     * @param heuristic The heuristic to be applied.
     */
    public AStar(Path path, Heuristic heuristic)
    {
        super(path, heuristic);
    }

    @Override
    public float evaluate(Node node)
    {
        return node.getCost() + getHeuristic().calculate(new Path(node.getState(), getPath().getTo()));
    }
    
}
