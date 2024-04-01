package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import static com.mygdx.game.MyHorrorGame.*;

public class ScreenSettings implements Screen {
    MyHorrorGame myHorrorGame;
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;

    public ScreenSettings(MyHorrorGame myHorrorGame) {
        this.myHorrorGame = myHorrorGame;
        batch = myHorrorGame.batch;
        camera = myHorrorGame.camera;
        touch = myHorrorGame.touch;


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // касания
        if(Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);

        }

        // события

        // отрисовка
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
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


    }

}
