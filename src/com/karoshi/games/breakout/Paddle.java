package com.karoshi.games.breakout;

public class Paddle {

    public static final float PADDLE_DIMENSION_X = 100.0f;
    public static final float PADDLE_DIMENSION_Y = 20.0f;
    public static final float PADDLE_BUFFER_SPACE = 30.0f;	
	
    private float paddleX = 240 - PADDLE_DIMENSION_X/2;
    private float paddleY = 320 - PADDLE_DIMENSION_Y - PADDLE_BUFFER_SPACE;
    private float paddleCenter = paddleX + PADDLE_DIMENSION_X/2;	
	
    public int getPaddleX() {
		return (int)paddleX;
	}

    public int getPaddleCenter() {
		return (int)(paddleX + PADDLE_DIMENSION_X/2);
	}    
    
	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
	}
	
	public int getPaddleY() {
		return (int)paddleY;
	}

	public int getLengthPaddle(){
		return (int)PADDLE_DIMENSION_X;
	}
    
    public Paddle(){
    }	
}
