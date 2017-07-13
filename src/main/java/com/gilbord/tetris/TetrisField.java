package com.gilbord.tetris;

import java.awt.*;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class TetrisField {
    int sizeX;
    int sizeY;
    Color theField[][];
    int score;
    private int numOfFillCells[];

    public TetrisField(int sizeX, int sizeY) {
        score = 0;
        numOfFillCells = new int[Constants.NUM_OF_CELLS_Y];
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
        //g.drawRect(x, y, Constants.SIZE_OF_THE_CELL, Constants.SIZE_OF_THE_CELL);
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
        g.draw3DRect(0, 0, Constants.NUM_OF_CELLS_X * Constants.SIZE_OF_THE_CELL,
                Constants.NUM_OF_CELLS_Y * Constants.SIZE_OF_THE_CELL - Constants.NUM_OF_HIDEN_Y * Constants.SIZE_OF_THE_CELL, true);
    }

    public boolean crossTheWall(Coord coords) {
        return coords.getX() < 0 || coords.getX() > Constants.NUM_OF_CELLS_X - 1;
    }

    public boolean crossTheFloor(Coord coords) {
        return coords.getY() >= Constants.NUM_OF_CELLS_Y;
    }

    public boolean isEmpty(Coord coords) {
        return theField[coords.getX()][coords.getY()] == Constants.THE_FIELD_EMPTY_COLOR;
    }

    public boolean canFall(TetrisFigure tetrisFigure) {
        for (Coord coords : tetrisFigure.getCoords()) {
            if (crossTheFloor(new Coord(coords.getX(), coords.getY() + 1))
                    || !isEmpty(new Coord(coords.getX(), coords.getY() + 1))) {
                return false;
            }
        }
        return true;
    }

    public boolean canShift(TetrisFigure tetrisFigure, Direction dir) {
        switch (dir) {
            case LEFT: {
                for (Coord coords : tetrisFigure.getCoords()) {
                    if (crossTheWall(new Coord(coords.getX() - 1, coords.getY()))
                            || !isEmpty(new Coord(coords.getX() - 1, coords.getY()))) {
                        return false;
                    }
                }
                break;
            }
            case RIGHT: {
                for (Coord coords : tetrisFigure.getCoords()) {
                    if (crossTheWall(new Coord(coords.getX() + 1, coords.getY() + 1))
                            || !isEmpty(new Coord(coords.getX() + 1, coords.getY()))) {
                        return false;
                    }
                }
                break;
            }
        }
        return true;
    }

    public void update() {
        for (int y = 0; y < sizeY; y++) {
            int current = 0;
            for (int x = 0; x < sizeX; x++) {
                if (theField[x][y] != Constants.THE_FIELD_EMPTY_COLOR) {
                    current++;
                }
            }
            numOfFillCells[y] = current;
        }
        for (int i = 0; i < numOfFillCells.length; i++) {
            if (numOfFillCells[i] == Constants.NUM_OF_CELLS_X) {
                deleteLine(i);
                fallLines(i);
                score += Constants.POINTS_FOR_SCORE;
            }
        }
    }

    public int isFilled(Color color) {
        if (color == Constants.THE_FIELD_EMPTY_COLOR) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean canRotate(TetrisFigure tetrisFigure) {
        for (Coord coords : tetrisFigure.getRotationFigure()) {
            if (crossTheFloor(coords)
                    || crossTheWall(coords)
                    || !isEmpty(coords)) {
                return false;
            }
        }
        return true;
    }

    public void deleteLine(int line) {
        for (int x = 0; x < Constants.NUM_OF_CELLS_X; x++) {
            theField[x][line] = Constants.THE_FIELD_EMPTY_COLOR;
        }
        numOfFillCells[line] = 0;
    }

    public void fallLines(int line) {
        for (int y = line; y > 0; y--) {
            if (numOfFillCells[y - 1] > 0) {
                for (int x = 0; x < this.sizeX; x++) {

                    theField[x][y] = theField[x][y - 1];
                    theField[x][y - 1] = Constants.THE_FIELD_EMPTY_COLOR;
                }
                numOfFillCells[y] = numOfFillCells[y - 1];
                numOfFillCells[y - 1] = 0;
            }
        }

    }

    public void addFigure(TetrisFigure tetrisFigure) {
        for (Coord coords : tetrisFigure.getCoords()) {
            theField[coords.getX()][coords.getY()] = tetrisFigure.getColor();
        }

    }

    public int getScore() {
        return score;
    }
}
