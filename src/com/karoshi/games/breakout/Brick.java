package com.karoshi.games.breakout;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Brick {

	static final float BRICK_DIMENSION_X = 48.0f;
	static final float BRICK_DIMENSION_Y = 24.0f;
	
    public static enum Color {
    	RED, 
    	YELLOW, 
    	BLUE, 
    	GREEN, 
    	ORANGE, 
    	PURPLE;
    	
    	private static final List<Color> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    	private static final int SIZE = VALUES.size();
    	private static final Random RANDOM = new Random();
    	
    	public static Color randomColor() {
    		return VALUES.get(RANDOM.nextInt(SIZE));
    	}
    }
    
    private float brickX;
	private float brickY;
	private float brickLeft;
	private float brickBottom;
	private float brickRight;	
	
	private boolean exists;
   
    public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	private Color color;
    
    public Color getColor() {
		return color;
	}

	public int getBrickX() {
		return (int)brickX;
	}

	public int getBrickY() {
		return (int)brickY;
	}
	
	public int getBrickLeft() {
		return (int) brickLeft;
	}

	public int getBrickRight() {
		return (int) brickRight;
	}
	
	public int getBrickBottom() {
		return (int)brickBottom;
	}

    public Brick(float x, float y){
    	this.brickX = x;
    	this.brickY = y;
    	this.color = Color.randomColor();
    	this.brickLeft = x;
    	this.brickRight = x + BRICK_DIMENSION_X;
    	this.brickBottom = this.brickY + BRICK_DIMENSION_Y;
    	exists = true;
    }	
	
}
