package ie.gmit.sw.ai;

import java.io.IOException;
import java.util.Scanner;

public class CipherBreaker {

	
	//Runner class
	//This is the main that will be used to run the runnable jar
    public static void main(String[] args) throws Throwable {
    	
    
    	Scanner x = new Scanner(System.in);
    			
    	System.out.println("**** PlayFair Cypher Breaker ****");
    
    	String fileName = "";
    	int temp = 25;
    	//Menu
		System.out.printf("Enter The Text File to Decrypt! (Include File Extensions): ");
		fileName = x.nextLine();
		System.out.printf("Enter Temp: ");
		temp = x.nextInt();
		String text = new EncryptedFileReader().readFile(fileName);
		System.out.println("FILE:\n" + text);		
	
		//Count the time
		long startime = System.currentTimeMillis();
		SimulatedAnnealing sa = new SimulatedAnnealing(temp, text);
		sa.SimulatedAnnealingCypherBreaker(text);
		
        //Time
        long endTime = System.currentTimeMillis() - startime;
        
        System.out.println("\nTIME: "+ endTime+"ms");
        
       
      
      
        
    }
}



