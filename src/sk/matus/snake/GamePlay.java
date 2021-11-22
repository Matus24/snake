package sk.matus.snake;

import sk.matus.snake.enums.DirectionSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private final Timer timer;
    private int xPositionMove = 0;
    private int yPositionMove = 0;
    private DirectionSnake directionSnake = DirectionSnake.UP;
    private boolean left = false;
    private boolean right = false;

    public GamePlay() {
        int delay = 6;
        timer = new Timer(delay,this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    int i = 0;
    public void paint(Graphics g){

        g.setColor(Color.black);
        g.fillRect(0,0,600,600);
        g.setColor(Color.green);
        g.fillRect(200-xPositionMove,500-yPositionMove,20,20);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        yPositionMove = yPositionMove + 5;
        requestFocus();
        timer.start();
        repaint();
        System.out.println(directionSnake);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_KP_UP) {
            directionSnake = DirectionSnake.UP;
        }
        if(e.getKeyCode() == KeyEvent.VK_KP_DOWN){
            directionSnake = DirectionSnake.DOWN;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            directionSnake = DirectionSnake.LEFT;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            directionSnake = DirectionSnake.RIGHT;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
