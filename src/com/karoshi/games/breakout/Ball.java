package com.karoshi.games.breakout;

// Class for Ball objects in Breakout project
public class Ball {
	
	static final float BALL_DIMENSION = 32.0f;
    
    private float ballX = 240.0f - BALL_DIMENSION/2;
    private float ballY = 160.0f - BALL_DIMENSION/2;

    private float ballLeft = ballX;
    private float ballCenter = ballX + BALL_DIMENSION/2;
    private float ballRight = ballX + BALL_DIMENSION; 
    private float ballTop = ballY;
    
    private float xDirection = 0.4f;
    private float yDirection = 1.5f;
    
    public Ball(){
    }

    public int getballX() {
		return (int)ballX;
	}

	public int getballY() {
		return (int)ballY;
	}     
    
    public int getBallCenter() {
		return (int)(ballX + BALL_DIMENSION/2.0);
	}    
    	
	public void move(int paddleX, Brick[] bricks) {
		// TODO Auto-generated method stub
    	ballX += xDirection;
    	ballY += yDirection;
    	
    	ballLeft = ballX;
    	ballCenter = ballX + BALL_DIMENSION/2;
    	ballRight = ballX + BALL_DIMENSION;
    	ballTop = ballY;
    	
    	float paddleCenter = paddleX + Paddle.PADDLE_DIMENSION_X/2;

    	//check to see if it hits the sides
    	if( (0 > ballX) || (ballX > 480 - BALL_DIMENSION) ) {
    		xDirection *= -1;
    		Assets.side_sound.play(1);    		
    	}
    	//check to see if it hits the top
    	if( 0 > ballY ) {
    		yDirection *= -1;
    		Assets.top_sound.play(1);      		
    	}
    	//check to see if it hits the bottom
    	if( ballY > 320 - BALL_DIMENSION ) {
    		yDirection *= -1;
    		Assets.bottom_sound.play(1);      		
    	}
    	
    	//check for collision with bricks
    	for (int i = 0; i < World.NUM_BRICKS; i++)
    	{
    		if ( ballTop <= bricks[i].getBrickBottom() && ballLeft >= bricks[i].getBrickLeft() && ballRight <= bricks[i].getBrickRight() && bricks[i].isExists())
    		{
    			yDirection *= -1;
    			Assets.top_sound.play(1);
    			bricks[i].setExists(false);
    			break;
    		}	
    	}

    	//if the ball is within the x bound of the paddle
    	if( (ballX + BALL_DIMENSION >= paddleX) && (ballX <= paddleX + Paddle.PADDLE_DIMENSION_X) ) {
    		//and also within the y bounds of the paddle
    		if ( ballY + BALL_DIMENSION >= 320 - (Paddle.PADDLE_DIMENSION_Y + Paddle.PADDLE_BUFFER_SPACE)) {
    			//then change y direction
        		yDirection *= -1;
        		//and change x direction by an amount that depends on where it hit the paddle
        		float distanceFromCenter = Math.abs(ballCenter - paddleCenter);
        		//scale the distance from the center so that all the way on the edge = 1.0, dead center = ~0
        		distanceFromCenter /= Paddle.PADDLE_DIMENSION_X/2;
        		//add some oomph
        		//distanceFromCenter *= 2.0;
        		if (ballCenter < paddleCenter) {
        			distanceFromCenter *= -1.0f;        			
        		}
        		xDirection += distanceFromCenter; 
        		Assets.paddle_sound.play(1);      			
    		}    		
    	}    	
    	
	}	
	
}
