package mainGame;

public class Player {
	PlayerColour colour;
	
	public String username;	
	public int kingAmount = 1;
	public int queenAmount = 1;
	public int bishopAmount = 2;
	public int knightAmount = 2;
	public int rookAmount = 2;
	public int pawnAmount = 7;
	
	public Player(PlayerColour playerColour)
	{
		colour = playerColour;
//		this.username =  username;
	}
	
	public PlayerColour getColour()
	{
		return colour;
	}
}
