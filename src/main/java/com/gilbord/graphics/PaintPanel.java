package com.gilbord.graphics;

import com.gilbord.tetris.Constants;
import com.gilbord.tetris.Coord;
import com.gilbord.tetris.TetrisField;
import com.gilbord.tetris.TetrisFigure;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class PaintPanel extends JPanel {
    GraphicsField theField;
    GraphicsFigure figure;

    PaintPanel(){
        theField = new GraphicsField(new TetrisField(Constants.NUM_OF_CELLS_X, Constants.NUM_OF_CELLS_Y));
        figure = new GraphicsFigure(new TetrisFigure().create(new Coord(5, 4)), Color.BLUE);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        figure.draw(g);
        theField.draw(g);

    }
}
