package com.skilln.gamel.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.skilln.gamel.GameL;
import com.skilln.gamel.GameState;
import com.skilln.gamel.values.Resource;
import com.skilln.gamel.values.Strings;
import com.skilln.gamel.values.Values;

public class SplashScreen implements Screen {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Animation<TextureRegion> logo;

    private TextureAtlas atlas;

    private float width, height;

    private float a = 0;

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Values.GAME_WIDTH, Values.GAME_HEIGHT);

        Resource.load();

        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
        camera.update();

        atlas = Resource.get(Strings.LOGO_ATLAS);

        logo = new Animation<TextureRegion>(1/25f, atlas.getRegions(), Animation.PlayMode.NORMAL);

        width = atlas.getRegions().first().originalWidth;
        height = atlas.getRegions().first().originalHeight;
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        TextureRegion region = logo.getKeyFrame(a);

        batch.draw(region, Values.GAME_WIDTH /2f - width/2f, Values.GAME_HEIGHT/2f - height/2f);
        a+=delta;

        if(logo.isAnimationFinished(a)) {
            ScreenManager.setScreen(GameState.MENU);
        }

        batch.end();
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
        atlas.dispose();
    }
}
