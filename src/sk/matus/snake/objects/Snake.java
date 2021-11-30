package sk.matus.snake.objects;

import sk.matus.snake.enums.DirectionSnake;

import java.awt.*;

public class Snake {
    private DirectionSnake direction;
    private int[][] snake = new int[300][2];
    private DirectionSnake[] directionSnakes = new DirectionSnake[300];
    private DirectionSnake directionOld = DirectionSnake.UP;
    private int snakeX = 300;
    private int snakeY = 300;
    private int snakeOldX = 0;
    private int snakeOldY = 0;
    private int score = 0;
    private int iterator = 0;
    private int pointX = 0;
    private int pointY = 0;

    public Snake() {
        snake[0][0] = snakeX;
        snake[0][1] = snakeY;
    }

    public void direction(DirectionSnake direction){
        this.direction = direction;
    }

    public int getSnakeX(){
        return snake[0][0];
    }

    public int getSnakeY(){
        return snake[0][1];
    }

    public void snakeMove(){
        if(direction == DirectionSnake.UP){
            snake[0][1] = snake[0][1] - 20;
            directionSnakes[0] = DirectionSnake.UP;
        }
        if(direction == DirectionSnake.DOWN){
            snake[0][1] = snake[0][1] + 20;
            directionSnakes[0] = DirectionSnake.DOWN;
        }
        if(direction == DirectionSnake.LEFT){
            snake[0][0] = snake[0][0] - 20;
            directionSnakes[0] = DirectionSnake.LEFT;
        }
        if(direction == DirectionSnake.RIGHT){
            snake[0][0] = snake[0][0] + 20;
            directionSnakes[0] = DirectionSnake.RIGHT;
        }
    }

    public void snakePaint(Graphics g){
        g.setColor(Color.green);
        snake[1][0] = snakeOldX;
        snake[1][1] = snakeOldY;
        directionSnakes[1] = directionOld;
        g.fillRect(snake[0][0],snake[0][1],20,20);
        if(score >= 1) {
            g.fillRect(snake[1][0], snake[1][1], 20, 20);
        }

        if(score >= 2) {
            for(int i = 2; i <= score; i++){
                g.fillRect(snake[i][0],snake[i][1],20,20);
            }
            for (int i = 2; i <= score; i++) {
                g.fillRect(snake[i][0],snake[i][1],20,20);
                snake[i][0] = snake[i - 1][0];
                snake[i][1] = snake[i - 1][1];
                directionSnakes[i] = directionSnakes[i - 1];
            }

        }
        snakeOldX = snake[0][0];
        snakeOldY = snake[0][1];
        directionOld = directionSnakes[0];
    }

    public void pointPosition(int x, int y){
        pointX = x;
        pointY = y;
        if(new Rectangle(pointX, pointY, 20, 20).intersects(snake[0][0],snake[0][1], 20,20)){
            score++;
            System.out.println(score);
            if(score >= 2) {
                if (directionSnakes[score - 1] == DirectionSnake.DOWN) {
                    System.out.println("down");
                    snake[score][0] = snake[score-1][0];
                    snake[score][1] = snake[score - 1][1] - 22;
                    directionSnakes[score] = directionSnakes[score - 1];
                }
                if (directionSnakes[score - 1] == DirectionSnake.UP) {
                    System.out.println("up");
                    snake[score][0] = snake[score-1][0];
                    snake[score][1] = snake[score - 1][1] + 22;
                    directionSnakes[score] = directionSnakes[score - 1];
                }
                if (directionSnakes[score - 1] == DirectionSnake.LEFT) {
                    System.out.println("left");
                    snake[score][0] = snake[score -1][0] + 22;
                    snake[score][1] = snake[score - 1][1];
                    directionSnakes[score] = directionSnakes[score - 1];
                }
                if (directionSnakes[score - 1] == DirectionSnake.RIGHT) {
                    System.out.println("right");
                    snake[score][0] = snake[score - 1][0] - 22;
                    snake[score][1] = snake[score - 1][1];
                    directionSnakes[score] = directionSnakes[score - 1];
                }
            }
        }
    }

}
