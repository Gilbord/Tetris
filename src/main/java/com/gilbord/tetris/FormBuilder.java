package com.gilbord.tetris;

/**
 * Created by Gilbord on 13.07.2017.
 */
public class FormBuilder {
    public Coord[] generateFigure(Coord start, FigureType type, RotationMode rotation) {
        Coord newFigure[] = new Coord[4];
        switch (type) {
            case I_FORM: {
                switch (rotation) {
                    case NORMAL:
                    case INVERT:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[2] = new Coord(start.getX(), start.getY() - 2);
                        newFigure[3] = new Coord(start.getX(), start.getY() - 3);
                        break;
                    case FLIP_CCW:
                    case FLIP_CW:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() + 1, start.getY());
                        newFigure[2] = new Coord(start.getX() + 2, start.getY());
                        newFigure[3] = new Coord(start.getX() + 3, start.getY());
                        break;
                }
                return newFigure;
            }
            case J_FORM: {
                switch (rotation) {
                    case NORMAL:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() + 1, start.getY());
                        newFigure[2] = new Coord(start.getX() + 2, start.getY());
                        newFigure[3] = new Coord(start.getX(), start.getY() - 1);
                        break;
                    case INVERT:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[2] = new Coord(start.getX() - 1, start.getY() - 1);
                        newFigure[3] = new Coord(start.getX() - 2, start.getY() - 1);
                        break;
                    case FLIP_CCW:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() + 1, start.getY());
                        newFigure[2] = new Coord(start.getX() + 1, start.getY() - 1);
                        newFigure[3] = new Coord(start.getX() + 1, start.getY() - 2);
                        break;
                    case FLIP_CW:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[2] = new Coord(start.getX(), start.getY() - 2);
                        newFigure[3] = new Coord(start.getX() + 1, start.getY() - 2);
                        break;

                }
                return newFigure;
            }
            case L_FORM: {
                switch (rotation) {
                    case NORMAL:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() + 1, start.getY());
                        newFigure[2] = new Coord(start.getX() + 2, start.getY());
                        newFigure[3] = new Coord(start.getX() + 2, start.getY() - 1);
                        break;
                    case INVERT:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[2] = new Coord(start.getX() + 1, start.getY() - 1);
                        newFigure[3] = new Coord(start.getX() + 2, start.getY() - 1);
                        break;
                    case FLIP_CCW:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[2] = new Coord(start.getX(), start.getY() - 2);
                        newFigure[3] = new Coord(start.getX() - 1, start.getY() - 2);
                        break;
                    case FLIP_CW:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() + 1, start.getY());
                        newFigure[2] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[3] = new Coord(start.getX(), start.getY() - 2);
                        break;
                }
                return newFigure;
            }
            case O_FORM: {
                newFigure[0] = start;
                newFigure[1] = new Coord(start.getX(), start.getY() - 1);
                newFigure[2] = new Coord(start.getX() + 1, start.getY() - 1);
                newFigure[3] = new Coord(start.getX() + 1, start.getY());
                return newFigure;
            }
            case S_FORM: {
                switch (rotation) {
                    case NORMAL:
                    case INVERT:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() + 1, start.getY());
                        newFigure[2] = new Coord(start.getX() + 1, start.getY() - 1);
                        newFigure[3] = new Coord(start.getX() + 2, start.getY() - 1);
                        break;
                    case FLIP_CCW:
                    case FLIP_CW:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[2] = new Coord(start.getX() - 1, start.getY() - 1);
                        newFigure[3] = new Coord(start.getX() - 1, start.getY() - 2);
                        break;
                }
                return newFigure;
            }
            case T_FORM: {
                switch (rotation) {
                    case NORMAL:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() + 1, start.getY());
                        newFigure[2] = new Coord(start.getX() + 2, start.getY());
                        newFigure[3] = new Coord(start.getX() + 1, start.getY() - 1);
                        break;
                    case INVERT:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() - 1, start.getY() - 1);
                        newFigure[2] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[3] = new Coord(start.getX() + 1, start.getY() - 1);
                        break;
                    case FLIP_CCW:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() - 1, start.getY() - 1);
                        newFigure[2] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[3] = new Coord(start.getX(), start.getY() - 2);
                        break;
                    case FLIP_CW:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[2] = new Coord(start.getX() + 1, start.getY() - 1);
                        newFigure[3] = new Coord(start.getX(), start.getY() - 2);
                        break;
                }
                return newFigure;
            }
            default: {
                switch (rotation) {
                    case NORMAL:
                    case INVERT:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX() + 1, start.getY());
                        newFigure[2] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[3] = new Coord(start.getX() - 1, start.getY() - 1);
                        break;
                    case FLIP_CCW:
                    case FLIP_CW:
                        newFigure[0] = start;
                        newFigure[1] = new Coord(start.getX(), start.getY() - 1);
                        newFigure[2] = new Coord(start.getX() + 1, start.getY() - 1);
                        newFigure[3] = new Coord(start.getX() + 1, start.getY() - 2);
                        break;
                }
                return newFigure;
            }
        }
    }
}
