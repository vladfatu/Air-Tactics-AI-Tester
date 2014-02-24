package com.airtactics.aitester.coreitems;

import java.util.ArrayList;
import java.util.List;

import com.airtactics.aitester.coreitems.Tile.TileType;


/**
 * @author Vlad
 *
 */
public class Board {
	
	private Tile[][] tileMatrix;
	private List<Plane> planes;
	
	public Board()
	{
		this.tileMatrix = new Tile[10][];
		
		for (int i=0;i<10;i++)
		{
			this.tileMatrix[i] = new Tile[10];
		}
		
		for (int i=0;i<10;i++)
    	{
    		for (int j=0;j<10;j++)
    			this.tileMatrix[i][j] = new Tile(i,j);
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

	public List<Plane> getPlanes()
	{
		return planes;
	}

	public void setPlanes(List<Plane> planes)
	{
		this.planes = planes;
	}
	
	public void randomizePlanes()
	{
		this.planes.get(0).setRandomDegrees();
		this.planes.get(0).setRandomPosition();
		//System.out.println("Plane1 : x : " + this.planes.get(0).getHead().x + " y : " + this.planes.get(0).getHead().y + " degrees : " + this.planes.get(0).getDegrees());
		
		boolean collisions = true;
		while (collisions)
		{
			this.planes.get(1).setRandomDegrees();
			this.planes.get(1).setRandomPosition();
			if (!this.planes.get(1).hasCollisionsWithPlane(this.planes.get(0)))
			{
				//System.out.println("Plane2 : x : " + this.planes.get(1).getHead().x + " y : " + this.planes.get(1).getHead().y + " degrees : " + this.planes.get(1).getDegrees());
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
				//System.out.println("Plane3 : x : " + this.planes.get(2).getHead().x + " y : " + this.planes.get(2).getHead().y + " degrees : " + this.planes.get(2).getDegrees());
				collisions = false;
			}
		}
	}
	
	public boolean isPositionAlreayShot(int x, int y)
	{
		Tile tile = this.tileMatrix[x][y];
		if (tile.getType() == TileType.NONE)
		{
			return false;
		}
		else return true;
	}
	
	public Tile shootPosition(int x, int y)
	{
		Tile tile = this.tileMatrix[x][y];
		TileType tileType = checkPoint(new Point(x, y));
		tile.setType(tileType);
		return tile;
	}
	
	private TileType checkPoint(Point point)
	{
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
			if (this.tileMatrix[plane.getHead().x][plane.getHead().y].getType() == TileType.HIT_HEAD)
			{
				count++;
			}
		}
		return count;
	}

}
