package ie.gmit.sw.ai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Key {

	
	public String KeyGen() {
		String a  = "abcdefghiklmnopqrstuvwxyz";
		
		String key = shuffle(a);
		
		return key;
	}
	//Fisher - Yates Shuffle
	public String shuffle(String alpha) {
		
		char[] alphabet = alpha.toCharArray();
		String key = "";
	    int n = alphabet.length;
	    
	    System.out.println("\n(Debug Key.shuffle()) Print a random Key from the alphabet");
	    
	    for (int i = 0; i < alphabet.length; i++) {
	        // Get a random index of the array past i.
	        int random = i + (int) (Math.random() * (n - i));
	        // Swap the random element with the present element.
	        char randomElement = alphabet[random];
	        alphabet[random] = alphabet[i];
	        alphabet[i] = randomElement;
	       
	        key += alphabet[i];
	       //System.out.println(key);
	    }
	  
	    return key;
	}
	
}
