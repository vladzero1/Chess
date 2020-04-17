package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import javafx.util.Pair;

public class ChessWindow extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int row = 8, column = 8;
	public static JButton[][] gridList = new JButton[8][8];

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

	// pair index
	// Key = row
	// Value = column
	public void DrawGrid(Pair<Integer, Integer> index, GridBagConstraints gbc) {
		JButton button = new JButton();
		gridList[index.getKey()][index.getValue()] = button;

		button.setBorderPainted(true);
		button.setPreferredSize(new Dimension(100, 100));

		int sumPosition = index.getKey() + index.getValue();
		if (sumPosition % 2 == 0)
			button.setBackground(Color.WHITE);
		else
			button.setBackground(Color.GRAY);

		// MyActionListener mal = new MyActionListener();
		// button.addActionListener(mal);
		add(button, gbc);
	}
}
