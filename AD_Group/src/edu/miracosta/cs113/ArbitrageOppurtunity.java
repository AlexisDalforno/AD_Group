package edu.miracosta.cs113;

import java.util.HashSet;
import java.util.Map;

public class ArbitrageOppurtunity 
{
	
	
	/**
	 * This method finds the shortest way to make a profit through foreign currency exchange.
	 * To make the method the most accurate and efficient, the method will only look at three
	 * transactions, the third transaction being the transaction back to original currency.
	 * This method is also specific to the program at hand because instead of setting any empty edges 
	 * (technically there are none), it will set any edge connected to itself as weight 1.0 because
	 * any vertex converted to itself is one dollar. (ex. 5 us dollars is 5 us dollars)
	 * 
	 * @param graph The weighted graph to be searched
	 * @param pred The output array to contain the predecessors in the shortest path
	 * @param dist Output array to contain the distance in the shortest path
	 */
    public static void dijkstrasAlgorithm(Graph graph, Map<Vertex, Vertex> pred, Map<Vertex, Double> dist)
    {
    	int numV = graph.getNumV();
    	Vertex start = Graph.findStart(graph);
    	HashSet<Vertex> vMinusS = new HashSet<Vertex>(numV);
    	Vertex largestProfit = start;
    	double profit = 0;
    	double prevProfit = 0;
    	int count = 0;
    	
    	// Initialize V-S
    	for(int i = 0; i < numV; i++)
    	{
    		if(graph.getVertices().get(i) != start)
    		{
    			vMinusS.add(graph.getVertices().get(i));
    		}
    	}
    	
    	// Initialize pred and dist
    	for(Vertex v : vMinusS)
    	{
    		pred.put(v, start);
    		
    		if(graph.doesEdgeExist(start, v))
    		{
    			dist.put(v, graph.getWeight(start, v));
    		}
    		else
    		{
    			dist.put(v, 1.0);
    		}
    	}
    	
    	while(!vMinusS.isEmpty() || count == 2)
    	{
    		// find the conversion rate that will give back the most profit when converted
    		// back to original
    		for(Vertex u : vMinusS)
    		{
    			double conversion1 = 1.0 * dist.get(u); // convert to other currency
    			double conversion2 = conversion1 * graph.getWeight(u, start); //convert back to original
    			
    			// checks to see if profit was made
    			if(conversion2 > 1.0)
    			{
    				profit = conversion2;
    			}	
    			
    			// keeps a check going for largest profit
    			if(profit > prevProfit)
    			{
    				prevProfit = profit;
    				largestProfit = u;
    			}
    		}
    	}
    }
}
