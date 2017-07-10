package com.gilbord.tetris;

import java.awt.*;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class TetrisFigure {
    Color color;
    Coord figure[];

    public TetrisFigure(){
        color = Color.BLUE;
        figure = new Coord[4];
    }

    public Coord[] create(Coord start){
        figure[0] = start;
        figure[1] = new Coord(start.getX(), start.getY() - 1);
        figure[2] = new Coord(start.getX(), start.getY() - 2);
        figure[3] = new Coord(start.getX(), start.getY() - 3);
        return figure;
    }

}
