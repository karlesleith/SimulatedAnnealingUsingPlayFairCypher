package ie.gmit.sw.ai;


//This class determins the position of each element on the array
public class Position {

	private int x;
	private int y;

	
	//Senting the Default
	public Position () {}
	
	//Setting Postions
	private Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Position getPosition(char x, char[][] cypherMatrix) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (x == cypherMatrix[i][j]) {
					return new Position(i, j);
				}
			}
		}
		return null;
	}
	
	public int getPosX() {
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}
	
}
