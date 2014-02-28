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
			TileType tileType = player1.shoot();
			if (tileType == TileType.HIT_HEAD && player1.getOpponentBoard().getNumberOfHitHeads() == Constants.NUMBER_OF_PLANES)
			{
				winner = player1;
			}
			tileType = player2.shoot();
			if (tileType == TileType.HIT_HEAD && player2.getOpponentBoard().getNumberOfHitHeads() == Constants.NUMBER_OF_PLANES)
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
			TileType tileType = player.shoot();
			if (tileType == TileType.HIT_HEAD && player.getOpponentBoard().getNumberOfHitHeads() == Constants.NUMBER_OF_PLANES)
			{
				finished = true;
			}
		}
		return count;
	}

}
