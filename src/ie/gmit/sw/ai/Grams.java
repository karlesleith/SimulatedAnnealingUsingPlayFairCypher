package ie.gmit.sw.ai;

//Reading in the 4Grams.txt, need to be put in the root dir of the project

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


//This is the file that handles the 4Grams/Kmers
public class Grams {
	
	//Varibles for the 4Grams txt
	private  HashMap<String, Integer> map;
	private long fGramCount;
	
	//link to the TextFile
	private String fn = "4grams.txt";

	//Puting the 4Grams into a HashMap from the TxtFile 
	public void fourGrams() throws IOException {
	   
	    map = new HashMap<String, Integer>();
	    long temp = 0;
	    


	    String line;
	    //Search the FourGrams in the Root Directory of the project (For the Jar!)
	    BufferedReader reader = new BufferedReader(new FileReader(fn));
	    while ((line = reader.readLine()) != null)
	    {
	        String[] parts = line.split(" ", 2);
	        if (parts.length >= 2)
	        {
	            String key = parts[0];
	            String value = parts[1];
	            
	            //Parse to an int
	            int parseValue = Integer.parseInt(value);
	            map.put(key, parseValue);
	            
	            temp += parseValue;
	        } else {
	          System.out.println("ignoring line: " + line);
	        }
	    }
	    //Save the Tempeture
	    setfGramCount(temp);

	   //Testing Printing out the map
	  /*  for (String key : map.keySet())
	    {
	        System.out.println(key + " : " + map.get(key));
	    }*/
	    
	    reader.close();
	}
	
	
	public double score(String text) {
		double score = 0;

		int range = (text.length() > 800) ? 742 - 4 : text.length() - 4;

		for (int i = 0; i < range; i++) {
			score += Math.log10((double) (((map.get(text.substring(i, i + 4)) != null)
					? map.get(text.substring(i, i + 4))
					: 1)) / this.fGramCount);
		}
		return score;
	}
	
	
//Getting the Map
	public HashMap<String, Integer> getMap() {
		return map;
	}

//Setting the Map
	public void setMap(HashMap<String, Integer> map) {
		this.map = map;
	}

//Getting the Filename
	public String getFn() {
		return fn;
	}

//Setting the Filename
	public void setFn(String fn) {
		this.fn = fn;
	}

//Count the fourgrams
	public long getfGramCount() {
		return fGramCount;
	}
	
//Setting the fourgrams
	public void setfGramCount(long fGramCount) {
		this.fGramCount = fGramCount;
	}
	
	
	
	}
	

