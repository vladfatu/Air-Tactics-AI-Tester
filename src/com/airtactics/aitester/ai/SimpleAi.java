package com.airtactics.aitester.ai;

import java.util.Random;

import com.airtactics.aitester.coreitems.Board;
import com.airtactics.aitester.coreitems.Point;
import com.airtactics.aitester.coreitems.Tile.TileType;

public class SimpleAi extends AI{

	public SimpleAi(Board opponentBoard) {
		super(opponentBoard);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileType shoot()
	{
		Random r = new Random();
		int x = r.nextInt(10);
		int y = r.nextInt(10);
		
		while (getOpponentBoard().isPositionAlreayShot(new Point(x, y)) || isCorner(x, y))
		{
			x = r.nextInt(10);
			y = r.nextInt(10);
		}
		
		return getOpponentBoard().checkPoint(new Point(x, y));
	}
	
	private boolean isCorner(int x, int y)
	{
		if ((x == 0 | x == 10) && (y == 0 || y == 10))
		{
			return true;
		}
		return false;
	}

}
