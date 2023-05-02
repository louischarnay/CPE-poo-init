package atelier2.model;


import java.util.LinkedList;
import java.util.List;

import atelier2.nutsAndBolts.PieceSquareColor;
/**
 * @author francoiseperrin
 *
 *le mode de déplacement et de prise de la reine est différent de celui du pion
 */
public class QueenModel extends AbstractPieceModel implements PieceModel {

	public QueenModel(Coord coord, PieceSquareColor pieceColor) {
		super(coord, pieceColor);
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		int colDist = targetCoord.getColonne() - this.getColonne();
		int linDist = targetCoord.getLigne() - this.getLigne();

		return Math.abs(colDist) == Math.abs(linDist);
	}
}

