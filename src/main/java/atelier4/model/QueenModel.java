package atelier4.model;


import atelier4.nutsAndBolts.PieceSquareColor;
/**
 * @author francoiseperrin
 *
 *le mode de d�placement et de prise de la reine est diff�rent de celui du pion
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

