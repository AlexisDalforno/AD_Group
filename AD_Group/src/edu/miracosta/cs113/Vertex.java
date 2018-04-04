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
    private int positionReference;
    
    // FULL CONSTRUCTOR
    public Vertex(String name, int pr) 
    {
        setName(name);
        setPositionRef(pr);
    }

	// GETTERS
    public String getName() 
    {
        return name;
    }
    
    public int getPositionRef()
    {
    	return positionReference;
    }
 
    // SETTERS
	public void setName(String name) 
	{
		this.name = name;
	}
	
    private void setPositionRef(int pr) 
    {
		this.positionReference = pr;
		
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
        
        return (this.name != otherVertex.name || this.positionReference != otherVertex.positionReference);
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
