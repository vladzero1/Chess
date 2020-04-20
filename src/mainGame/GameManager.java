package mainGame;

public class GameManager {
	public static GameManager instance;

	public int turn = 1;

	public static void main(String[] args)
	{
		new Board();
		new GameManager();
	}
	
	public GameManager() {
		instance = this;
	}

}
