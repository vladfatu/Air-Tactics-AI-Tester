package com.airtactics.aitester.utils;

import com.airtactics.aitester.coreitems.Point;

public class MatrixProbabilitiesGenerator {

	public final static int GRID_SIZE = 10;

	private static int[][] probabilityMatrix;

	public static void main(String[] args)
	{
		probabilityMatrix = initMatrix();
		generateProbabilityMatrix(probabilityMatrix);
		printMatrix();
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

	public static void generateProbabilityMatrix(int[][] probabilityMatrix)
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				probabilityMatrix[i][j] = 0;
				Point head = new Point(i, j);
				if (isHeadValid(head, 0))
				{
					probabilityMatrix[i][j]++;
				}
				if (isHeadValid(head, 90))
				{
					probabilityMatrix[i][j]++;
				}
				if (isHeadValid(head, 180))
				{
					probabilityMatrix[i][j]++;
				}
				if (isHeadValid(head, 270))
				{
					probabilityMatrix[i][j]++;
				}

			}
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

	public static void printMatrix()
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
