package edu.miracosta.cs113;

/**
 * DijkstrasAlgorithm.java 
 * 
 * @author Alexis Dalforno
 * @version 1.0
 * 
 */

// IMPORTS
import java.util.HashSet;

public class DijkstrasAlgorithm 
{
	private Graph graph;
	private int start;
	private int[] pred;
	double[] dist;
	
	public void dijkstrasAlgorithm()
	{
		int numV = graph.getNumV();
		
		HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
		
		// initialize V-S
		for(int i = 0; i < numV; i++)
		{
			if(i != start)
			{
				vMinusS.add(i);
			}
		}
		
		// initialize pred and dist.
		for(int v : vMinusS)
		{
			pred[v] = start;
			dist[v] = graph.getEdge(start, v).getWeight();  
		}
		
		while(vMinusS.size() != 0)
		{
			// find the value u in V-S with the smallest dist[u]
			double minDist = Double.POSITIVE_INFINITY;
			int u = -1;
			for(int v : vMinusS)
			{
				if(dist[v] < minDist)
				{
					minDist = dist[v];
					u = v;
				}
			}
			
			vMinusS.remove(u);
			
			for(int v : vMinusS)
			{
				if(graph.isEdge(u, v))
				{
					double weight = graph.getEdge(u, v).getWeight();
					
					if(dist[u] + weight < dist[v])
					{
						dist[v] = dist[u] + weight;
						pred[v] = u;
					}
				}
			}
		}
	}
}
