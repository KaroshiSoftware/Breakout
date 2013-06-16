package com.karoshi.games.breakout;

import com.karoshi.games.framework.Screen;
import com.karoshi.games.framework.impl.AndroidGame;

public class BreakOut extends AndroidGame {
    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this); 
    }
}
