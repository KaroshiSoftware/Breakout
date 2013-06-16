package com.karoshi.games.breakout;

import java.lang.Math;
import java.util.Random;

public class World {
    static final int SCORE_INCREMENT = 10;
    static final float TICK_INITIAL = 0.01f;
    static final float TICK_DECREMENT = 0.005f;
    static final int NUM_BRICKS = 30;
    
    public Ball ball;
    public Paddle paddle;
    public Brick[] bricks;
    public boolean gameOver = false;;
    public int score = 0;  
    
    Random random = new Random();

	float tickTime = 0;
    static float tick = TICK_INITIAL;

    public World() {
    	ball = new Ball();
    	paddle = new Paddle();
    	bricks = new Brick[NUM_BRICKS];
    	float y = 0;
    	for (int rows = 0; rows < 3; rows++)
    	{
        	float x = 0;
	    	for (int cols = 0; cols < 10; cols++)
	    	{
	    		bricks[rows * 10 + cols] = new Brick(x, y);
	    		x += 48;
	    	}
	    	y += 24;
    	}
    }   
    
    public void update(float deltaTime) {
        if (gameOver)
            return;

        tickTime += deltaTime;

        while (tickTime > tick) {
            tickTime -= tick;            
            ball.move(paddle.getPaddleX(), bricks);
/*            snake.advance();
            if (snake.checkBitten()) {
                gameOver = true;
                return;
            }*/

/*            SnakePart head = snake.parts.get(0);
            if (head.x == stain.x && head.y == stain.y) {
                score += SCORE_INCREMENT;
                snake.eat();
                if (snake.parts.size() == WORLD_WIDTH * WORLD_HEIGHT) {
                    gameOver = true;
                    return;
                } else {
                    placeStain();
                }

                if (score % 100 == 0 && tick - TICK_DECREMENT > 0) {
                    tick -= TICK_DECREMENT;
                }
            }*/
        }
    }
}
