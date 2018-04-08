package ie.gmit.sw.ai;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


//This is the class that will be handling the file that will have encrypted text
public class EncryptedFileReader {
	
	private String fileName;
	
	//Default Constructor
	public EncryptedFileReader() {
		setFileName("EncryptedHobbit.txt");
	}
	//Construtor + String fn
	public EncryptedFileReader(String fileName) {
		this.fileName = fileName;
	}
	
	//Clean up (Removes WhiteSpace and Js from the file)
	
	public String cleanText(String s) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.fileName)));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine()) != null) {
			sb.append(line.toUpperCase().replaceAll("\\W", "").replace("J", ""));
		}
			br.close();
		return sb.toString();
	}
	
	//Reading in the file
	public String readFile(String fileName) throws Throwable {
		InputStream is = new FileInputStream(fileName);
		ByteArrayOutputStream res = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		int i;
		while ((i = is.read(buff)) != -1) {
		    res.write(buff, 0, i);
		}
		
		if(res.toString().length() > 800) {
			System.out.println(res.toString().substring(0, 800));
			return res.toString().substring(0, 800);
			
		}else if(res.toString().length() % 2 != 0) {
			return res.toString() + "X";
		}else return res.toString();
	}

	
	//Changed each String to a char array, if the char is the same as the char before it, replace with a X
	public String removeDupes(String str) {
		char[] cl = str.toCharArray();
		
		for(int i = 0; i < cl.length; i++) {
			if(i != cl.length - 1) 
				cl[i+1] = (cl[i] == cl[i+1]) ? 'X' : cl[i+1];
		}// for 	
		return new String(cl);
	}
	
	
	//Getters and Setters for the Encrypted File Reader
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
