package com.gilbord.tetris;

import java.awt.*;
import java.util.Random;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class TetrisFigure {
    private Color color;
    private Coord figure[];
    private final int matrixSize = 4;
    private int matrix[][] = {
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
    };

    public TetrisFigure() {
        Random rnd = new Random();
        color = new Color(rnd.nextInt(254) + 1, rnd.nextInt(254) + 1, rnd.nextInt(254) + 1);
        figure = create(new Coord(3, 3)); //<--CHANGE A MAGIC NUMBERS!
    }

    public Coord[] create(Coord start) {
        Coord newFigure[] = new Coord[4];
        newFigure[0] = start;
        newFigure[1] = new Coord(start.getX(), start.getY() - 1);
        newFigure[2] = new Coord(start.getX(), start.getY() - 2);
        newFigure[3] = new Coord(start.getX(), start.getY() - 3);
        return newFigure;
    }

    public void fall() {
        for (Coord coord : figure) {
            coord.setY(coord.getY() + 1);
        }
    }

    public void shift(Direction dir) {
        if (dir == Direction.LEFT) {
            for (Coord coord : figure) {
                coord.setX(coord.getX() - 1);
            }
        } else if (dir == Direction.RIGHT) {
            for (Coord coord : figure) {
                coord.setX(coord.getX() + 1);
            }
        }
    }

    public Coord getBottomCell() {
        Coord bottom = figure[0];
        for (Coord coords : figure) {
            if (coords.getY() > bottom.getY()) {
                bottom = coords;
            }
        }
        return bottom;
    }

    public Coord getSideCell(Direction dir) {
        Coord side = figure[0];
        if (dir == Direction.LEFT) {
            for (Coord coords : figure) {
                if (coords.getX() < side.getX()) {
                    side = coords;
                }
            }
        } else {
            for (Coord coords : figure) {
                if (coords.getX() > side.getY()) {
                    side = coords;
                }
            }

        }
        return side;
    }

    public void rotate(){
        rotateMatrix();
        figure = generateFigure();
    }

    public void rotateMatrix() {
        for (int i = 0; i < matrixSize / 2; i++) {
            for (int j = i; j < matrixSize - 1 - i; j++) { // left -> right
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][matrixSize - 1 - i];
                matrix[j][matrixSize - 1 - i] = matrix[matrixSize - 1 - i][matrixSize - 1 - j];
                matrix[matrixSize - 1 - i][matrixSize - 1 - j] = matrix[matrixSize - 1 - j][i];
                matrix[matrixSize - 1 - j][i] = tmp;
            }
        }

        for (int i = 0; i < matrixSize ; i++) {
            for (int j = 0; j < matrixSize ; j++) { // left -> right
               System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Coord[] generateFigure() {
        Coord newFigure[] = new Coord[4];
        Coord startPoint = new Coord();
        newFigure[0] = figure[0];

        int countOfPoints = 0;
        for (int y = matrixSize - 1; y >= 0; y--) {
            for (int x = 0; x < matrixSize; x++) {
                if (matrix[x][y] == 1) {
                    if ((++countOfPoints) == 1) {
                        startPoint = new Coord(x, y);
                    } else {
                        newFigure[countOfPoints - 1] = new Coord(newFigure[0].getX() + x - startPoint.getX(), newFigure[0].getY() + y - startPoint.getY());
                    }

                }
            }
        }
        return newFigure;
    }

    public Color getColor() {
        return color;
    }

    public Coord[] getCoords() {
        return figure;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        for (Coord coords : figure) {
            g.fill3DRect(coords.getX() * Constants.SIZE_OF_THE_CELL,
                    coords.getY() * Constants.SIZE_OF_THE_CELL - 4 * Constants.SIZE_OF_THE_CELL,
                    Constants.SIZE_OF_THE_CELL,
                    Constants.SIZE_OF_THE_CELL,
                    false);
        }
        for(Coord coords : figure) {
            System.out.println(coords.toString());
        }

        g.setColor(Color.BLACK);
    }
}
