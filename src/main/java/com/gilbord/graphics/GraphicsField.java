package com.gilbord.graphics;

import com.gilbord.tetris.Constants;
import com.gilbord.tetris.TetrisField;

import java.awt.*;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class GraphicsField {
    int sizeX;
    int sizeY;
    Color theField[][];

    public GraphicsField(TetrisField theField){
        this.sizeX = theField.getSizeX();
        this.sizeY = theField.getSizeY();
        this.theField = theField.getTheField();
        System.out.println(this.sizeX + " " + this.sizeY);
    }

    public void drawCell(Graphics g, int x, int y, Color color){
        g.setColor(color);
        g.drawRect(x, y, Constants.SIZE_OF_THE_CELL, Constants.SIZE_OF_THE_CELL);
        g.setColor(Color.BLACK);
    }

    public void draw(Graphics g){
        for(int y = 4; y < sizeY; y++){
            for(int x = 0; x < sizeX; x++){
                drawCell(g, x * Constants.SIZE_OF_THE_CELL, y * Constants.SIZE_OF_THE_CELL - 4 * Constants.SIZE_OF_THE_CELL, theField[x][y]);
            }
        }
    }
}
