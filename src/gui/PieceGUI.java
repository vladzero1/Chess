package gui;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javafx.util.Pair;
import mainGame.PiecesType;
import mainGame.PlayerColour;
import pieces.Piece;

public class PieceGUI {

	PiecesType type;
	PlayerColour colour;
	Pair<Integer, Integer> position;
	Image img = null;
	
	public PieceGUI(PiecesType pieceType, PlayerColour playerColour, Pair<Integer, Integer> position, Piece piece)
	{
		type = pieceType;
		colour = playerColour;
		this.position = position;
		UpdateButton(piece);
	}
	
	public Image getPieceIcon()
	{
		String iconURL = "";
		if (colour == PlayerColour.Black) {
			iconURL = "Assets/black";
		} else {
			iconURL = "Assets/white";
		}
		if (type == PiecesType.King) {
			iconURL += "King.png";
		} else if (type == PiecesType.Queen) {
			iconURL += "Queen.png";
		} else if (type == PiecesType.Bishop) {
			iconURL += "Bishop.png";
		} else if (type == PiecesType.Knight) {
			iconURL += "Knight.png";
		} else if (type == PiecesType.Rook) {
			iconURL += "Rook.png";
		} else if (type == PiecesType.Pawn) {
			iconURL += "Pawn.png";
		}
		try {
			img = ImageIO.read(getClass().getResource(iconURL));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public void UpdateButton(Piece piece)
	{
		img = getPieceIcon();
		
		JButton button = ChessWindow.gridList[position.getKey()][position.getValue()].getButton();
		button.setIcon(new ImageIcon(img));
		button.setName(colour.name() + " " + type.name());
		
//		ActionListener mal = button.getActionListeners()[0];
//		System.out.println(mal.getClass().);
	}
	
	
}
