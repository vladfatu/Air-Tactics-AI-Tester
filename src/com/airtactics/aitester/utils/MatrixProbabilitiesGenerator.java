package com.airtactics.aitester.utils;

import com.airtactics.aitester.coreitems.Plane;
import com.airtactics.aitester.coreitems.Point;
import com.airtactics.aitester.coreitems.Tile.TileType;

public class MatrixProbabilitiesGenerator {

	public final static int GRID_SIZE = 10;
	
	public static TileType[][] tileMatrix;
	private static int[][] probabilityMatrix;

	public static void main(String[] args)
	{
		tileMatrix = initTileMatrix();
		tileMatrix[1][1] = TileType.MISSED;
		probabilityMatrix = initMatrix();
		generateProbabilityMatrix(probabilityMatrix, tileMatrix);
		printMatrix(probabilityMatrix);
	}
	
	public static int[][] initMatrix()
	{
		int[][] probabilityMatrix = new int[GRID_SIZE][];

		for (int i = 0; i < 10; i++)
		{
			probabilityMatrix[i] = new int[GRID_SIZE];
		}
		
		return probabilityMatrix;
	}
	
	public static TileType[][] initTileMatrix()
	{
		TileType[][] tileMatrix = new TileType[GRID_SIZE][];

		for (int i = 0; i < GRID_SIZE; i++)
		{
			tileMatrix[i] = new TileType[GRID_SIZE];
			for (int j = 0;j < GRID_SIZE; j++)
			{
				tileMatrix[i][j] = TileType.NONE;
			}
		}
		
		return tileMatrix;
	}

	public static void generateProbabilityMatrix(int[][] probabilityMatrix, TileType[][] tileMatrix)
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				probabilityMatrix[i][j] = 0;
				if (tileMatrix[i][j] == TileType.NONE)
				{
					Point head = new Point(i, j);
					if (isPlaneValid(head, 0, tileMatrix))
					{
						probabilityMatrix[i][j]++;
					}
					if (isPlaneValid(head, 90, tileMatrix))
					{
						probabilityMatrix[i][j]++;
					}
					if (isPlaneValid(head, 180, tileMatrix))
					{
						probabilityMatrix[i][j]++;
					}
					if (isPlaneValid(head, 270, tileMatrix))
					{
						probabilityMatrix[i][j]++;
					}
				}

			}
		}
	}
	
	public static boolean isPointValid(Point point, TileType[][] tileMatrix)
	{
		return tileMatrix[point.x][point.y] != TileType.MISSED;
	}
	
	public static boolean isPlaneValid(Point head, int degrees, TileType[][] tileMatrix)
	{
		if (isHeadValid(head, degrees))
		{
			if (!isPointValid(head, tileMatrix))
			{
				return false;
			}
			Plane plane = new Plane();
			plane.setHead(head);
			plane.setDegrees(degrees);
			plane.setPositionsAfterHead();
			for (Point point : plane.getPoints())
			{
				if (!isPointValid(point, tileMatrix))
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isHeadValid(Point head, int degrees)
	{
		if (degrees == 0)
		{
			if (head.x > 0 && head.x < GRID_SIZE - 1 && head.y >= 0 && head.y < GRID_SIZE - 3)
			{
				return true;
			}
		} else if (degrees == 90)
		{
			if (head.x > 2 && head.x < GRID_SIZE && head.y > 0 && head.y < GRID_SIZE - 1)
			{
				return true;
			}
		} else if (degrees == 180)
		{
			if (head.x > 0 && head.x < GRID_SIZE - 1 && head.y > 2 && head.y < GRID_SIZE)
			{
				return true;
			}
		} else if (degrees == 270)
		{
			if (head.x >= 0 && head.x < GRID_SIZE - 3 && head.y > 0 && head.y < GRID_SIZE - 1)
			{
				return true;
			}
		}
		return false;
	}
	
	public static void printMatrix(TileType[][] tileMatrix)
	{
		for (int i = 0; i < GRID_SIZE; i++)
		{
			for (int j = 0; j < GRID_SIZE; j++)
			{
				System.out.print(tileMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printMatrix(int[][] probabilityMatrix)
	{
		for (int i = 0; i < GRID_SIZE; i++)
		{
			for (int j = 0; j < GRID_SIZE; j++)
			{
				System.out.print(probabilityMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
