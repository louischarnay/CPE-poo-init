package atelier3.model;


import java.util.LinkedList;
import java.util.List;

import atelier3.nutsAndBolts.PieceSquareColor;

public class PawnModel extends AbstractPieceModel implements PieceModel, Promotable{

	private Coord coord;
	private PieceSquareColor pieceColor;

	private int direction;
	
	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super(coord, pieceColor);
		this.coord = coord;
		this.pieceColor = pieceColor;
		this.direction = PieceSquareColor.BLACK.equals(this.getPieceColor()) ? -1 : 1;
	}

	@Override
	public char getColonne() {
		return coord.getColonne();
	}
	@Override
	public int getLigne() {
		return coord.getLigne();
	}
	@Override
	public boolean hasThisCoord(Coord coord) {
		return this.coord.equals(coord);
	}

	@Override
	public void move(Coord coord) {
		this.coord = coord; 
	}

	@Override
	public PieceSquareColor getPieceColor() {
		return pieceColor;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>(); 
		int initCol = this.getColonne();
		int initLig = this.getLigne();
		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int deltaLig = (int) Math.signum(ligDistance);
		int deltaCol = (int) Math.signum(colDistance);

		// V�rif d�placement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)){

			// recherche coordonn�es des cases travers�es
			for (int i = 1; i < Math.abs(colDistance); i++) {
				Coord coord = new Coord((char) (initCol + i*deltaCol), initLig + i*deltaLig);
				coordsOnItinery.add(coord);
			}
		}
		return coordsOnItinery;
	}


	
	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;

		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int deltaLig = (int) Math.signum(ligDistance);
		
		// Cas d'un d�placement en diagonale
		if (Math.abs(colDistance) == Math.abs(ligDistance)){
			
			// sans prise
			if (!isPieceToCapture) {
				if (deltaLig == this.direction && Math.abs(colDistance) == 1) {
					ret = true;
				}
			}
			// avec prise
			else {
				if (Math.abs(colDistance) == 2) {
					ret = true;
				}
			}
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " ["+pieceColor.toString().charAt(0) + coord + "]";
	}


	@Override
	public boolean isPromotable(){
		return direction == 1 && this.getLigne() == ModelConfig.LENGTH || direction == -1 && this.getLigne() == 1;
	}

	@Override
	public void promote(){
		throw new UnsupportedOperationException();
	}
}

