package pieces;

import javafx.util.Pair;
import mainGame.PiecesType;
import mainGame.Player;

public class Bishop extends Piece {

	public Bishop(Pair<Integer, Integer> position, Player player) {
		super(PiecesType.Bishop, position, player);
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
