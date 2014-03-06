package com.airtactics.aitester.ai;

import com.airtactics.aitester.coreitems.Board;
import com.airtactics.aitester.coreitems.Point;
import com.airtactics.aitester.coreitems.Tile.TileType;
import com.airtactics.aitester.utils.MatrixProbabilitiesGenerator;
import com.airtactics.aitester.utils.RandomUtils;

/**
 * @author Vlad
 *
 */
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
		MatrixProbabilitiesGenerator.removeOtherThanMax(probabilityMatrix);
		
		Point point = RandomUtils.getRandomPoint(probabilityMatrix);
		
		while (getOpponentBoard().isPositionAlreayShot(point))
		{
			// should never enter here
			
			
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
			point = RandomUtils.getRandomPoint(probabilityMatrix);
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
	
}
