package atelier4.controller;

import java.io.Serializable;

import atelier4.nutsAndBolts.PieceSquareColor;

/**
 * @author francoise.perrin
 * 
 * Objet cr�� par le Model dans m�thode MoveCapturePromote()
 * � destination du Controller qui en extrait les donn�es pour cr�er
 * l'objet InputViewModel � destination de la View
 * 
 */
public class OutputModelData<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public boolean isMoveDone = false;
	public T capturedPieceCoord = null;
	public T promotedPieceCoord = null;
	public PieceSquareColor promotedPieceColor = null;
	public int scoreWhite = 0;
	public int scoreBlack = 0;
	
	
	public OutputModelData(
			boolean isMoveDone, 
			T capturedPieceCoord,
			T promotedPieceCoord,
			PieceSquareColor promotedPieceColor,
			int scoreWhite,
			int scoreBlack) {
		super();
		this.isMoveDone = isMoveDone;
		this.capturedPieceCoord = capturedPieceCoord;
		this.promotedPieceCoord = promotedPieceCoord;
		this.promotedPieceColor = promotedPieceColor;
		this.scoreWhite =scoreWhite;
		this.scoreBlack = scoreBlack;
	}


	@Override
	public String toString() {
		return "DataAfterMove [isMoveDone=" + isMoveDone + ", capturedPieceIndex=" + capturedPieceCoord
				+ ", promotedPieceIndex=" + promotedPieceCoord + ", promotedPieceColor=" + promotedPieceColor + "]";
	}


	

	
}
