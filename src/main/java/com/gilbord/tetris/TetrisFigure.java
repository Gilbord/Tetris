package com.gilbord.tetris;

import java.awt.*;
import java.util.Random;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class TetrisFigure {
    Color color;
    Coord figure[];

    public TetrisFigure() {
        Random rnd = new Random();
        color = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
        figure = create(new Coord(3, 0)); //<--CHANGE A MAGIC NUMBERS!
    }

    public Coord[] create(Coord start) {
        Coord newFigure[] = new Coord[4];
        newFigure[0] = start;
        newFigure[1] = new Coord(start.getX(), start.getY() + 1);
        newFigure[2] = new Coord(start.getX(), start.getY() + 2);
        newFigure[3] = new Coord(start.getX(), start.getY() + 3);
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
            System.out.println(getBottomCell().getY());
        }

        g.setColor(Color.BLACK);
    }
}
