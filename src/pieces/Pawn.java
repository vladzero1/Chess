package pieces;

import javafx.util.Pair;
import mainGame.PiecesType;
import mainGame.Player;

public class Pawn extends Piece{

	boolean isEverMove = false;
	public Pawn(Pair<Integer, Integer> position, Player player) {
		super(PiecesType.Pawn, position, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void isValidMovement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pair<Integer, Integer>[] getMovementIndex(Pair<Integer, Integer> position) {
		// TODO Auto-generated method stub
			
		return null;
	}

}
