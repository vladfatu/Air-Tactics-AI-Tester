package com.airtactics.aitester.ai;

import com.airtactics.aitester.coreitems.Board;
import com.airtactics.aitester.coreitems.Tile.TileType;

public abstract class AI {
	
	private Board opponentBoard;

	public AI(Board opponentBoard)
	{
		this.opponentBoard = opponentBoard;
	}
	
	public abstract TileType shoot();
	
	public Board getOpponentBoard()
	{
		return opponentBoard;
	}

	public void setOpponentBoard(Board opponentBoard)
	{
		this.opponentBoard = opponentBoard;
	}
}
