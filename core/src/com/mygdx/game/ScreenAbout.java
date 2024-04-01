package com.mygdx.game;



import static com.mygdx.game.MyHorrorGame.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class ScreenAbout implements Screen {
    MyHorrorGame myHorrorGame;
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;
    BitmapFont font;


    Button btnBack;


    String textAbout = "Это супер игра.\n" +
            "В неё можно играть.\n"+
            "А можно не играть";

    public ScreenAbout(MyHorrorGame myHorrorGame) {
        this.myHorrorGame = myHorrorGame;
        batch = myHorrorGame.batch;
        touch = myHorrorGame.touch;
        camera = myHorrorGame.camera;


        btnBack = new Button("Back", 100, 400, font);
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

            if(btnBack.hitButton(touch.x, touch.y)){
                myHorrorGame.setScreen(myHorrorGame.screenMenu);
            }
        }

        // события

        // отрисовка
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch, textAbout, 800, 500);
        font.draw(batch, btnBack.text, btnBack.x, btnBack.y);
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
