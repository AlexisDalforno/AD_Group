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
	private List<Vertex> vertexes;
	private List<Edge> edges;

	// FULL CONSTRUCTOR
    public Graph(List<Vertex> vertexes, List<Edge> edges) 
    {
        setVertexes(vertexes);
        setEdges(edges);
    }

    // GETTERS
    public List<Vertex> getVertexes() 
    {
        return vertexes;
    }

    public List<Edge> getEdges() 
    {
        return edges;
    }
    
    // SETTERS
    public void setVertexes(List<Vertex> vertexes) 
    {
		this.vertexes = vertexes;
	}

	public void setEdges(List<Edge> edges) 
	{
		this.edges = edges;
	}
}
