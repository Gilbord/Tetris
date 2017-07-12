package com.gilbord.tetris;

import java.awt.*;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class TetrisField {
    int sizeX;
    int sizeY;
    Color theField[][];

    public TetrisField(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        theField = new Color[this.sizeX][this.sizeY];
        for (int y = 0; y < this.sizeY; y++) {
            for (int x = 0; x < this.sizeX; x++) {
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

    public Color getColor(Coord coord) {
        return theField[coord.getX()][coord.getY()];
    }

    public void drawCell(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.drawRect(x, y, Constants.SIZE_OF_THE_CELL, Constants.SIZE_OF_THE_CELL);
        g.setColor(Color.BLACK);
    }

    public void fillCell(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, Constants.SIZE_OF_THE_CELL, Constants.SIZE_OF_THE_CELL);
        g.setColor(Constants.THE_FIELD_EMPTY_COLOR);
        g.drawRect(x, y, Constants.SIZE_OF_THE_CELL, Constants.SIZE_OF_THE_CELL);
        g.setColor(Constants.THE_FIELD_EMPTY_COLOR);
    }

    public void draw(Graphics g) {
        for (int y = 4; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if (theField[x][y] == Constants.THE_FIELD_EMPTY_COLOR) {
                    drawCell(g, x * Constants.SIZE_OF_THE_CELL, y * Constants.SIZE_OF_THE_CELL - 4 * Constants.SIZE_OF_THE_CELL, theField[x][y]);
                } else {
                    fillCell(g, x * Constants.SIZE_OF_THE_CELL, y * Constants.SIZE_OF_THE_CELL - 4 * Constants.SIZE_OF_THE_CELL, theField[x][y]);
                }
            }
        }
        /*g.draw3DRect(0, 0, Constants.NUM_OF_CELLS_X * Constants.SIZE_OF_THE_CELL,
                Constants.NUM_OF_CELLS_Y * Constants.SIZE_OF_THE_CELL, true);*/
    }

    public boolean crossTheWall(Coord coords) {
        return coords.getX() < 0 || coords.getX() > Constants.NUM_OF_CELLS_X;
    }

    public boolean crossTheFloor(Coord coords) {
        return coords.getY() >= Constants.NUM_OF_CELLS_Y;
    }

    public boolean isEmpty(Coord coords) {
        return theField[coords.getX()][coords.getY()] == Constants.THE_FIELD_EMPTY_COLOR;
    }

    public boolean canFall(TetrisFigure tetrisFigure) {
        Coord bottom = tetrisFigure.getBottomCell();
        if (crossTheFloor(new Coord(bottom.getX(), bottom.getY() + 1))
                || !isEmpty(new Coord(bottom.getX(), bottom.getY() + 1))) {
            return false;
        }
        return true;
    }

    public boolean canShift(TetrisFigure tetrisFigure, Direction dir) {
        Coord side;
        switch (dir) {
            case LEFT:
                side = tetrisFigure.getSideCell(Direction.LEFT);
                break;
            default:
                side = tetrisFigure.getSideCell(Direction.RIGHT);
                break;
        }
        if(dir == Direction.LEFT) {
            if (crossTheWall(new Coord(side.getX() - 1, side.getY()))
                    || !isEmpty(new Coord(side.getX() - 1, side.getY()))) {
                return false;
            }
        }else{
            if (crossTheWall(new Coord(side.getX() + 1, side.getY()))
                    || !isEmpty(new Coord(side.getX() + 1, side.getY()))) {
                return false;
            }
        }
        return true;
    }


    public void addFigure(TetrisFigure tetrisFigure) {
        for (Coord coords : tetrisFigure.getCoords()) {
            theField[coords.getX()][coords.getY()] = tetrisFigure.getColor();
        }
    }
}
