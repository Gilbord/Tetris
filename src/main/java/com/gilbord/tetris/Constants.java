package com.gilbord.tetris;

import java.awt.*;

/**
 * Created by Gilbord on 07.07.2017.
 */

public class Constants {
    public static final int APP_WIDTH = 420;
    public static final int APP_HEIGHT = 700;
    public static final int SIZE_OF_THE_CELL = 25;
    public static final int NUM_OF_CELLS_X = 10;
    public static final int NUM_OF_CELLS_Y = 30;
    public static final Color THE_FIELD_EMPTY_COLOR = Color.BLACK;
    public static final Color THE_COLOR_OF_GAME_FIELD = Color.WHITE;
    public static final int NUM_OF_HIDEN_Y = 4;
    public static final int DELAY = 500;
    public static final int LEFT_KEY_CODE = 37;
    public static final int UP_KEY_CODE = 38;
    public static final int RIGHT_KEY_CODE = 39;
    public static final int DOWN_KEY_CODE = 40;
    public static final int START_X = NUM_OF_CELLS_X / 2;
    public static final int START_Y = NUM_OF_HIDEN_Y - 1;
    public static final int NEXT_START_X = NUM_OF_CELLS_X + 2;
    public static final int NEXT_START_Y = 8;
    public static final String SCORE_TEXT = "YOUR SCORE IS ";
    public static final int SPACE_FOR_INFO_X = 20;
    public static final int SPACE_FOR_INFO_Y = SIZE_OF_THE_CELL * 5 + 5;
    public static final int SPACE_FOR_NEXT_FIGURE_X = (NUM_OF_CELLS_X - 5) * SIZE_OF_THE_CELL + 20;
    public static final int SPACE_FOR_NEXT_FIGURE_Y = 0;
    public static final int WIDTH_FOR_INFO = 200;
    public static final int HEIGHT_FOR_INFO = 50;
    public static final int POINTS_FOR_SCORE = 300;

}
