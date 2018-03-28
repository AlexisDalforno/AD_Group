package edu.miracosta.cs113;

/**
 * Graph.java simple builder class that puts the vertex and edge class to use by creating the graph.
 * 
 * @author Alexis Dalforno
 * @version 1.0
 * 
 */

// IMPORTS
import java.util.List;

public class Graph 
{
	// INSTANCE VARIABLES
	private List<Vertex>[] vertexes;
	private List<Edge>[] edges;

	// FULL CONSTRUCTOR
    public Graph(List<Vertex> vertexes, List<Edge> edges) 
    {
        setVertexes(vertexes);
        setEdges(edges);
    }

    // GETTERS
    public List<Vertex>[] getVertexes() 
    {
        return vertexes;
    }

    public List<Edge>[] getEdges() 
    {
        return edges;
    }
    
    /**
     * Get the edge between two vertices. If an edge doesn't exist, an 
     * edge with weight of Double.POSITIVE_INFINITY is returned.
     * 
     * @param source the source
     * @param dest the destination
     * @return the edge between these two vertices
     */
    public Edge getEdge(int source, int dest)
    {
    	Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
    	for(Edge edge : edges[source])
    	{
    		if(edge.equals(target))
    		{
    			return edge;
    		}
    	}
    	
    	return target;
    }
    
    // SETTERS
    public void setVertexes(List<Vertex>[] vertexes) 
    {
		this.vertexes = vertexes;
	}

	public void setEdges(List<Edge>[] edges) 
	{
		this.edges = edges;
	}
	
	// ACCESSOR METHODS
	/**
	 * Return the number of vertices.
	 * 
	 * @return number of vertices
	 */
	public int getNumV()
	{
		return vertexes.length;
	}
	
	/**
	 * Inserts a new edge into the graph.
	 * 
	 * @param edge the new edge to insert
	 */
	public void insert(Edge edge)
	{
		edges[edge.getSource()].add(edge);
	}
	
	/**
	 * Determine whether an edge exists.
	 * 
	 * @param source the source vertex
	 * @param dest the destination vertex
	 * @return true if there is an edge from source to dest
	 */
	public boolean isEdge(int source, int dest)
	{
		return edges[source].contains(new Edge(source, dest));
	}
}
