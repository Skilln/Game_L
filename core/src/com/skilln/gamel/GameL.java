package com.skilln.gamel;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.skilln.gamel.screen.ScreenManager;

public class GameL extends Game {


	@Override
	public void create () {

		ScreenManager.init(this);

		ScreenManager.setScreen(GameState.SPLASH);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		super.render();

	}
	
	@Override
	public void dispose () {

	}
}
