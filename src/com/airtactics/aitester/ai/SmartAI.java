package com.airtactics.aitester.ai;

import java.util.Random;

import com.airtactics.aitester.coreitems.Board;
import com.airtactics.aitester.coreitems.Point;
import com.airtactics.aitester.coreitems.Tile.TileType;
import com.airtactics.aitester.utils.MatrixProbabilitiesGenerator;

public class SmartAI extends AI{
	
	private int[][] probabilityMatrix;
	public TileType[][] tileMatrix;

	public SmartAI(Board opponentBoard) {
		super(opponentBoard);
		
		tileMatrix = MatrixProbabilitiesGenerator.initTileMatrix();
		probabilityMatrix = MatrixProbabilitiesGenerator.initMatrix();
		
	}

	@Override
	public TileType shoot()
	{
		MatrixProbabilitiesGenerator.generateProbabilityMatrix(probabilityMatrix, tileMatrix);
		
		Point point = getRandomPoint();
		
		while (getOpponentBoard().isPositionAlreayShot(point))
		{
//			MatrixProbabilitiesGenerator.printMatrix(probabilityMatrix);
//			System.out.println();
//			MatrixProbabilitiesGenerator.printMatrix(tileMatrix);
			System.out.println("already shot: " + point.x + ", " + point.y);
//			try
//			{
//				Thread.sleep(100);
//			} catch (InterruptedException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			point = getRandomPoint();
		}
		
//		try
//		{
//			Thread.sleep(20);
//		} catch (InterruptedException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("point shot: " + point.x + ", " + point.y);
		
		probabilityMatrix[point.x][point.y] = 0;
		TileType tiletype = getOpponentBoard().checkPoint(point);
		tileMatrix[point.x][point.y] = tiletype;
		return tiletype;
		
	}
	
	private Point getRandomPoint()
	{
		int x=0, y=0;
		Random r = new Random();
		int[] rows = new int[MatrixProbabilitiesGenerator.GRID_SIZE];
		int sum = 0;
		for (int i=0;i<MatrixProbabilitiesGenerator.GRID_SIZE;i++)
		{
			for (int j=0;j<MatrixProbabilitiesGenerator.GRID_SIZE;j++)
			{
				rows[i] += probabilityMatrix[i][j];
			}
			sum += rows[i];
		}
		int randomValue = r.nextInt(sum)+1;
		x = getRandomFromRow(rows, randomValue);
		
		randomValue = r.nextInt(rows[x])+1;
		
		y = getRandomFromRow(probabilityMatrix[x], randomValue);
		
		return new Point(x, y);
	}
	
	private int getRandomFromRow(int[] row, int randomValue)
	{
		int tempSum = 0;
		for (int i=0;i<MatrixProbabilitiesGenerator.GRID_SIZE;i++)
		{
			tempSum += row[i];
			if (tempSum >= randomValue)
			{
				return i;
			}
		}
		return 0;
	}
	
}
