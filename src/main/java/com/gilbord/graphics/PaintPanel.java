package com.gilbord.graphics;

import com.gilbord.tetris.*;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Gilbord on 12.07.2017.
 */
public class PaintPanel extends JPanel {
    private Game game;
    private Label score;

    public PaintPanel(Game game) {
        this.score = new Label(Constants.SCORE_TEXT + game.getScore());

        this.score.setBounds(Constants.NUM_OF_CELLS_X * Constants.SIZE_OF_THE_CELL + Constants.SPACE_FOR_INFO_X,
                Constants.SPACE_FOR_INFO_Y,
                Constants.WIDTH_FOR_INFO,
                Constants.HEIGHT_FOR_INFO);

        this.add(score);
        this.game = game;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.draw3DRect(Constants.SPACE_FOR_NEXT_FIGURE_X + 120,
                Constants.SPACE_FOR_NEXT_FIGURE_Y,
                Constants.SIZE_OF_THE_CELL * 5,
                Constants.SIZE_OF_THE_CELL * 5,
                true);
        this.game.getTetrisFigure().draw(g);
        this.game.getTetrisField().draw(g);
        this.score.setText(Constants.SCORE_TEXT + game.getScore());
    }
}