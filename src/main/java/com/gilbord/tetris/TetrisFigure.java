package com.gilbord.tetris;

import java.awt.*;
import java.util.Random;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class TetrisFigure {
    private Color currentColor;
    private Color nextColor;
    private FigureType currentFigureType;
    private FigureType nextFigureType;
    private Coord currentFigure[];
    private Coord nextFigure[];
    private RotationMode rotationMode;

    public TetrisFigure() {
        this.currentColor = new Color(new Random().nextInt(200) + 20,
                new Random().nextInt(200) + 20,
                new Random().nextInt(200) + 20);
        this.nextColor = new Color(new Random().nextInt(200) + 20,
                new Random().nextInt(200) + 20,
                new Random().nextInt(200) + 20);
        this.currentFigureType = FigureType.getRandomFigureType();
        this.nextFigureType = FigureType.getRandomFigureType();
        this.rotationMode = RotationMode.NORMAL;
        this.currentFigure = new FormBuilder().generateFigure(new Coord(Constants.START_X, Constants.START_Y),
                this.currentFigureType,
                RotationMode.NORMAL);
        this.nextFigure = new FormBuilder().generateFigure(new Coord(Constants.NEXT_START_X, Constants.NEXT_START_Y),
                this.nextFigureType,
                RotationMode.NORMAL);
    }

    public void create() {
        this.rotationMode = RotationMode.NORMAL;
        this.currentColor = nextColor;
        this.nextColor = new Color(new Random().nextInt(200) + 20,
                new Random().nextInt(200) + 20,
                new Random().nextInt(200) + 20);
        this.currentFigureType = this.nextFigureType;
        this.nextFigureType = FigureType.getRandomFigureType();
        this.currentFigure = new FormBuilder().generateFigure(new Coord(Constants.START_X, Constants.START_Y),
                this.currentFigureType,
                RotationMode.NORMAL);
        this.nextFigure = new FormBuilder().generateFigure(new Coord(Constants.NEXT_START_X, Constants.NEXT_START_Y),
                this.nextFigureType,
                RotationMode.NORMAL);
    }

    public void fall() {
        for (Coord coord : currentFigure) {
            coord.setY(coord.getY() + 1);
        }
    }

    public void shift(Direction dir) {
        if (dir == Direction.LEFT) {
            for (Coord coord : currentFigure) {
                coord.setX(coord.getX() - 1);
            }
        } else if (dir == Direction.RIGHT) {
            for (Coord coord : currentFigure) {
                coord.setX(coord.getX() + 1);
            }
        }
    }

    public void rotate() {
        this.rotationMode = this.rotationMode.getNext(this.rotationMode);
        this.currentFigure = new FormBuilder().generateFigure(new Coord(currentFigure[0]),
                this.currentFigureType,
                this.rotationMode);
        System.out.println(rotationMode);
    }

    public Color getColor() {
        return currentColor;
    }

    public Coord[] getCoords() {
        return currentFigure;
    }

    public void draw(Graphics g) {
        if(this.currentFigure != null) {
            g.setColor(this.currentColor);
            for (Coord coords : currentFigure) {
                g.fill3DRect(coords.getX() * Constants.SIZE_OF_THE_CELL,
                        coords.getY() * Constants.SIZE_OF_THE_CELL - 4 * Constants.SIZE_OF_THE_CELL,
                        Constants.SIZE_OF_THE_CELL,
                        Constants.SIZE_OF_THE_CELL,
                        false);
            }
            g.setColor(this.nextColor);
            for (Coord coords : nextFigure) {
                g.fill3DRect(coords.getX() * Constants.SIZE_OF_THE_CELL,
                        coords.getY() * Constants.SIZE_OF_THE_CELL - 4 * Constants.SIZE_OF_THE_CELL,
                        Constants.SIZE_OF_THE_CELL,
                        Constants.SIZE_OF_THE_CELL,
                        false);
            }

            g.setColor(Color.BLACK);
        }
    }

    public Coord[] getRotationFigure() {
        return new FormBuilder().generateFigure(new Coord(currentFigure[0]),
                this.currentFigureType,
                this.rotationMode.getNext(this.rotationMode));
    }

}
