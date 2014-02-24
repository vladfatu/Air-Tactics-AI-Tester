package com.airtactics.aitester.ai;

import java.util.Random;

import com.airtactics.aitester.coreitems.Board;
import com.airtactics.aitester.coreitems.Tile;

public class RandomAI extends AI{

	public RandomAI(Board opponentBoard) {
		super(opponentBoard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tile shoot()
	{
		Random r = new Random();
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		
		while (getOpponentBoard().isPositionAlreayShot(x, y))
		{
			x = r.nextInt(10);
			y = r.nextInt(10);
		}
		
		return getOpponentBoard().shootPosition(x, y);
		
	}

}
