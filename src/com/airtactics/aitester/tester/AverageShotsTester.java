package com.airtactics.aitester.tester;

import com.airtactics.aitester.ai.AI;
import com.airtactics.aitester.ai.SimpleAi;
import com.airtactics.aitester.ai.SmartAI;
import com.airtactics.aitester.ai.SmartRandomAI;
import com.airtactics.aitester.coreitems.Board;
import com.airtactics.aitester.coreitems.Game;

public class AverageShotsTester {

	public static void main(String[] args)
	{
		Game game = new Game();
		int numberOfGames = 100000;
		int totalShots = 0;
		long maxTime = 0;
		
		for (int i = 0; i < numberOfGames; i++)
		{
			long startTime = System.currentTimeMillis();
			Board board = new Board();
			board.randomizePlanes();
			AI player = new SmartAI(board);
			
			int shots = game.playSingle(player);
			long shootTime = System.currentTimeMillis() - startTime;
			System.out.println("Game number " + i + " number of shots: " + shots + " in " + shootTime + " milliseconds");
			if (shootTime > maxTime)
			{
				maxTime = shootTime;
			}
			totalShots += shots;
			
		}
		
		double average = (double) totalShots / numberOfGames;
		System.out.println("Avarage shots: " + average + " max time: " + maxTime);
	}
	
}
