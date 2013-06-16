package com.karoshi.games.breakout;

import java.lang.Math;
import java.util.Random;

public class World {
    static final int SCORE_INCREMENT = 10;
    static final float TICK_INITIAL = 0.01f;
    static final float TICK_DECREMENT = 0.005f;
    
    public Ball ball;
    public Paddle paddle;
    public boolean gameOver = false;;
    public int score = 0;  
    
    Random random = new Random();

	float tickTime = 0;
    static float tick = TICK_INITIAL;

    public World() {
    	ball = new Ball();
    	paddle = new Paddle();
    }   
    
    public void update(float deltaTime) {
        if (gameOver)
            return;

        tickTime += deltaTime;

        while (tickTime > tick) {
            tickTime -= tick;            
            ball.move(paddle.getPaddleX());
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
