package sk.matus.snake;

import sk.matus.snake.enums.DirectionSnake;
import sk.matus.snake.objects.Point;
import sk.matus.snake.objects.Snake;

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

    private Snake snake;
    private Point point;

    private boolean horizontMoveActive = false;
    private boolean verticalMoveActive = false;

    public GamePlay() {
        int delay = 150;
        snake = new Snake();
        point = new Point();
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
        snake.snakePaint(g);
        point.pointPaint(g);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        yPositionMove = yPositionMove + 5;
        snake.snakeMove();
        snake.pointPosition(point.getPointX(),point.getPointY());
        point.snakePosition(snake.getSnakeX(),snake.getSnakeY());
        requestFocus();
        timer.start();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP && !verticalMoveActive) {
            snake.direction(DirectionSnake.UP);
            verticalMoveActive = true;
            horizontMoveActive = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN && !verticalMoveActive){
            snake.direction(DirectionSnake.DOWN);
            verticalMoveActive = true;
            horizontMoveActive = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && !horizontMoveActive){
            snake.direction(DirectionSnake.LEFT);
            horizontMoveActive = true;
            verticalMoveActive = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && !horizontMoveActive){
            snake.direction(DirectionSnake.RIGHT);
            horizontMoveActive = true;
            verticalMoveActive = false;
        }

    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
}
