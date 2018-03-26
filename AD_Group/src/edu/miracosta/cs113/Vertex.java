package edu.miracosta.cs113;

/**
 * Vertex.java is one of the essential components to a graph. Gives an ID and Name to 
 * each point in the graph.adfas
 * 
 * @author Alexis Dalforno
 * @version 1.0
 * 
 */

public class Vertex 
{
	// INSTANCE VARIABLES
	private String id;
    private String name;
    
    // FULL CONSTRUCTOR
    public Vertex(String id, String name) 
    {
        setId(id);
        setName(name);
    }
    
    // GETTERS
    public String getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }
 
    // SETTERS
    public void setId(String id) 
    {
		this.id = id;
	}

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
        int result = 0;
        
        if(id != null)
        {
        	result = 31 + id.hashCode();
        }
        
        return result;
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
        
        return (this.id != otherVertex.id || this.name != otherVertex.name);
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
