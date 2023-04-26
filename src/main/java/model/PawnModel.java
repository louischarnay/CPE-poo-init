package model;


import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel{

	private Coord coord;
	private PieceSquareColor pieceColor;

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();
		this.coord = coord;
		this.pieceColor = pieceColor;
	}

	@Override
	public char getColonne() {
		return this.coord.getColonne();
	}

	@Override
	public int getLigne() {
		return this.coord.getLigne();
	}

	@Override
	public boolean hasThisCoord(Coord coord) {
		return this.coord.equals(coord);
	}

	@Override
	public PieceSquareColor getPieceColor() {
		return this.pieceColor;
	}

	@Override
	public String toString() {
		return "PawnModel{" +
				"coord=" + coord +
				", pieceColor=" + pieceColor +
				'}';
	}

	@Override
	public void move(Coord coord) {
		this.coord = coord;
	}

	/**
	 * return -1 if the piece is black, 1 else
	 * @return -1 or 1
	 */
	private int getFacing(){
		return this.pieceColor == PieceSquareColor.BLACK ? -1 : 1;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {

		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();
		int deltaLig = (int) Math.signum(ligDistance);

		if (Math.abs(colDistance) == Math.abs(ligDistance)){
			if (!isPieceToCapture) {
				return deltaLig == this.getFacing() && Math.abs(colDistance) == 1;
			} else {
				return Math.abs(colDistance) == 2;
			}
		}
		return false;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {
		List<Coord> coordsOnItinery = new LinkedList<>();

		int initCol = this.getColonne();
		int initLig = this.getLigne();

		int colDistance = targetCoord.getColonne() - this.getColonne();
		int ligDistance = targetCoord.getLigne() - this.getLigne();

		int deltaLig = Math.round(Math.signum(ligDistance));
		int deltaCol = Math.round(Math.signum(colDistance));


		if (Math.abs(colDistance) == Math.abs(ligDistance)){
			for (int i = 1; i < Math.abs(colDistance); i++) {
				Coord coordIt = new Coord((char)(initCol + i*deltaCol), initLig + i*deltaLig);
				coordsOnItinery.add(coordIt);
			}
		}

		return coordsOnItinery;
	}

	
}

