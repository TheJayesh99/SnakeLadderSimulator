package com.bridgelabz.snakeladder;

public class SnakeLadderSimulator
{
	//	CONSTANTS
	public static final int START_POSITION = 0;
	public static final int LADDER = 1 ;	
	public static final int SNAKE = 2 ;
	public static final int GOAL = 100 ;

	public static void main(String[] args)
	{
		System.out.println( "WelCome To Snake Ladder Simulator" );

		//	VARIABLES
		boolean player1Playing = true ;
		int player1Position = 0 ;
		int player2Position = 0 ;
		int dicePlayedTimes = 0 ;
		int playerPosition = 0 ;

		while( player1Position < GOAL && player2Position < GOAL ) 
		{
//			WHICH PLAYER IS PLAYING
			if (player1Playing)
			{
				System.out.println( "Player 1 Playing  " );
				System.out.println( "Player 1 Position "+player1Position );
				playerPosition = player1Position;
			}
			else
			{
				System.out.println( "Player 2 Playing  " );
				System.out.println( "Player 2 Position "+player2Position );
				playerPosition = player2Position;
			}

//			CONDITION FOR ROLLING THE DICE TO GET NUMBER BETWEEN 1-6
			int diceRoll = (int) (Math.floor(Math.random() * 10 ) % 6) + 1 ;
			System.out.println("Dice value " + diceRoll);
			dicePlayedTimes++ ;

//			CONDITION TO CHECK WHICH OPTION PLAYER CHOOSE
			int playerOption = (int) Math.floor(Math.random() * 10 ) % 3 ;


			switch ( playerOption )
			{

			case LADDER :

				System.out.println( "Player Choose Ladder  " );

				if ( ( playerPosition + diceRoll ) <= GOAL )
				{				

					playerPosition = playerPosition + diceRoll;
				}

				break;

			case SNAKE :		
				System.out.println( "Player Choose Snake  " );

				if ( ( playerPosition - diceRoll ) <= START_POSITION )
				{
					playerPosition = START_POSITION ;
				}
				else
				{				
					playerPosition = playerPosition - diceRoll ;
				}

				break;

			default:
				System.out.println( "Player Choose No Play  " );
				break;
			}

			if (player1Playing)
			{
				player1Position = playerPosition;
				System.out.println( "Player 1 new Position "+player1Position );
			}
			else
			{
				player2Position = playerPosition;
				System.out.println( "Player 2 new Position "+player2Position );
			}
			
			if (playerOption != LADDER) 
			{
				player1Playing = !(player1Playing);
			}
					System.out.println("\n --------");
		}

		System.out.println("The Number Of times Dice Rolled "+ dicePlayedTimes  );
		
		if (player1Position == GOAL) 
		{
			System.out.println("Player 1 Won The Game");
		}
		else 
		{			
			System.out.println("Player 2 Won The Game");
		}
	}

}
