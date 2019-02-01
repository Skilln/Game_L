package com.skilln.gamel.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.skilln.gamel.values.Values;

public class GameScreen implements Screen {

    private World gameWorld;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Box2DDebugRenderer renderer;

    @Override
    public void show() {
        gameWorld = new World(new Vector2(0, 0), true);
        camera = new OrthographicCamera(Values.GAME_WIDTH, Values.GAME_HEIGHT);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
        camera.update();

        batch = new SpriteBatch();
        renderer = new Box2DDebugRenderer();

        gameWorld.step(Values.WORLD_STEP, Values.WORLD_VELOCITY, Values.WORLD_POSITION);

    }

    @Override
    public void render(float delta) {
        renderer.render(gameWorld, camera.combined);
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
        gameWorld.dispose();
        batch.dispose();
        renderer.dispose();
    }
}
