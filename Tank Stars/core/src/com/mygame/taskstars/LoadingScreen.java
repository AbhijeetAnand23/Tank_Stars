package com.mygame.taskstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class LoadingScreen implements Screen {
    private TankStars game;
    private SpriteBatch batch;
    private Texture background;
    private Texture loading;
    private Rectangle box;
    private Vector3 touch;
    private Music entrySong;
//    ShapeRenderer shapeRenderer;

    public LoadingScreen(TankStars game) {
        this.game = game;
        batch = new SpriteBatch();
//        shapeRenderer = new ShapeRenderer();

        background = new Texture("Loading.png");
        loading = new Texture("LoadingBar.png");
        entrySong = Gdx.audio.newMusic(Gdx.files.internal("loadingScreenMusic.mp3"));
        box = new Rectangle(600, 20,700, 70);
        entrySong.setLooping(true);
        entrySong.play();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        game.batch.begin();
        game.batch.draw(background, 0,0, 1900, 915);
        game.batch.draw(loading, 450, -175, 1000, 462);
        game.batch.end();

        if (Gdx.input.justTouched()) {
            touch = new Vector3();
            touch.set(1900 - Gdx.input.getX(), 915 - Gdx.input.getY(), 0);
            if(box.contains(touch.x, touch.y)) {
                game.setScreen(new MainMenu(game));
                dispose();
            }
        }

//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.rect(box.x, box.y, box.width, box.height);
//        shapeRenderer.end();
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
        background.dispose();
        loading.dispose();
        entrySong.dispose();
    }
}
