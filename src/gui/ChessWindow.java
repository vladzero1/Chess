package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import javafx.util.Pair;

public class ChessWindow extends JPanel {
	public final int row = 8, column = 8;
	public ChessWindow()
	{
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
		int num = 1;
        for(int i = 0;i<row;i++)
        {
        	for(int j = 0;j<column;j++)
        	{
        		gbc.gridx = j;
        		gbc.gridy = i;
        		Border border = null;

//        		if (i < 7) {
//                    if (j < 7) {
//                        border = new MatteBorder(1, 1, 0, 0, java.awt.Color.GRAY);
//                    } else {
//                        border = new MatteBorder(1, 1, 0, 1, java.awt.Color.GRAY);
//                    }
//                } else {
//                    if (j < 7) {
//                        border = new MatteBorder(1, 1, 1, 0, java.awt.Color.GRAY);
//                    } else {
//                        border = new MatteBorder(1, 1, 1, 1, java.awt.Color.GRAY);
//                    }
//                }
        		DrawGrid(new Pair<Integer, Integer>(i,j), gbc);

        	}

        }
	}
	// pair index 
	// Key = row 
	// Value = column
	public void DrawGrid(Pair<Integer, Integer> index, GridBagConstraints gbc)
	{
		JButton button = new JButton();
		if(index.getKey() == 0)
		{
			if(index.getValue() == 0 || index.getValue() == 7)
			{
				Image img = getPieceIcon("Assets/blackRook.png");
				button.setIcon(new ImageIcon(img));
			}
			else if(index.getValue() == 1 || index.getValue() == 6)
			{
				Image img = getPieceIcon("Assets/blackBishop.png");
				button.setIcon(new ImageIcon(img));
			}
			else if(index.getValue() == 2 || index.getValue() == 5)
			{
				Image img = getPieceIcon("Assets/blackKnight.png");
				button.setIcon(new ImageIcon(img));
			}
			else if(index.getValue() == 3)
			{
				Image img = getPieceIcon("Assets/blackQueen.png");
				button.setIcon(new ImageIcon(img));
			}
			else if(index.getValue() == 4)
			{
				Image img = getPieceIcon("Assets/blackKing.png");
				button.setIcon(new ImageIcon(img));
			}
			
		}
//		else if()

        button.setBorderPainted(true);
        button.setPreferredSize(new Dimension(100, 100));
        
//        if(sumPosition%2 == 0)
//        	button.setBackground(Color.WHITE);
//        else
//        	button.setBackground(Color.GRAY);
        
//        MyActionListener mal = new MyActionListener();
//        button.addActionListener(mal);
        add(button, gbc);
	}
	
	public Image getPieceIcon(String iconURL)
	{
		Image img = null;
		try {
			img = ImageIO.read(getClass().getResource(iconURL));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
}



