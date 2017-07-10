package com.gilbord.graphics;

import com.gilbord.tetris.Constants;
import com.gilbord.tetris.Coord;

import java.awt.*;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class GraphicsFigure {
    Color color;
    Coord figure[];

    public GraphicsFigure(Coord figure[], Color color){
        this.figure = figure;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        for(Coord coords : figure) {
            g.fillRect(coords.getX() * Constants.SIZE_OF_THE_CELL, coords.getY() * Constants.SIZE_OF_THE_CELL, Constants.SIZE_OF_THE_CELL, Constants.SIZE_OF_THE_CELL);
        }
        g.setColor(Color.BLACK);
    }
}
