package com.skilln.gamel.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.skilln.gamel.GameL;
import com.skilln.gamel.values.Values;

public class MenuScreen implements Screen {

    private Stage stage;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private TextButton playButton;

    private BitmapFont font;

    @Override
    public void show() {
        camera = new OrthographicCamera(Values.GAME_WIDTH, Values.GAME_HEIGHT);
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f, 0);
        camera.update();

        batch = new SpriteBatch();

        FitViewport viewport = new FitViewport(Values.GAME_WIDTH, Values.GAME_HEIGHT, camera);

        stage = new Stage(viewport, batch);

        font = new BitmapFont();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = font;
        style.fontColor = Color.WHITE;

        playButton = new TextButton("Play", style);

        playButton.setWidth(200);
        playButton.setHeight(100);

        playButton.setX(Values.GAME_WIDTH /2f - playButton.getWidth()/2f);
        playButton.setY(Values.GAME_HEIGHT/2f - playButton.getHeight()/2f);

        stage.addActor(playButton);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        font.dispose();

    }
}
