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
    private boolean isGameOver = false;


    public Game() {
        tetrisFigure = new TetrisFigure();
        tetrisField = new TetrisField(Constants.NUM_OF_CELLS_X, Constants.NUM_OF_CELLS_Y);
        paintPanel = new PaintPanel(tetrisField, tetrisFigure);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
        paintPanel.setBackground(Color.white); // define the background color
        addKeyListener(new KeyListener(this));
        add(BorderLayout.CENTER, paintPanel);
        setVisible(true);
    }

    public void start() {
        while (!isGameOver) {
            try {
                Thread.sleep(Constants.DELAY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            tetrisField.update();
            paintPanel.repaint();
            if (!tetrisField.canFall(tetrisFigure)) {
                tetrisField.addFigure(tetrisFigure);
                tetrisFigure = new TetrisFigure();
                if(!tetrisField.canFall(tetrisFigure)){
                    isGameOver = true;
                    System.out.println("Game over");
                }
                paintPanel.setTetrisFigure(tetrisFigure);
                //gameOver = figure.isCrossGround(); // Is there space for a new figure?
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
}