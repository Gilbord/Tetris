package com.gilbord.tetris;

import java.util.Random;

/**
 * Created by Gilbord on 13.07.2017.
 */
public enum FigureType {
    I_FORM, J_FORM, L_FORM, O_FORM, S_FORM, Z_FORM, T_FORM;

    private static FigureType[] figureTypes = {I_FORM, J_FORM, L_FORM, O_FORM, S_FORM, Z_FORM, T_FORM};

    public static FigureType getRandomFigureType(){
       return figureTypes[new Random().nextInt(figureTypes.length)];
    }
}
