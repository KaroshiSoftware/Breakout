package com.karoshi.games.breakout;

import java.util.List;

import com.karoshi.games.breakout.Assets;
import com.karoshi.games.breakout.GameScreen;
import com.karoshi.games.breakout.Settings;
import com.karoshi.games.framework.Game;
import com.karoshi.games.framework.Graphics;
import com.karoshi.games.framework.Input.TouchEvent;
import com.karoshi.games.framework.Screen;

public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);               
    }   

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();       
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 0, 0, 480, 320) ) {
                    game.setScreen(new GameScreen(game));
                    if(Settings.soundEnabled)
                        //Assets.click.play(1);
                    return;
                }
            }
        }
    }
    
    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && 
           event.y > y && event.y < y + height - 1) 
            return true;
        else
            return false;
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.background, 0, 0);
        //g.drawPixmap(Assets.logo, 50, 10);
        
        //draw stuff here      
        //g.drawRect(460, 0, 20, 20, 0xff00ff00);
    }

    @Override
    public void pause() {        
        Settings.save(game.getFileIO());
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
