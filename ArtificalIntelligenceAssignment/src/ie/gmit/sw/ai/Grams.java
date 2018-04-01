package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Grams {

	//Puting the 4Grams into a HashMap from the TxtFile 
	public void fourGrams() throws IOException {
	    String filePath = "4grams.txt";
	    HashMap<String, Integer> map = new HashMap<String, Integer>();

	    String line;
	    BufferedReader reader = new BufferedReader(new FileReader(filePath));
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
	        } else {
	          System.out.println("ignoring line: " + line);
	        }
	    }

	  /*  for (String key : map.keySet())
	    {
	        System.out.println(key + " : " + map.get(key));
	    }*/
	    
	    
	    reader.close();
	}
	}
	

