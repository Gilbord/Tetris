package com.gilbord.tetris;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class Coord {
    int x;
    int y;

    public Coord(){

    }

    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coord(Coord coord){
        this.x = coord.getX();
        this.y = coord.getY();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
