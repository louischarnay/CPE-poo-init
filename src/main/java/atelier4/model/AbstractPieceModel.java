package atelier3.model;

import atelier3.nutsAndBolts.PieceSquareColor;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractPieceModel implements PieceModel, Comparable<PieceModel>{

    private Coord coord;
    private PieceSquareColor pieceSquareColor;

    public AbstractPieceModel(Coord coord, PieceSquareColor pieceSquareColor){
        super();
        this.coord = coord;
        this.pieceSquareColor = pieceSquareColor;
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
        return pieceSquareColor;
    }

    @Override
    public abstract boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture);

    @Override
    public String toString() {
        return "AbstractPieceModel{" +
                "coord=" + coord +
                ", pieceSquareColor=" + pieceSquareColor +
                '}';
    }

    @Override
    public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

        List<Coord> coordsOnItinery = new LinkedList<>();
        int initCol = this.getColonne();
        int initLig = this.getLigne();
        int colDistance = targetCoord.getColonne() - this.getColonne();
        int ligDistance = targetCoord.getLigne() - this.getLigne();
        int deltaLig = (int) Math.signum(ligDistance);
        int deltaCol = (int) Math.signum(colDistance);

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
    public int compareTo(PieceModel pieceModel) {
        AbstractPieceModel ab = (AbstractPieceModel) pieceModel;
        return coord.compareTo(ab.coord);
    }
}
