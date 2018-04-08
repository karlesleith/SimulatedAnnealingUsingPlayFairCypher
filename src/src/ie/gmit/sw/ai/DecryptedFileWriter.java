package ie.gmit.sw.ai;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

//This class is for writing the decrypted text to a Text File after it has been decrypted
public class DecryptedFileWriter {
	
	//FileName we are writing to
	private String fn = "DecryptedMessage.txt"; 
	
	//Writing Decrypted Text to File
	public void WriteToFile(String dt) throws IOException {
		FileOutputStream fs = new FileOutputStream(fn);
		byte[] bytes = dt.getBytes();
		for(byte b : bytes) {
			fs.write(bytes);
		}
		fs.close();
		
		}
	}

