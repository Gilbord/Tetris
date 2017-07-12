package com.gilbord.tetris;

import com.gilbord.graphics.PaintPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class Game extends JFrame {
    private TetrisFigure tetrisFigure;
    private TetrisField tetrisField;
    private PaintPanel paintPanel;
    private final int SHOW_DELAY = 400;
    final int LEFT = 37; // key codes
    final int UP = 38;
    final int RIGHT = 39;
    final int DOWN = 40;


    public Game() {
        tetrisFigure = new TetrisFigure();
        tetrisField = new TetrisField(Constants.NUM_OF_CELLS_X, Constants.NUM_OF_CELLS_Y);
        paintPanel = new PaintPanel(tetrisField, tetrisFigure);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        paintPanel.setBackground(Color.white); // define the background color
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // if (!gameOver) {
                //if (e.getKeyCode() == DOWN) tetrisFigure.drop();
                //if (e.getKeyCode() == UP) figure.rotate();
                if (e.getKeyCode() == LEFT){
                    if(tetrisField.canShift(tetrisFigure, Direction.LEFT)){
                        tetrisFigure.shift(Direction.LEFT);
                    }
                }
                if (e.getKeyCode() == RIGHT){
                    if(tetrisField.canShift(tetrisFigure, Direction.RIGHT)){
                        tetrisFigure.shift(Direction.RIGHT);
                    }
                }
                // }*/
                paintPanel.repaint();
            }
        });
        add(BorderLayout.CENTER, paintPanel);
        setVisible(true);
    }

    void go() {
        while (true) {
            try {
                Thread.sleep(SHOW_DELAY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            paintPanel.repaint();
            //checkFilling();
            if (!tetrisField.canFall(tetrisFigure)) {
                tetrisField.addFigure(tetrisFigure);
                tetrisFigure = new TetrisFigure();
                paintPanel.setTetrisFigure(tetrisFigure);
                //gameOver = figure.isCrossGround(); // Is there space for a new figure?
            } else
                tetrisFigure.fall();
        }
    }
}