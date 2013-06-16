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
        Assets.background 	= g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.ball 		= g.newPixmap("ball.png", PixmapFormat.RGB565);
        Assets.paddle 		= g.newPixmap("paddle.png", PixmapFormat.RGB565);
        Assets.ping 		= game.getAudio().newSound("ping.wav");        
        Assets.bottom_sound	= game.getAudio().newSound("bottom_sound.mp3");   
        Assets.top_sound	= game.getAudio().newSound("top_sound.mp3");   
        Assets.side_sound	= game.getAudio().newSound("side_sound.mp3");   
        Assets.paddle_sound = game.getAudio().newSound("paddle_sound.mp3");           
        //        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
//        Assets.button = g.newPixmap("button.png", PixmapFormat.ARGB4444);

/*        Assets.hello 		= game.getAudio().newSound("hello.mp3");
        Assets.intercourse 	= game.getAudio().newSound("intercourse.mp3");
        Assets.ladies 		= game.getAudio().newSound("ladies.mp3");
        Assets.sister 		= game.getAudio().newSound("sister.mp3");
        Assets.testicles 	= game.getAudio().newSound("testicles.mp3");        
        Assets.thank_you 	= game.getAudio().newSound("thank_you.mp3");
        Assets.u_s_and_a 	= game.getAudio().newSound("u_s_and_a.mp3");
        Assets.vanilla 		= game.getAudio().newSound("vanilla.mp3");
        Assets.weewa 		= game.getAudio().newSound("weewa.mp3");
        Assets.why_not 		= game.getAudio().newSound("why_not.mp3"); 
*/
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
