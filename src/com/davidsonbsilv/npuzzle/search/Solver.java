package com.davidsonbsilv.npuzzle.search;

import java.util.ArrayList;

public class Solver
{
    private static Solver instance;
    private static Float elapsed;
    private static Integer expanded;
    private static String message;
    private static ArrayList steps;   
    
    public static synchronized Solver getInstance()
    {
        if (instance == null)
        {
            instance = new Solver();
        }
        
        return instance;
    }
    
    public void solve(Search method)
    {
        System.out.println("Solving...");
        long startTime = System.currentTimeMillis();
        method.search();
        long endTime = System.currentTimeMillis();
        System.out.println("Finished.");
        
        this.elapsed = (float)(endTime - startTime) / 1000;
        this.expanded = method.getExpanded();
        
        System.out.println("Elapsed: " + elapsed + " seconds.");
        
        if (method.getSolution() != null)
        {
            this.message = "<h1 style='color: #9966FF;'>Solução encontrada.</h1><p>Custo: " + method.getSolution().getCost() + " passos.</p><p>Tempo gasto: " + this.elapsed + " segundos.</p><p>Nós expandidos: " + this.expanded + "</p>";
            //System.out.println("Cost: " + method.getSolution().getCost());
            
            ArrayList auxSteps = new ArrayList();
            steps = new ArrayList();
            
            for (Node node = method.getSolution(); node != null; node = node.getParent())
            {
                auxSteps.add(node);
            }
            
            for (int i = auxSteps.size() - 1; i >= 0; --i)
            {
                steps.add(auxSteps.get(i));
            }
            
            for (int i = 0; i < steps.size(); ++i)
            {
                System.out.println(steps.get(i));
            }
        }
        else
        {
            System.out.println("It wasn't possible solve this puzzle.");
            message = "<h1>Não foi possível resolver este quebra-cabeças. :(</h1>";
            steps = null;
        }
        
    }

    public String getMessage()
    {
        return message;
    }
    
    public String getElapsed()
    {
        return elapsed.toString();
    }
    
    public String getExpanded()
    {
        return expanded.toString();
    }
    
    public ArrayList getSteps()
    {
        return steps;
    }
}
