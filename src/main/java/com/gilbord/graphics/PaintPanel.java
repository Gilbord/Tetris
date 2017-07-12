package com.gilbord.graphics;

import com.gilbord.tetris.TetrisField;
import com.gilbord.tetris.TetrisFigure;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gilbord on 12.07.2017.
 */
public class PaintPanel extends JPanel {
    private TetrisField tetrisField;
    private TetrisFigure tetrisFigure;

    public PaintPanel(TetrisField tetrisField, TetrisFigure tetrisFigure) {
        this.tetrisField = tetrisField;
        this.tetrisFigure = tetrisFigure;
    }

    public void setTetrisField(TetrisField tetrisField) {
        this.tetrisField = tetrisField;
    }

    public void setTetrisFigure(TetrisFigure tetrisFigure) {
        this.tetrisFigure = tetrisFigure;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        tetrisFigure.draw(g);
        tetrisField.draw(g);

    }
}