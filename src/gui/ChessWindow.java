package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javafx.util.Pair;
import mainGame.GameManager;
import mainGame.Grid;
import mainGame.PiecesType;
import mainGame.PlayerColour;
import pieces.King;
import pieces.Piece;

public class ChessWindow extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int row = 8, column = 8;
	public static Grid[][] gridList = new Grid[8][8];
	public static List<Piece> whitePieceList = new ArrayList<Piece>();
	public static List<Piece> blackPieceList = new ArrayList<Piece>();
	public static Grid selectedGrid;
	
	public ChessWindow() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				gbc.gridx = j;
				gbc.gridy = i;

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
			System.out.println(" ");
			Grid grid = gridList[index.getKey()][index.getValue()];
			JButton button = grid.getButton();
			String buttonName = button.getName();
			
			if(GameManager.instance.turn%2 != 0)
			{
				if(buttonName.contains(PlayerColour.White.name()))
				{
					PiecesType type = grid.checkPieceType(buttonName);
					grid.PiecesMove(type, button);
				}
				else 
				{
					if(grid.getIsShowAttack())
					{
						blackPieceList.remove(grid.getPiece());
					}
					if(grid.getIsShowMove())
					{
						System.out.println("boom white");
						GameManager.instance.IncreaseTurn();
						selectedGrid.RemoveShowMove();
						selectedGrid.getPiece().UpdateButton(index);
						selectedGrid.getPiece().AfterMove();
						selectedGrid.ResetGrid();
						selectedGrid = null;
						GameManager.instance.setIsCheck(grid.getPiece());
						GameManager.instance.IsCheckmate();
						return;
					}
				}
			}
			else
			{
				if(buttonName.contains(PlayerColour.Black.name()))
				{
					PiecesType type = grid.checkPieceType(buttonName);
					grid.PiecesMove(type, button);
				}
				else
				{
					if(grid.getIsShowAttack())
					{
						whitePieceList.remove(selectedGrid.getPiece());
					}
					if(grid.getIsShowMove())
					{
						System.out.println("boom black");
						GameManager.instance.IncreaseTurn();
						selectedGrid.RemoveShowMove();
						selectedGrid.getPiece().UpdateButton(index);
						selectedGrid.getPiece().AfterMove();
						selectedGrid.ResetGrid();
						selectedGrid = null;
						GameManager.instance.setIsCheck(grid.getPiece());
						GameManager.instance.IsCheckmate();
						return;
					}
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
	
	public static King getKing(PlayerColour whiteColour)
	{
		if(whiteColour == PlayerColour.White)
		{
			for (Piece piece : whitePieceList) {
				if (piece instanceof King) {
					return (King)piece;
				}
			}
		}
		else
		{
			for (Piece piece : blackPieceList) {
				if (piece instanceof King) {
					return (King)piece;
				}
			}
		}
		return null;
	}
}
