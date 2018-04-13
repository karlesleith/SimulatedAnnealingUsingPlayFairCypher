package ie.gmit.sw.ai;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;


/*This is the class that handles the Simulated Annealing (SA) which is a probabilistic technique for approximating the global optimum of a given function. 
Specifically, it is a metaheuristic to approximate global optimization in a large search space. It is often used when the search space is discrete 
For problems where finding an approximate global optimum is more important than finding a precise local optimum in a fixed amount of time */


public class SimulatedAnnealing {

	//This classes Varibles
	private PlayFair pf;
	private Grams grams;
	private KeyShuffler ks;
	private EncryptedFileReader efr;
	
	private String bestKey;
	private String bestText;
	private String results;
	private int temperature;
	
	private HashMap<String, Integer> map;
	
	private String decryptedMessage;
	
	//SA Constructor
	public SimulatedAnnealing(int temp, String cypherText) {
		this.temperature = temp;
		//Setting a baseline from the Alphabet
		grams = new Grams();
		try {
			grams.fourGrams();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //Takes in the Four Grams and Assigns them to a HashMap
		pf = new PlayFair(cypherText);
		
		map = new HashMap<String, Integer>();		
		ks = new KeyShuffler();
		efr = new EncryptedFileReader();
		
	}
	
	//CypherBreaker
	//Most important part!
	public void SimulatedAnnealingCypherBreaker(String cypherText) throws Throwable {
		
		//Defs
		map = grams.getMap();
		String parent = ks.getParentKey();						// gets the parent key
		String decryptedText = pf.decypher(parent);				// try to decypher with the parent
		double parentScore = grams.score(decryptedText);		// score the key
		double bestScore = parentScore;							// set the default score to beat
		System.out.println("Initial score: "+bestScore + " for key: "+ parent);
		

		//Simulated Annealing 
		for(int temp = this.temperature; temp > 0; temp--) {
			for (int index = 50000; index > 0; index--) {
				String child = ks.shuffle(parent);				//shuffle the parent key
				decryptedText = pf.decypher(child);				// try the child
				double childScore = grams.score(decryptedText);	// score the fitness
				double delta = childScore - parentScore;		// get the delta 	
				//System.out.println(delta);
				if(delta > 0) {									// if its better that 0, set it as the new parent
					parent = child;
					parentScore = childScore;
				} else  {					
					if((Math.pow(Math.E, (delta/temp))) > new SecureRandom().nextDouble()) { // prevents the local Maximum
						parent = child;
						parentScore = childScore;
					}
				}
			
				if(parentScore > bestScore) {
					bestScore = parentScore;
					String bestKey = parent;
					String bestText = decryptedText;
					this.results = String.format("\nTran: %d at Temp: %d\nBest Score: %.2f\tKey: %s\nDecrypted message: %s\n", index, temp, bestScore, bestKey, bestText);
					System.out.println(results);
					
				}//if p > b	
			}//transitions
			System.out.println(temp);
			
		}//tempurature
		//End Results
		System.out.printf(results);
		new DecryptedFileWriter().WriteToFile(results);
	}


// Getters and Setters for Private Variables
	
	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getBestText() {
		return bestText;
	}

	public void setBestText(String bestText) {
		this.bestText = bestText;
	}
	
}
