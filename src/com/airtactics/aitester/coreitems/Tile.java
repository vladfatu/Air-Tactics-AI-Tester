package com.airtactics.aitester.coreitems;


/**
 * @author Vlad
 *
 */
public class Tile {
	
	public enum TileType{
		HIT_HEAD,
		HIT_BODY,
		MISSED,
		NONE
	}
	
	public static int HIT_HEAD_WIDTH, HIT_BODY_WIDTH, NO_HIT_WIDTH;
	public static int HIT_HEAD_WIDTH_SMALL, HIT_BODY_WIDTH_SMALL, NO_HIT_WIDTH_SMALL;
	
	private boolean selected;

	private TileType type;

	private Point position;
	
	public Tile(int x, int y) {
		this.position = new Point(x, y);
		this.setType(TileType.NONE);
		this.selected = false;
	}

	public boolean isSelected()
	{
		return selected;
	}

	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}

	public Point getPosition()
	{
		return position;
	}

	public void setPosition(Point position)
	{
		this.position = position;
	}
	
	public Point getViewPosition(int gridSize, boolean isSmall)
	{
		int unit = gridSize/10;
		
		int imageSize = getImageSize(gridSize, isSmall);
		
		int left = this.position.x * unit + unit/2 - imageSize/2;
		int top = this.position.y * unit + unit/2 - imageSize/2;
		
		return new Point(left, top);
	}

	public TileType getType()
	{
		return type;
	}

	public void setType(TileType type)
	{
		this.type = type;
	}
	
	private int getImageSize(int gridSize, boolean isSmall)
	{
		if (this.selected)
		{
			return gridSize/10;
		}
		else
		{
			switch (this.type)
			{
				case HIT_HEAD:
				{
					if (isSmall)
					{
						return HIT_HEAD_WIDTH_SMALL;
					}
					else
					{
						return HIT_HEAD_WIDTH;
					}
				}
				case HIT_BODY:
				{
					if (isSmall)
					{
						return HIT_BODY_WIDTH_SMALL;
					}
					else
					{
						return HIT_BODY_WIDTH;
					}
				}
				case MISSED:
				{
					if (isSmall)
					{
						return NO_HIT_WIDTH_SMALL;
					}
					else
					{
						return NO_HIT_WIDTH;
					}
				}
				case NONE:
				{
					return 0;
				}
			}
		}
		return 0;
	}
}
