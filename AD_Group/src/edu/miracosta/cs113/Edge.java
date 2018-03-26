package edu.miracosta.cs113;

/**
 * Edge.java is one of the essential components to a graph. Creates an edge between vertices.
 * 
 * @author Alexis Dalforno
 * @version 1.0
 * 
 */

public class Edge 
{
    private String id;
    private Vertex source;
    private Vertex destination;
    private int weight;

    // FULL CONSTRUCTOR
    public Edge(String id, Vertex source, Vertex destination, int weight) 
    {
        setId(id);
        setSource(source);
        setDestination(destination);
        setWeight(weight);
    }
    
    // GETTERS
    public String getId() 
    {
        return id;
    }

	public Vertex getDestination() 
	{
        return destination;
    }

    public Vertex getSource() 
    {
        return source;
    }
    public int getWeight() 
    {
        return weight;
    }
    
    // SETTERS
    public void setId(String id) 
    {
		this.id = id;
	}

	public void setSource(Vertex source) 
	{
		this.source = source;
	}

	public void setDestination(Vertex destination) 
	{
		this.destination = destination;
	}

	public void setWeight(int weight) 
	{
		this.weight = weight;
	}

	/**
	 * Prints out the variables in a formatted manner.
	 * 
	 * @return the formatted string
	 */
    public String toString() 
    {
        return source + " to " + destination + " has a weight of " + weight + ".";
    }
}
