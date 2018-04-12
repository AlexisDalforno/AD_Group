package edu.miracosta.cs113;

/**
 * ArbitrageOppurtunity.java is the driver of this project. It holds the method
 * of the implemented Dijkstras algorithm as well as all the code necessary
 * to have the user find the best way to make profit through the transfer of 
 * foreign currencies.
 * 
 * @author Alexis Dalforno
 * @version 1.0
 * 
 * ALGORITHM: 
 * 1. Read in the file of foreign currency transaction rates
 * 2. Fill in the lists of edges and vertices with the transaction rate
 *    and the names of the currency respectively
 * 3. Introduce the user to the program and what it does and then ask for the
 *    currency they would like to use to make a profit on
 * 4. Read in user input
 * 5. Switch case that sets the currency name with chosen currency and sets
 *    the vertex named after currency name to a position of 0 for dijkstras 
 *    algorithm
 * 6. Create the graph as well as the pred and dist map for dijkstras algorithm
 * 7. Call the algorithm
 * 8. Relay to the user how to make profit based on shortest path found by dijkstras
 * 	  algorithm
 * 9. Prompt the user to see how much profit could be made with a certain amount of 
 *    money
 * 10. Use the profit returned from dijkstras algorithm to find the profit possible
 *     based on shortest path
 * 11. Exit the program as there is nothing left to do
 */

