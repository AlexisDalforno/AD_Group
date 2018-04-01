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
    private Vertex source;
    private Vertex destination;
    private double weight;

    // DEFAULT WEIGHT CONSTRUCTOR
    public Edge(Vertex source, Vertex destination) 
    {
        setSource(source);
        setDestination(destination);
        setWeight(1.0);
    }
    
    // FULL CONSTRUCTOR
    public Edge(Vertex source, Vertex destination, double weight) 
    {
        setSource(source);
        setDestination(destination);
        setWeight(weight);
    }

    // GETTERS
	public Vertex getDestination() 
	{
        return destination;
    }

    public Vertex getSource() 
    {
        return source;
    }
    public double getWeight() 
    {
        return weight;
    }
    
    // SETTERS
	public void setSource(Vertex source) 
	{
		this.source = source;
	}

	public void setDestination(Vertex destination) 
	{
		this.destination = destination;
	}

	public void setWeight(double weight) 
	{
		this.weight = weight;
	}
	
	/**
	 * Creates bucket number for storing elements.
	 * 
	 * @return bucket number
	 */
	public int hashCode() 
    {
		return (this.source.hashCode() + this.destination.hashCode());
    }
	
	/**
	 * Compares two different Edge objects by looking at their variables.
	 * 
	 * @param obj: other object to be compared
	 * @return a boolean based on whether its the same
	 */
	public boolean equals(Object obj) 
    {
    	if (obj == null || this.getClass() != obj.getClass()) 
		{
			return false;
		}
    	
        Edge otherEdge = (Edge) obj;
        
        return (this.source != otherEdge.source || this.destination != otherEdge.destination 
        		|| this.weight != otherEdge.weight);
    }

	/**
	 * Prints out the variables in a formatted manner.
	 * 
	 * @return the formatted string
	 */
    public String toString() 
    {
        return source + " to " + destination + " has a weight of " + weight;
    }
   
}
