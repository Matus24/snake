package sk.matus.snake.objects;

import sk.matus.snake.enums.DirectionSnake;

import java.awt.*;

public class Snake {
    private DirectionSnake direction;
    private int snakeX = 300;
    private int snakeY = 300;

    public Snake() {
    }

    public void direction(DirectionSnake direction){
        this.direction = direction;
    }

    public void snakeMove(){
        if(direction == DirectionSnake.UP){
            snakeY = snakeY - 20;
        }
        if(direction == DirectionSnake.DOWN){
            snakeY = snakeY + 20;

        }
        if(direction == DirectionSnake.LEFT){
            snakeX = snakeX - 20;
        }
        if(direction == DirectionSnake.RIGHT){
            snakeX = snakeX + 20;
        }
    }

    public void snakePaint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(snakeX,snakeY,20,20);
    }

}
