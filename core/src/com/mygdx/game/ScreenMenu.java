package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.mygdx.game.MyHorrorGame.*;

public class ScreenMenu implements Screen {
    MyHorrorGame myHorrorGame;
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;
    BitmapFont font;


    Button btnPlay;
    Button btnSettings;
    Button btnAbout;
    Button btnExit;

    public ScreenMenu(MyHorrorGame myHorrorGame) {
        this.myHorrorGame = myHorrorGame;
        batch = myHorrorGame.batch;
        touch = myHorrorGame.touch;
        camera = myHorrorGame.camera;
        font = myHorrorGame.font;



        btnPlay = new Button("Play", 100, 700, font);
        btnSettings = new Button("Settings", 100, 600, font);
        btnAbout = new Button("About Game", 100, 500, font);
        btnExit = new Button("Exit", 100, 400, font);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        // касания
        if(Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);

            if(btnPlay.hitButton(touch.x, touch.y)){
                myHorrorGame.setScreen(myHorrorGame.screenGame);
            }
            if(btnSettings.hitButton(touch.x, touch.y)){
                myHorrorGame.setScreen(myHorrorGame.screenSettings);
            }
            if(btnAbout.hitButton(touch.x, touch.y)){
                myHorrorGame.setScreen(myHorrorGame.screenAbout);
            }
            if(btnExit.hitButton(touch.x, touch.y)){
                Gdx.app.exit();
            }
        }

        // события

        // отрисовка
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        font.draw(batch, btnPlay.text, btnPlay.x, btnPlay.y);
        font.draw(batch, btnSettings.text, btnSettings.x, btnSettings.y);
        font.draw(batch, btnAbout.text, btnAbout.x, btnAbout.y);
        font.draw(batch, btnExit.text, btnExit.x, btnExit.y);
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
