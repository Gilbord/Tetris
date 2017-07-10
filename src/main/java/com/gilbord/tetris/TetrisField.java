package com.gilbord.tetris;

import java.awt.*;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class TetrisField {
    int sizeX;
    int sizeY;
    Color theField[][];

    public TetrisField(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        theField = new Color[this.sizeX][this.sizeY];
        for(int y = 0; y < this.sizeY; y++){
            for(int x = 0; x < this.sizeX; x++){
                theField[x][y] = Constants.THE_FIELD_EMPTY_COLOR;
            }
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Color[][] getTheField() {
        return theField;
    }

    public boolean isEmpty(Coord coord){
        if(theField[coord.getX()][coord.getY()] == Constants.THE_FIELD_EMPTY_COLOR){
            return true;
        }
        return false;
    }
}
