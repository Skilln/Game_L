package com.skilln.gamel.values;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Resource {

    public static TextureAtlas logo;

    private static AssetManager assetManager = new AssetManager();

    public static void load() {
        assetManager.load("logo.atlas", TextureAtlas.class);

        assetManager.update();

        assetManager.finishLoading();

        Gdx.app.log("Resource :", "Resources loaded!");
    }

    public static <T> T get(String path) {
        return assetManager.get(path);
    }
}
