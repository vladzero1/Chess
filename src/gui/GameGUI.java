package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import mainGame.GameState;

public class GameGUI {
	
	public static void main(String[] args)
	{
		GameState gameState = new GameState();
		
	}
	
	public GameGUI()
	{
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("spawned");
				SpawnBoard();
			}
		});
		thread.start();
	}
	
	private void SpawnBoard()
	{
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        ChessWindow window = new ChessWindow();
        frame.add(window);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
