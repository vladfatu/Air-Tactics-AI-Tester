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
public class SmartRandomAI extends AI{

	private int[][] probabilityMatrix;
	public TileType[][] tileMatrix;

	public SmartRandomAI(Board opponentBoard) {
		super(opponentBoard);
		tileMatrix = MatrixProbabilitiesGenerator.initTileMatrix();
		probabilityMatrix = MatrixProbabilitiesGenerator.initMatrix();
		MatrixProbabilitiesGenerator.generateProbabilityMatrix(probabilityMatrix, tileMatrix);
	}

	@Override
	public TileType shoot()
	{
		Point point = RandomUtils.getRandomPoint(probabilityMatrix);

		while (getOpponentBoard().isPositionAlreayShot(point))
		{
			System.out.println("already shot: " + point.x + ", " + point.y);
			point = RandomUtils.getRandomPoint(probabilityMatrix);
		}

		probabilityMatrix[point.x][point.y] = 0;
		return getOpponentBoard().checkPoint(point);

	}

}