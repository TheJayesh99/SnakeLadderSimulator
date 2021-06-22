package SnakeLadderSimulator;

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
		boolean player1playing = true ;
		int Player1Position = 0 ;
		int Player2Position = 0 ;
		int DicePlayedTimes = 0 ;
		int PlayerPosition = 0 ;

		while( Player1Position < GOAL && Player2Position < GOAL ) 
		{
//			WHICH PLAYER IS PLAYING
			if (player1playing)
			{
				System.out.println( "Player 1 Playing  " );
				System.out.println( "Player 1 Position "+Player1Position );
				PlayerPosition = Player1Position;
			}
			else
			{
				System.out.println( "Player 2 Playing  " );
				System.out.println( "Player 2 Position "+Player2Position );
				PlayerPosition = Player2Position;
			}

//			CONDITION FOR ROLLING THE DICE TO GET NUMBER BETWEEN 1-6
			int DiceRoll = (int) (Math.floor(Math.random() * 10 ) % 6) + 1 ;
			System.out.println("Dice value " + DiceRoll);
			DicePlayedTimes++ ;

//			CONDITION TO CHECK WHICH OPTION PLAYER CHOOSE
			int PlayerOption = (int) Math.floor(Math.random() * 10 ) % 3 ;


			switch ( PlayerOption )
			{

			case LADDER :

				System.out.println( "Player Choose Ladder  " );

				if ( ( PlayerPosition + DiceRoll ) <= GOAL )
				{				

					PlayerPosition = PlayerPosition + DiceRoll;
				}

				break;

			case SNAKE :		
				System.out.println( "Player Choose Snake  " );

				if ( ( PlayerPosition - DiceRoll ) <= START_POSITION )
				{
					PlayerPosition = START_POSITION ;
				}
				else
				{				
					PlayerPosition = PlayerPosition - DiceRoll ;
				}

				break;

			default:
				System.out.println( "Player Choose No Play  " );
				break;
			}

			if (player1playing)
			{
				Player1Position = PlayerPosition;
				System.out.println( "Player 1 new Position "+Player1Position );
			}
			else
			{
				Player2Position = PlayerPosition;
				System.out.println( "Player 2 new Position "+Player2Position );
			}
			
			if (PlayerOption != LADDER) 
			{
				player1playing = !(player1playing);
			}
					System.out.println("\n --------");
		}

		System.out.println("The Number Of times Dice Rolled "+ DicePlayedTimes  );
		
		if (Player1Position == GOAL) 
		{
			System.out.println("Player 1 Won The Game");
		}
		else 
		{			
			System.out.println("Player 2 Won The Game");
		}
	}

}
