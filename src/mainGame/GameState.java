package mainGame;

public class GameState {

	public static void main(String[] args)
	{
		GameState.StartGame();
	}
	
	public GameState()
	{

	}
	
	public static void StartGame()
	{
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				new Board();
			}
		});
		thread.start();
	}


}
