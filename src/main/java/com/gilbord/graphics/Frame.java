package com.gilbord.graphics;

import com.gilbord.tetris.Constants;
import com.gilbord.tetris.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gilbord on 10.07.2017.
 */
public class Frame extends JFrame {

    PaintPanel paintPanel;
    public Frame() {
        super("Tetris");
    }

    public void GUI() {
        paintPanel = new PaintPanel();
        //paintPanel.setBorder(BorderFactory.createEtchedBorder());
        paintPanel.setBounds(0, 500, 800, 50);
        paintPanel.setLayout(null);
        getContentPane().add(paintPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void run() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame paintFrame = new Frame();
                paintFrame.GUI();
                paintFrame.pack();
                paintFrame.setVisible(true);
                paintFrame.setLocationRelativeTo(null);
                paintFrame.setMinimumSize(new Dimension(Constants.APP_WIDTH, Constants.APP_HEIGHT));
            }
        });
    }
}