package com.skilln.gamel.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.skilln.gamel.GameState;

import java.util.HashMap;

public class ScreenManager {

    private static Game game;

    private static HashMap<GameState, Screen> screen;

    public static void init(Game game) {
        ScreenManager.game = game;

        screen = new HashMap<GameState, Screen>();

        screen.put(GameState.SPLASH, new SplashScreen());
        screen.put(GameState.MENU, new MenuScreen());

    }

    public static void setScreen(GameState state) {
        game.setScreen(screen.get(state));
    }






}
