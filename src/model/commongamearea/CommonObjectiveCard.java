package model.commongamearea;

import java.util.Stack;

import model.personalgamearea.PointTile;
import model.shared.Player;

public class CommonObjectiveCard {
	
	private int cardId;
	public static int MAX_CARD_ID = 12;
	private Stack<PointTile> pointTiles = new Stack<>();
	
	public CommonObjectiveCard(int card_id) {
		this.cardId = card_id;
		
		initPointsList();
	}
	
	public int getId() {
		return this.cardId;
	}
	
	private void initPointsList() {
		
		switch (Player.getNumberOfPlayers()) {
		case 2:
			pointTiles.push(new PointTile(this, 4));
			pointTiles.push(new PointTile(this, 8));
			return;

		case 3:
			pointTiles.push(new PointTile(this, 4));
			pointTiles.push(new PointTile(this, 6));
			pointTiles.push(new PointTile(this, 8));
			return;
		
		case 4:
			
			pointTiles.push(new PointTile(this, 2));
			pointTiles.push(new PointTile(this, 4));
			pointTiles.push(new PointTile(this, 6));
			pointTiles.push(new PointTile(this, 8));
			return;
			
		default:
			throw new IllegalStateException("Something went wrong while initializing common objective card with id " + this.cardId);
		}
	}
	
	/**
	 * Give the points displayed on the first available tile to the player
	 * @param player to give the points to
	 */
	public void award(Player player) {		
		//If there are no points left, don't give any
		if(pointTiles.size() <= 0) {
			return;
		}
		
		//Give points and remove the value of points awarded to the player
		player.awardPointTile(pointTiles.lastElement());
		pointTiles.pop();
	}
	
	//Check if player can receive points - needs to be implemented
	private boolean checkPoints(Player player) {
		return true;
	}

	public Stack<PointTile> getPointTiles() {
		return pointTiles;
	}
}
