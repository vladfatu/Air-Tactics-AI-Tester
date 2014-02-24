package com.airtactics.aitester.coreitems;

import com.airtactics.aitester.ai.AI;
import com.airtactics.aitester.coreitems.Tile.TileType;
import com.airtactics.aitester.utils.Constants;

/**
 * @author Vlad
 *
 */
public class Game {
	
	public AI play(AI player1, AI player2)
	{
		AI winner = null;
		while (winner == null)
		{
			Tile tile = player1.shoot();
			if (tile.getType() == TileType.HIT_HEAD && player1.getOpponentBoard().getNumberOfHitHeads() == Constants.NUMBER_OF_PLANES)
			{
				winner = player1;
			}
			tile = player2.shoot();
			if (tile.getType() == TileType.HIT_HEAD && player2.getOpponentBoard().getNumberOfHitHeads() == Constants.NUMBER_OF_PLANES)
			{
				winner = player2;
			}
		}
		return winner;
	}
	
	public int playSingle(AI player)
	{
		int count = 0;
		boolean finished = false;
		while (!finished)
		{
			count++;
			Tile tile = player.shoot();
			if (tile.getType() == TileType.HIT_HEAD && player.getOpponentBoard().getNumberOfHitHeads() == Constants.NUMBER_OF_PLANES)
			{
				finished = true;
			}
		}
		return count;
	}

}
