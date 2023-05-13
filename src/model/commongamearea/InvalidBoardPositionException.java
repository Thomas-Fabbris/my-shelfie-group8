package model.commongamearea;

public class InvalidBoardPositionException extends RuntimeException{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7170372016189930018L;

	public InvalidBoardPositionException(int row, int column) {
		super("Row " + row + " column " + column + " is not a valid position on the board!");
	}
}
