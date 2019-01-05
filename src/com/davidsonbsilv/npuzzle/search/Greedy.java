package com.davidsonbsilv.npuzzle.search;

/***
 * Concrete class for Greedy search method.
 * @author Davidson
 */
public class Greedy extends InformedSearch
{
    /***
     * Create a new instance of Greedy search method.
     * @param path The path to be solved.
     * @param heuristic The heuristic to be applied.
     */
    public Greedy(Path path, Heuristic heuristic)
    {
        super(path, heuristic);
    }

    @Override
    public float evaluate(Node node)
    {
        return getHeuristic().calculate(new Path(node.getState(), getPath().getTo()));
    }
}
