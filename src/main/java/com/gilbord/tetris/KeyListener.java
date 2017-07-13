package com.gilbord.tetris;

import java.awt.event.KeyEvent;

/**
 * Created by Gilbord on 13.07.2017.
 */
public class KeyListener implements java.awt.event.KeyListener {
    Game game;

    public KeyListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!game.isGameOver()) {
            if (e.getKeyCode() == Constants.DOWN_KEY_CODE){
                game.setDelay(20);
            }
            if (e.getKeyCode() == Constants.UP_KEY_CODE) {
                if (game.getTetrisField().canRotate(game.getTetrisFigure()))
                    game.getTetrisFigure().rotate();
            }
            if (e.getKeyCode() == Constants.LEFT_KEY_CODE) {
                if (game.getTetrisField().canShift(game.getTetrisFigure(), Direction.LEFT)) {
                    game.getTetrisFigure().shift(Direction.LEFT);

                }
            }
            if (e.getKeyCode() == Constants.RIGHT_KEY_CODE) {
                if (game.getTetrisField().canShift(game.getTetrisFigure(), Direction.RIGHT)) {
                    game.getTetrisFigure().shift(Direction.RIGHT);
                }
            }
            game.getPaintPanel().repaint();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (!game.isGameOver()) {
            if (e.getKeyCode() == Constants.DOWN_KEY_CODE) {
                game.setDelay(Constants.DELAY);
            }
        }
    }
}
