package edu.miracosta.cs113;

/**
 * Vertex.java is one of the essential components to a graph. Gives an ID and Name to 
 * each point in the graph.
 * 
 * @author Alexis Dalforno
 * @version 1.0
 * 
 */

public class Vertex 
{
	// INSTANCE VARIABLES
    private String name;
    
    // FULL CONSTRUCTOR
    public Vertex(String name) 
    {
        setName(name);
    }
    
    // GETTERS
    public String getName() 
    {
        return name;
    }
 
    // SETTERS
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Creates bucket number for storing elements.
	 * 
	 * @return bucket number
	 */
	public int hashCode() 
    {
		return this.name.hashCode();
    }

	/**
	 * Compares two different Vertex objects by looking at their variables.
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
    	
        Vertex otherVertex = (Vertex) obj;
        
        return (this.name != otherVertex.name);
    }

	/**
	 * Prints out the variables in a formatted manner.
	 * 
	 * @return the formatted string
	 */
    public String toString() 
    {
        return name;
    }

	
}
