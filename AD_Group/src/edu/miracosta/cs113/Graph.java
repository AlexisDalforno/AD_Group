package edu.miracosta.cs113;

/**
 * Graph.java is a builder class that puts the vertex and edge class to use by bringing all the 
 * vertices and edges into a transversable graph.
 * 
 * @author Alexis Dalforno
 * @version 1.0
 * 
 */

// IMPORTS
import java.util.List;
import java.util.Map;
import java.util.HashMap;
// IMPORTS

public class Graph 
{
	// INSTANCE VARIABLES
	private Map<Vertex, Map<Vertex, Edge>> graph; // the cheaters way of making a multi-key Map object :)
	private List<Vertex> vertices;
	private List<Edge> edges;
	private int numV;

	// FULL CONSTRUCTOR
	public Graph(List<Vertex> vertices, List<Edge> edges)
	{		
		int index1 = 0;
		int index2 = 0;
		
		// sets the lists of vertices and edges
		this.vertices = vertices;
		this.edges = edges;
		
		// gets the number of vertices in the graph
		this.numV = this.vertices.size();
		
		this.graph = new HashMap<Vertex, Map<Vertex, Edge>>();
		
		// sets all the vertices
		for(int i = 0; i < numV; i++)
		{
			this.graph.put(this.vertices.get(i), new HashMap<Vertex, Edge>());
		}
		
		// sets all the possible edges to be made between the vertices
		for(int i = 0; i < numV * numV; i++)
		{
			this.graph.get(this.vertices.get(index1)).put(this.vertices.get(index2), null);
			
			index2++;
			
			if(index2 == numV)
			{
				index2 = 0;
				index1++;
			}
		}
		
		index1 = 0;
		index2 = 0;
		
		// fills in the existing edges or leaves it as null if edge does not exist
		for(int i = 0; i < numV * numV; i++)
		{
			Vertex vertex1 = this.vertices.get(index1);
			Vertex vertex2 = this.vertices.get(index2);
			
			if(index1 != index2)
			{	
				Edge edge = findEdge(this.edges, vertex1, vertex2);

				this.graph.get(vertex1).replace(vertex2, edge);
			}
			
			index2++;
			
			if(index2 == numV)
			{
				index2 = 0;
				index1++;
			}
		}
	}

	// GETTERS & SETTERS
	public List<Vertex> getVertices() 
	{
		return vertices;
	}

	public void setVertices(List<Vertex> vertices) 
	{
		this.vertices = vertices;
	}

	public List<Edge> getEdges() 
	{
		return edges;
	}

	public void setEdges(List<Edge> edges) 
	{
		this.edges = edges;
	}

	public Map<Vertex, Map<Vertex, Edge>> getGraph() 
	{
		return graph;
	}
	
	// TO_STRING METHOD
	public String toString()
	{
		String edges;
		int index1 = 0;
		int index2 = 0;
		
		edges = String.format("# of Vertices: %d\n# of Edges: %d", getNumV(), getNumE());
		
		for(int i = 0; i < numV * numV; i++)
		{
			Vertex vertex1 = this.vertices.get(index1);
			Vertex vertex2 = this.vertices.get(index2);
			
			if(graph.get(vertex1).get(vertex2) != null)
			{

				edges += "\n" + graph.get(vertex1).get(vertex2);
				
			}
			
			index2++;
			
			if(index2 == numV)
			{
				index2 = 0;
				index1++;
			}
		}
		
		return edges;
	}

	// ACCESSOR METHODS
	/**
	 * Return the number of vertices.
	 * 
	 * @return number of vertices
	 */
	public int getNumV()
	{
		return this.numV;
	}
	
	/**
	 * Return the number of edges.
	 * 
	 * @return number of edges
	 */
	public int getNumE()
	{
		return edges.size();
	}
	
	/**
	 * Determine whether an edge exists.
	 * 
	 * @param source the source vertex
	 * @param destination the destination vertex
	 * @return true if there is an edge from source to destination
	 */
	public boolean doesEdgeExist(Vertex source, Vertex destination)
	{
		if(graph.containsKey(source) && graph.containsKey(destination))
		{
			if(graph.get(source).get(destination) != null)
			{
				return true;
			}
		}
	
		return false;
	}
	
	/**
	 * Gets weight of specified Edge.
	 * 
	 * @param source the source vertex
	 * @param destination the destination vertex
	 * @return weight of edge or -1 if edge does not exist
	 */
	public double getWeight(Vertex source, Vertex destination)
	{
		 if(doesEdgeExist(source, destination))
		 {
			 return graph.get(source).get(destination).getWeight();
		 }
		 
		 return -1;
	}
	
	/**
	 * Helper method to find a specific edge in a list of edges. If the edge exists, it returns the
	 * edge, otherwise returns null.
	 * 
	 * @param listOfEdges the list to be searched through
	 * @param source the source vertex
	 * @param destination the destination vertex
	 * @return the edge or null if edge does not exist
	 */
    public static Edge findEdge(List<Edge> listOfEdges, Vertex source, Vertex destination)
    {
    	for(int i = 0; i < listOfEdges.size(); i++)
    	{
    		Edge edge = listOfEdges.get(i);
    		if(edge.getSource() == source && edge.getDestination() == destination)
    		{
    			return edge;
    		}
    	}
    	
    	return null;
    }
}
