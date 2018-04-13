package ie.gmit.sw.ai;

 
public class PlayFair {
	
	private String cypherKey;

	public PlayFair(String cypherKey) {
		this.cypherKey = cypherKey;
	}
	
	//We send the key in and use it against the codec table
	public String decypher(String dk) throws Exception {		
		char[][] cypherMatrix = populateMatrix(dk);
		return codec(cypherMatrix, 0, new StringBuilder());
	}
			
	//Assigns the 
	private String codec(char[][] matrix, int index, StringBuilder sb) {
		
		int distance  = 4 ;
		
		if(index < this.cypherKey.length() / 2) {
			char a = this.cypherKey.charAt(2 * index);
			char b = this.cypherKey.charAt(2 * index + 1);
			int row1 = (int) Position.getPosition(a, matrix).getPosX();
			int col1 = (int) Position.getPosition(a, matrix).getPosY();
			int row2 = (int) Position.getPosition(b, matrix).getPosX();
			int col2 = (int) Position.getPosition(b, matrix).getPosY();

			if (row1 == row2) {
				col1 = (col1 + distance) % 5; 
				col2 = (col2 + distance) % 5;
			} else if (col1 == col2) {
				row1 = (row1 + distance) % 5;
				row2 = (row2 + distance) % 5;
			} else {
		        int temp = col1;
		        col1 = col2;
		        col2 = temp;
		    }
			sb.append(matrix[row1][col1] +""+ matrix[row2][col2]);
			
			return codec(matrix, 1 + index, sb);
		}else return sb.toString();
	}// codec
	

	// Populates the cypher table
	public char[][] populateMatrix(String key){
		char[][] cypherMatrix = new char[5][5];
		int index = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cypherMatrix[i][j] = key.charAt(index);
				index++;
			}
		}
		return cypherMatrix;
	}
	
	//Getters and Setters for the cypher key
	public String getCypherKey() {
		return cypherKey;
	}

	public void setCypherKey(String cypherKey) {
		this.cypherKey = cypherKey;
	}
}