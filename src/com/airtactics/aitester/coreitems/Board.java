package com.airtactics.aitester.coreitems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.airtactics.aitester.coreitems.Tile.TileType;


/**
 * @author Vlad
 *
 */
public class Board implements Serializable{
	
	private static final long serialVersionUID = -7313359807917057714L;
	
	private byte[][] boardMatrix;
	private List<Plane> planes;

	public Board()
	{
		this.boardMatrix = new byte[10][];
		
		for (int i=0;i<10;i++)
		{
			this.boardMatrix[i] = new byte[10];
		}
		
		for (int i=0;i<10;i++)
    	{
    		for (int j=0;j<10;j++)
    			this.boardMatrix[i][j] = 0;
    	}
		
		this.planes = new ArrayList<Plane>();
		
		this.planes.add(new Plane());
		this.planes.add(new Plane());
		this.planes.add(new Plane());
		
		this.planes.get(0).getHead().x = 1;
		this.planes.get(0).getHead().y = 0;
		this.planes.get(0).setPositionsAfterHead();
		
		this.planes.get(1).getHead().x = 4;
		this.planes.get(1).getHead().y = 1;
		this.planes.get(1).setPositionsAfterHead();
		
		this.planes.get(2).getHead().x = 7;
		this.planes.get(2).getHead().y = 2;
		this.planes.get(2).setPositionsAfterHead();
		
	}

	public void randomizePlanes()
	{
		this.planes.get(0).setRandomDegrees();
		this.planes.get(0).setRandomPosition();
		
		boolean collisions = true;
		while (collisions)
		{
			this.planes.get(1).setRandomDegrees();
			this.planes.get(1).setRandomPosition();
			if (!this.planes.get(1).hasCollisionsWithPlane(this.planes.get(0)))
			{
				collisions = false;
			}
		}
		
		collisions = true;
		while (collisions)
		{
			this.planes.get(2).setRandomDegrees();
			this.planes.get(2).setRandomPosition();
			if (!this.planes.get(2).hasCollisionsWithPlane(this.planes.get(0))
					&& !this.planes.get(2).hasCollisionsWithPlane(this.planes.get(1)))
			{
				collisions = false;
			}
		}
	}
	
	public boolean isPositionAlreayShot(Point point)
	{
		if (boardMatrix[point.x][point.y] == 1)
		{
			return true;
		}
		else return false;
	}
	
	public TileType checkPoint(Point point)
	{
		this.boardMatrix[point.x][point.y] = 1;
		for (Plane plane : this.planes)
		{
			if (point.equals(plane.getHead()))
			{
				return TileType.HIT_HEAD;
			}
			else if (plane.containsPoint(point))
			{
				return TileType.HIT_BODY;
			}
		}
		return TileType.MISSED;
	}
	
	public int getNumberOfHitHeads()
	{
		int count = 0;
		for (Plane plane : this.planes)
		{
			if (this.boardMatrix[plane.getHead().x][plane.getHead().y] == 1)
			{
				count++;
			}
		}
		return count;
	}

}
