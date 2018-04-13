package ie.gmit.sw.ai;

//This class does the shuffling of the cypherKey

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//This is the class that shuffles the key
public class KeyShuffler {
	
	private String parentKey;
	private String childKey = "hi";
	private char[][] cypherMatrix;
	
	//The alphabet won't chnage anytime soon, Removed J as it will not be used
	private static final String Alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
	
	public void setCypherMatrix(String key) {
		char[][] temp = new char[5][5];
		int pos = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = key.charAt(pos);
				pos++;
			}
			
		}
		this.cypherMatrix = temp;
	}

	//Getting the Parent Key, Also Sets for simplicity
	public String getParentKey() {
		
		setParentKey();
		return parentKey;
	}
	
	//Randomize a Parent Key and set it
	public void setParentKey() {
		String temp = shuffle(Alphabet);
		this.parentKey = String.valueOf(temp);
		this.setCypherMatrix(this.parentKey);

	}

	//Getting child key
	public String getChildKey() {
		return childKey;
	}
//Setting Child Key
	public void setChildKey(String childKey) {
		this.childKey = childKey;
	}

	//Getting the cypher Matrix
	public char[][] getCypherMatrix() {
		return cypherMatrix;
	}
	//Initial Random Key
	public String shuffle(String k) {
		char key[] = k.toCharArray();
		String KeyBackToString;
		 
		int index;
		 Random random = ThreadLocalRandom.current();
		 for (int i = key.length - 1; i > 0; i--) {
			 index = random.nextInt(i + 1);
			 if (index != i) {
			 key[index] ^= key[i];
			 key[i] ^= key[index];
			 key[index] ^= key[i];
		 }
	 }
		//Sending the Chars back to String 
		KeyBackToString = String.valueOf(key);
		//System.out.println(KeyBackToString.length());
		return KeyBackToString;
	}
	
	public char[] shufflekey(String k) {
		
		int i = (int)(Math.random() * (100));
		System.out.println(i);
			
		switch (i) {
		
		//2% of the time we want to swap 2 random rows;
		case 91:
		case 92:
			swapTwoRandomRows();
			break;
		case 93:
		case 94:
			//2% of the time we want to swap 2 random collumns;
			swapTwoRandomCollumns();
			break;
		case 95: 
		case 96:
			//2% of the time we want to flip all rows;
			flipAllRows();
			break;
		case 97:
		case 98: 
			//2% of the time we want to flip all collumns;
			flipAllCollumns();
			break;
		case 99:
		case 100:
			//2% of the time we want to reverse the key;
			reverseKey();
			break;
		default:
			//90 % of the time we want to just swap 2 random characters
			swapTwoRandomChars();
			break;
		}
		return null;
	}
	
	//TO DO: The Different Way to Swap Keys
	private void swapTwoRandomChars() {

		//First we get 4 random numbers(For our 2 co-ordinates )for our 5 x 5 table;
		int row1 ,  row2, col1,   col2;
		do{
			row1 = (int)(Math.random()*5);
			row2 = (int)(Math.random()*5);
			col1 = (int)(Math.random()*5);
			col2 = (int)(Math.random()*5);
			
		}while ((row1 == row2) && (col1 == col2)); 
		
		//Then we flip the 2 chars
		char temp = cypherMatrix[row1][col1];
		cypherMatrix[row1][col1] = cypherMatrix[row2][col2];
		cypherMatrix[row2][col2] = temp;
		
	}
	
	//Swapping 2 random rows
	public void swapTwoRandomRows() {
		int row1, row2;
		
		do {
		row1 = (int)(Math.random() * (5));
		row2 = (int)(Math.random() * (5));
		}while(row1 == row2);
		//System.out.println("Row: "+ row1+ " Row2: "+ row2);
		
		char[] temp = cypherMatrix[row1];
		cypherMatrix[row1] = cypherMatrix[row2];
		cypherMatrix[row2] = temp;
	}
	//Swaping 2 random collumns
	private void swapTwoRandomCollumns() {
		int col1, col2;
		
		do {
			col1 = (int)(Math.random() * (5));
			col2 = (int)(Math.random() * (5));
		}while(col1 == col2);
		
		for (int i = 0; i < 5; i++) {
			char temp = cypherMatrix[i][col1];
			cypherMatrix[i][col1] = cypherMatrix[i][col2];
			cypherMatrix[i][col2] = temp;
		}		
	}
	
	//flipping the rows
	private void flipAllRows() {
		
		//Outter for loop for rows inner for collums
		for (int i = 0; i < 5; i++) {
			char[] temp = cypherMatrix[i];
			
			for(int j = 0; j < temp.length / 2; j++) {
			    char temp2 = temp[j];
			    temp[j] = temp[temp.length - j - 1];
			    temp[temp.length - j - 1] = temp2;
			}
		
			cypherMatrix[i] = temp;			
		}
	}
	//Flipping the collums
	private void flipAllCollumns() {
		//Outter for loop for rows inner for collums
		for (int i = 0; i < 5/2; i++) {
			for (int j = 0; j < 5; j++) {
				char temp = cypherMatrix[i][j];
				cypherMatrix[i][j] = cypherMatrix[5 - i - 1][j];
				cypherMatrix[5 - i - 1][j] = temp;
			}
		}
	}
	
	//reversing the child key
	public void reverseKey() {
		String temp = getChildKey();
		temp =   new StringBuilder(temp).reverse().toString();
		this.childKey = temp;
		//System.out.println(temp);
	}
	
	
}