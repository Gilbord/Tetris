package com.gilbord.tetris;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class Game {
    TetrisFigure figure;
    TetrisField theField;

    public Game(){
        this.figure = new TetrisFigure();
        this.theField = new TetrisField(Constants.NUM_OF_CELLS_X, Constants.NUM_OF_CELLS_Y);
        this.figure.create(new Coord(5, 3));
    }

    public void update(){

    }

    public TetrisFigure getFigure() {
        return figure;
    }

    public TetrisField getTheField() {
        return theField;
    }
}
