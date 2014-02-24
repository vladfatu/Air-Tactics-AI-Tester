package com.airtactics.aitester.tester;

import com.airtactics.aitester.ai.AI;
import com.airtactics.aitester.ai.SimpleAi;
import com.airtactics.aitester.coreitems.Board;
import com.airtactics.aitester.coreitems.Game;

public class AverageShotsTester {

	public static void main(String[] args)
	{
		Game game = new Game();
		int numberOfGames = 100000;
		int totalShots = 0;
		
		for (int i = 0; i < numberOfGames; i++)
		{
			
			Board board = new Board();
			board.randomizePlanes();
			AI player = new SimpleAi(board);
			
			int shots = game.playSingle(player);
			System.out.println("Game number " + i + " number of shots: " + shots);
			totalShots += shots;
			
		}
		
		double average = (double) totalShots / numberOfGames;
		System.out.println("Avarage shots: " + average);
	}
	
}
