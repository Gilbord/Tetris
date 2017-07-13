package com.gilbord.tetris;

/**
 * Created by Gilbord on 13.07.2017.
 */
public enum RotationMode {
    NORMAL(0), FLIP_CW(1), INVERT(2), FLIP_CCW(3);
    int value;

    private RotationMode(int mode) {
        this.value = mode;
    }

    private int getValue() {
        return value;
    }

    private static RotationMode rotationMode[] = {NORMAL, FLIP_CW, INVERT, FLIP_CCW};

    public RotationMode getNext(RotationMode current) {
        return rotationMode[(current.getValue() + 1) % rotationMode.length];
    }
}
