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
    private boolean isGameOver;
    private int delay;


    public Game() {
        delay = Constants.DELAY;
        tetrisField = new TetrisField(Constants.NUM_OF_CELLS_X, Constants.NUM_OF_CELLS_Y);
        paintPanel = new PaintPanel(this);
        paintPanel.setLayout(null);
        isGameOver = false;
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        paintPanel.setBackground(Constants.THE_COLOR_OF_GAME_FIELD);
        addKeyListener(new KeyListener(this));
        add(paintPanel);
        setVisible(true);
    }

    public void start() {
        tetrisFigure = new TetrisFigure();
        while (!isGameOver) {
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
            tetrisField.update();
            paintPanel.repaint();
            if (!tetrisField.canFall(tetrisFigure)) {
                tetrisField.addFigure(tetrisFigure);
                tetrisFigure.create();
                delay = Constants.DELAY;
                if(!tetrisField.canFall(tetrisFigure)){
                    isGameOver = true;
                }
            } else
                tetrisFigure.fall();
        }
    }

    public TetrisFigure getTetrisFigure() {
        return tetrisFigure;
    }

    public TetrisField getTetrisField() {
        return tetrisField;
    }

    public PaintPanel getPaintPanel() {
        return paintPanel;
    }

    public boolean isGameOver(){
        return isGameOver;
    }

    public int getScore() {
        return tetrisField.getScore();
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

}