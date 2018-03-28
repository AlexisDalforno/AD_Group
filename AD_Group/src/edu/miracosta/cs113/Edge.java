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

    private int source;
    private int destination;
    private double weight;

    // DEFAULT WEIGHT CONSTRUCTOR
    public Edge(int source, int destination) 
    {
        setSource(source);
        setDestination(destination);
        setWeight(1.0);
    }
    // FULL CONSTRUCTOR
    public Edge(int source, int destination, double weight) 
    {
        setSource(source);
        setDestination(destination);
        setWeight(weight);
    }

    // GETTERS
	public int getDestination() 
	{
        return destination;
    }

    public int getSource() 
    {
        return source;
    }
    public double getWeight() 
    {
        return weight;
    }
    
    // SETTERS
	public void setSource(int source) 
	{
		this.source = source;
	}

	public void setDestination(int destination) 
	{
		this.destination = destination;
	}

	public void setWeight(double weight) 
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
