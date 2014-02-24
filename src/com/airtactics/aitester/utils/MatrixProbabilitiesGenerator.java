package com.airtactics.aitester.utils;

import com.airtactics.aitester.coreitems.Point;

public class MatrixProbabilitiesGenerator {
	
	public final static int GRID_SIZE = 10;
	
	public static void main(String[] args)
	{
		
	}
	
	public boolean isHeadValid(Point head, int degrees)
	{
		if (degrees == 0)
		{
			if (head.x > 0  && head.x < GRID_SIZE-1 && head.y >= 0 && head.y < GRID_SIZE - 3)
			{
				return true;
			}
		}
		else if (degrees == 90)
		{
			if (head.x > 2  && head.x < GRID_SIZE && head.y > 0 && head.y < GRID_SIZE - 1)
			{
				return true;
			}
		}
		else if (degrees == 180)
		{
			if (head.x > 0  && head.x < GRID_SIZE-1 && head.y > 2 && head.y < GRID_SIZE)
			{
				return true;
			}
		}
		else if (degrees == 270)
		{
			if (head.x >= 0  && head.x < GRID_SIZE-3 && head.y > 0 && head.y < GRID_SIZE - 1)
			{
				return true;
			}
		}
		return false;
	}
	
}
