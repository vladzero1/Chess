package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javafx.util.Pair;
import mainGame.GameManager;
import mainGame.Grid;
import mainGame.PiecesType;
import mainGame.PlayerColour;

public class ChessWindow extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int row = 8, column = 8;
	public static Grid[][] gridList = new Grid[8][8];
	public static Grid selectedGrid;
	public ChessWindow() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				gbc.gridx = j;
				gbc.gridy = i;
//				Border border = null;
//
//				if (i < 7) {
//					if (j < 7) {
//						border = new MatteBorder(1, 1, 0, 0, java.awt.Color.GRAY);
//					} else {
//						border = new MatteBorder(1, 1, 0, 1, java.awt.Color.GRAY);
//					}
//				} else {
//					if (j < 7) {
//						border = new MatteBorder(1, 1, 1, 0, java.awt.Color.GRAY);
//					} else {
//						border = new MatteBorder(1, 1, 1, 1, java.awt.Color.GRAY);
//					}
//				}
				DrawGrid(new Pair<Integer, Integer>(i, j), gbc);

			}

		}
		
	}

	public class MyActionListener implements ActionListener{
		Pair<Integer, Integer> index;
		private MyActionListener(Pair<Integer, Integer> index) {
			this.index = index;	
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Grid grid = gridList[index.getKey()][index.getValue()];
			JButton button = grid.getButton();
			if(button.getName() == "Grid")
			{
				if(grid.getIsShowMove())
				{
					GameManager.instance.IncreaseTurn();
					selectedGrid.RemoveShowMove();
					selectedGrid.getPiece().UpdateButton(index);
					selectedGrid.getPiece().AfterMove();
					selectedGrid.ResetGrid();
					selectedGrid = null;
					return;
				}
			}
			String buttonName = button.getName();

			if(GameManager.instance.turn%2 != 0)
			{
				if(buttonName.contains(PlayerColour.White.name()))
				{
					System.out.println(grid.getPiece());
					PiecesType type = grid.checkPieceType(buttonName);
					grid.PiecesMove(type, button);
				}
			}
			else
			{
				if(buttonName.contains(PlayerColour.Black.name()))
				{
					PiecesType type = grid.checkPieceType(buttonName);
					grid.PiecesMove(type, button);
				}
			}
		}
		

		
		
		

	}
	// pair index
	// Key = row
	// Value = column
	public void DrawGrid(Pair<Integer, Integer> index, GridBagConstraints gbc) {
		JButton button = new JButton();
		Grid grid = new Grid(button, index);
		gridList[index.getKey()][index.getValue()] = grid;
		button.setName("Grid");
		button.setBorderPainted(true);
		button.setPreferredSize(new Dimension(100, 100));

		int sumPosition = index.getKey() + index.getValue();
		if (sumPosition % 2 == 0)
			button.setBackground(Color.WHITE);
		else
			button.setBackground(Color.GRAY);
		
		 MyActionListener mal = new MyActionListener(index);
		 button.addActionListener(mal);
		 add(button, gbc);
	}
	

}
