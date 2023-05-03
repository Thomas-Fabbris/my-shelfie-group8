package model.personalgamearea;

import model.commongamearea.BoardTile;
import model.shared.Player;
import model.shared.TileType;
import view.personalgamearea.BookshelfLabel;
import view.personalgamearea.PersonalGameAreaWindow;

public class Bookshelf {
	
	private final int ROWS = 6;
	private final int COLUMNS = 5;
//	private BookshelfLabel label;
	private BookshelfTile[][] tiles = new BookshelfTile[ROWS][COLUMNS];
	private Player player;
	
	public Bookshelf() {
//		label = new BookshelfLabel(PersonalGameAreaWindow.getInstance().getSize());
		initTiles();
	}
	
	//Initializes all tiles in the bookshelf, sets each tile to NULL (which also means it's not displayed on the GUI)
	private void initTiles() {
		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				tiles[row][column] = new BookshelfTile(TileType.NULL, row, column, this);
//				this.label.tilesContainer.add(tiles[row][column].getLabel());
			}
		}
	}
	
//	public BookshelfLabel getLabel() {
//	return label;
//	}
	
	public void dropTile(BoardTile tile, int column) {
		throw new UnsupportedOperationException();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean isFull() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Returns the tile at specified row / column
	 * @param row
	 * @param column
	 * @return
	 */
	public BookshelfTile getTile(int row, int column) {
		if(!isValidCell(row, column))
			throw new IllegalArgumentException("row " + row + " and column " + column + " are not valid coordinates on the Bookshelf!");
		return tiles[row][column];
	}
	
	public void setTileType(int row, int column, TileType tileType) {
		tiles[row][column].setType(tileType);
	}
	
	private boolean isValidCell(int row, int column) {
		return (row > 0 && row < 6) && (column > 0 && column < 5); //row 0-5 | column 0-4
	}
}