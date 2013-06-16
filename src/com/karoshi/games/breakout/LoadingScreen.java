package com.karoshi.games.breakout;

import com.karoshi.games.framework.Game;
import com.karoshi.games.framework.Graphics;
import com.karoshi.games.framework.Screen;
import com.karoshi.games.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.loading_background 	= g.newPixmap("loading_background.png", PixmapFormat.RGB565);
        Assets.brick_red	= g.newPixmap("brick_red.png", PixmapFormat.RGB565);
        Assets.brick_blue	= g.newPixmap("brick_blue.png", PixmapFormat.RGB565);
        Assets.brick_green	= g.newPixmap("brick_green.png", PixmapFormat.RGB565);
        Assets.brick_yellow	= g.newPixmap("brick_yellow.png", PixmapFormat.RGB565);
        Assets.brick_orange	= g.newPixmap("brick_orange.png", PixmapFormat.RGB565);
        Assets.brick_purple	= g.newPixmap("brick_purple.png", PixmapFormat.RGB565);        
        Assets.background 	= g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.ball 		= g.newPixmap("ball.png", PixmapFormat.RGB565);
        Assets.paddle 		= g.newPixmap("paddle.png", PixmapFormat.RGB565);   
        Assets.logo 		= g.newPixmap("logo.png", PixmapFormat.ARGB4444);        
        Assets.ping 		= game.getAudio().newSound("ping.wav"); 
        Assets.bottom_sound	= game.getAudio().newSound("bottom_sound.mp3");   
        Assets.top_sound	= game.getAudio().newSound("top_sound.mp3");   
        Assets.side_sound	= game.getAudio().newSound("side_sound.mp3");   
        Assets.paddle_sound = game.getAudio().newSound("paddle_sound.mp3");           
//        Assets.button = g.newPixmap("button.png", PixmapFormat.ARGB4444);
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
