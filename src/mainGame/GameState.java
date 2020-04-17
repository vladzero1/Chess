package mainGame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import gui.ChessWindow;

public class GameState {

	public GameState()
	{

	}
	
	private void StartGame()
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
