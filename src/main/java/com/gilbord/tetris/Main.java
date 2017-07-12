package com.gilbord.tetris;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class Main {


    public static void main(String[] args) {
        System.out.println(new TetrisField(2, 3).crossTheFloor(new Coord(5, 14)));
        System.out.println(new TetrisField(2, 3).crossTheFloor(new Coord(5, 15)));
        System.out.println(new TetrisField(2, 3).crossTheFloor(new Coord(5, 16)));
        System.out.println(new TetrisField(2, 3).crossTheFloor(new Coord(5, 17)));
        new Game().go();
    }

}
