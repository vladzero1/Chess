package mainGame;

public class Player {
	boolean isPlayer1;
	
	public String username;	
	public int kingAmount = 1;
	public int queenAmount = 1;
	public int bishopAmount = 2;
	public int knightAmount = 2;
	public int rookAmount = 2;
	public int pawnAmount = 7;
	
	public Player(boolean isPlayer1)
	{
		this.isPlayer1 = isPlayer1;
//		this.username =  username;
	}
	
	public boolean getIsPlayer1()
	{
		return isPlayer1;
	}
}
