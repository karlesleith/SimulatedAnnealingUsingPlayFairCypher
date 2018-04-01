package ie.gmit.sw.ai;

import java.awt.Point;
import java.util.Scanner;
 
public class PlayFair {
    private static char[][] charTable;
    private static Point[] positions;

 //Promting the User to do stuff 
    public static String prompt(String promptText, String kw, int minLen) {
        String s;
        do {
            System.out.print(promptText);
            s = kw.trim();
        } while (s.length() < minLen);
        return s;
    }
 
    //Currently both do the same
    public static String prepareText(String s, boolean changeJtoI) {
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        return changeJtoI ? s.replace("J", "I") : s.replace("J", "I");
    }
 
    public static void createTable(String key, boolean changeJtoI) {
        charTable = new char[5][5];
        positions = new Point[26];
        
        System.out.println("KEYWORD = "+ key+ "\n");
 
        String s = prepareText(key + "ABCDEFGHIJKLMNOPQRSTUVWXYZ", changeJtoI);
 
        int len = s.length();
        for (int i = 0, k = 0; i < len; i++) {
            char c = s.charAt(i);
            if (positions[c - 'A'] == null) {
                charTable[k / 5][k % 5] = c;
                positions[c - 'A'] = new Point(k % 5, k / 5);
                k++;
            }
        }
        printTable(charTable);
    }
    
    //Printing the Array Table
    private static void printTable(char a[][]) {
    	for (int row = 0; row < a.length; row ++) {// Star of Row for Loop
    		
    		for(int col =0; col <a[row].length;col++) {
    			System.out.print(a[row][col] + " ");
    			
    		}
    		System.out.println();
    	}// end of Row For loop
    	
    }
 
    public static String encode(String s) {
        StringBuilder sb = new StringBuilder(s);
 
        for (int i = 0; i < sb.length(); i += 2) {
 
            if (i == sb.length() - 1)
                sb.append(sb.length() % 2 == 1 ? 'X' : "");
 
            else if (sb.charAt(i) == sb.charAt(i + 1))
                sb.insert(i + 1, 'X');
        }
        return codec(sb, 1);
    }
 
    public static String decode(String s) {
        return codec(new StringBuilder(s), 4);
    }
 
    public static String codec(StringBuilder text, int direction) {
        int len = text.length();
        for (int i = 0; i < len; i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
 
            int row1 = positions[a - 'A'].y;
            int row2 = positions[b - 'A'].y;
            int col1 = positions[a - 'A'].x;
            int col2 = positions[b - 'A'].x;
 
            if (row1 == row2) {
                col1 = (col1 + direction) % 5;
                col2 = (col2 + direction) % 5;
 
            } else if (col1 == col2) {
                row1 = (row1 + direction) % 5;
                row2 = (row2 + direction) % 5;
 
            } else {
                int tmp = col1;
                col1 = col2;
                col2 = tmp;
            }
 
            text.setCharAt(i, charTable[row1][col1]);
            text.setCharAt(i + 1, charTable[row2][col2]);
        }
        return text.toString();
    }
}