package com.airtactics.aitester.tester;

import com.airtactics.aitester.ai.AI;
import com.airtactics.aitester.ai.RandomAI;
import com.airtactics.aitester.ai.SimpleAi;
import com.airtactics.aitester.coreitems.Board;
import com.airtactics.aitester.coreitems.Game;

/**
 * @author Vlad
 *
 */
public class GamePlayTester {
	
	public static void main(String[] args)
	{
		Game game = new Game();
		int numberOfGames = 100000;
		int player1VictoryCount = 0;
		int player2VictoryCount = 0;
		
		for (int i = 0; i < numberOfGames; i++)
		{
			Board board1 = new Board();
			board1.randomizePlanes();
			Board board2 = new Board();
			board2.randomizePlanes();
			AI player1 = new SimpleAi(board2);
			AI player2 = new RandomAI(board1);
			
			AI winner = game.play(player1, player2);
			if (winner == player1)
			{
				System.out.println("Game number " + i + " won by player1");
				player1VictoryCount++;
			}
			else if (winner == player2)
			{
				System.out.println("Game number " + i + " won by player2");
				player2VictoryCount++;
			}
			else
			{
				System.out.println("Game number " + i + " winner unknown");
			}
		}
		
		System.out.println("Player1 " + player1VictoryCount + " - " + player2VictoryCount + " Player2");
		int difference = Math.abs(player2VictoryCount - player1VictoryCount)/2;
		double differenceInPercents = (double) (difference*100)/numberOfGames ;
		System.out.println("Difference in percents: " + differenceInPercents + "%");
	}
	
}