// IMPORTS
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class ArbitrageOppurtunity 
{
	public static void main(String args[])
	{
		List<Vertex> listOfVertices = new ArrayList<Vertex>();
		List<Edge> listOfEdges = new ArrayList<Edge>();
		List<Double> listOfWeights = new ArrayList<Double>();
		int countRows = 0;
		int countColumns = 0;
		String currencyName = "";
		
		File file = new File("/Users/alexis/git/AD_Group/AD_Group/ExchangeRates");
		Scanner sc = null;
		
		// pulls file to be read
		try 
		{
			sc = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Could not find file, try again.");
		}
		
		// stores all the vertexes which represent the names of the foreign currency
		while(sc.hasNextLine())
		{
			String[] name = sc.nextLine().split("\\s+");
			Vertex vertex = new Vertex(name[0]);
			listOfVertices.add(vertex);
			
			// takes the doubles of the text file
			for(int i = 1; i < name.length; i++)
			{
				listOfWeights.add(Double.parseDouble(name[i]));
			}
		}
		
		sc.close(); // close inputStream
		
		// fills up list of edges
		for(int i = 0; i < listOfVertices.size() * listOfVertices.size(); i++)
		{
			Edge edge = new Edge(listOfVertices.get(countRows), listOfVertices.get(countColumns), listOfWeights.get(i));
			listOfEdges.add(edge);
			
			countColumns++;
			
			if(countColumns == listOfVertices.size())
			{
				countRows++;
				countColumns = 0;
			}
		}
			  
		Scanner keyboard = new Scanner(System.in);
		
		// INTRO
		System.out.println("Welcome to Investment Intelligence, where we help you make the best\ninvestment"
				+ " choices for you!\n\nLet's show you the best and fastest way to make profit through currency exchange!"
				+ "\nWe are going to make you money in only three transactions! One of those transactions\nis back to your "
				+ "original currency, so easy peasy.");
		System.out.println("\nSo, what currency do you use?\n\n1. U.S. Dollars\n2. Euros\n3. Japanese Yen\n4. British Pounds"
				+ "\n5. Swiss Francs\n6. Canadian Dollars\n7. Australian Dollars\n8. Hong Kong Dollars"
				+ "\n\nWe apologize if you don't see your currency above, input 0 to exit. Otherwise, input the number"
				+ "\ncorresponding to the correct currency.");
		int userInput = keyboard.nextInt();

		
		// which currency?
		switch(userInput)
		{
			case 0: System.exit(0);
					break;
			case 1: listOfVertices.get(0).setPositionRef(0);
					currencyName = "USD"; 
					break;
			case 2: listOfVertices.get(1).setPositionRef(0);
					currencyName = "EUR";
					break;
			case 3: listOfVertices.get(2).setPositionRef(0);
					currencyName = "JPY";
					break;
			case 4: listOfVertices.get(3).setPositionRef(0);
					currencyName = "GBP";
					break;
			case 5: listOfVertices.get(4).setPositionRef(0);
					currencyName = "CHF";
					break;
			case 6: listOfVertices.get(5).setPositionRef(0);
					currencyName = "CAD";
					break;
			case 7: listOfVertices.get(6).setPositionRef(0);
					currencyName = "AUD";
					break;
			case 8: listOfVertices.get(7).setPositionRef(0);
					currencyName = "HKD";
					break;
			default: System.out.println("I think you put in an incorrect number. ;)");
            		break;
		}
				
		Graph exchangeRates = new Graph(listOfVertices, listOfEdges);
		Map<Vertex, Vertex> pred = new HashMap<Vertex, Vertex>();
		Map<Vertex, Double> dist = new HashMap<Vertex, Double>();
		
		// runs the main part of the project
		System.out.println("\n\nOur suggestion for the best profit is to convert to: ");
		double profit = dijkstrasAlgorithm(exchangeRates, pred, dist);
		System.out.println("Then back to " + currencyName + "!");
		
		System.out.println("\nWould you like to see what kind of profit you'll make? (1 for yes or 0 to exit)" );
		userInput = keyboard.nextInt();
		
		if(userInput == 0)
		{
			System.exit(0);
		}
		else if(userInput == 1)
		{
			System.out.print("\nEnter the amount of money you "
					+ "plan to start \nwith (numbers only please and at least more than 100): " );
			double userMoney = keyboard.nextDouble();
			
			profit *= userMoney;
			
			System.out.println("\nYou will make: " + profit);
			System.out.printf("Thats %.2f %s of profit!", profit - userMoney, currencyName);
		}
		else
		{
			System.out.println("I'm guessing you want to exit? Good bye!");
			System.exit(0);
		}
		
		keyboard.close();
		
	}
	
	
	/**
	 * This method finds the shortest way to make a profit through foreign currency exchange.
	 * To make the method the most accurate and efficient, the method will only look at three
	 * transactions, the third transaction being the transaction back to original currency.
	 * This method is also specific to the program at hand because instead of setting any empty edges 
	 * (technically there are none), it will set any edge connected to itself as weight 1.0 because
	 * any vertex converted to itself is one dollar. (ex. 5 us dollars is 5 us dollars)
	 * 
	 * @param graph The weighted graph to be searched
	 * @param pred The output array to contain the predecessors in the shortest path
	 * @param dist Output array to contain the distance in the shortest path
	 */
    public static double dijkstrasAlgorithm(Graph graph, Map<Vertex, Vertex> pred, Map<Vertex, Double> dist)
    {
    	int numV = graph.getNumV();
    	Vertex start = Graph.findStart(graph);
    	Vertex originalStart = start;
    	HashSet<Vertex> vMinusS = new HashSet<Vertex>(numV);
    	Vertex largestProfit = start;
    	double profit = 0;
    	double prevProfit = 0;
    	double conversion = 1.0;
    	double currentCurrency = 1.0;
    	int count = 0;
    	
    	// Initialize V-S
    	for(int i = 0; i < numV; i++)
    	{
    		if(graph.getVertices().get(i) != start)
    		{
    			vMinusS.add(graph.getVertices().get(i));
    		}
    	}
    	
    	// Initialize pred and dist
    	for(Vertex v : vMinusS)
    	{
    		pred.put(v, start);
    		
    		if(graph.doesEdgeExist(start, v))
    		{
    			dist.put(v, graph.getWeight(start, v));
    		}
    		else
    		{
    			dist.put(v, 1.0);
    		}
    	}
    	
    	while(count != 2)
    	{
    		// find the conversion rate that will give back the most profit when converted
    		// back to original
    		for(Vertex u : vMinusS)
    		{
    			conversion = currentCurrency;
    			conversion = conversion * dist.get(u) * graph.getWeight(u, originalStart); //convert back to original
    		
    			// checks to see if profit was made
    			if(conversion > prevProfit)
    			{
    				profit = conversion;
    				prevProfit = profit;
    				largestProfit = u;
    			}	
    		}
    
    		// only prints out if second transition made better profit
    		if(start != largestProfit)
    		{
    			System.out.println("----> " + largestProfit);
    		}
    		
    		currentCurrency = graph.getWeight(start, largestProfit);
    		start = largestProfit;
    		vMinusS.remove(largestProfit);
    		
    		if(count != 1)
    		{
    			for(Vertex v : vMinusS)
    		
	        	{
	        		pred.put(v, start);
	        		
	        		if(graph.doesEdgeExist(start, v))
	        		{
	        			dist.put(v, graph.getWeight(start, v));
	        		}
	        		else
	        		{
	        			dist.put(v, 1.0);
	        		}
	        	}
    		}
    		
    		count++;
    	}
    	
    	return profit;
    }
}
