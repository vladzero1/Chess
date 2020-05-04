package pieces;

import java.util.List;

import javafx.util.Pair;
import mainGame.PiecesType;
import mainGame.Player;

public class Queen extends Piece {

	public Queen(Pair<Integer, Integer> position, Player player) {
		super(PiecesType.Queen, position, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pair<Integer, Integer>> getMovementIndexList(Pair<Integer, Integer> position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AfterMove() {
		// TODO Auto-generated method stub
		
	}

}
