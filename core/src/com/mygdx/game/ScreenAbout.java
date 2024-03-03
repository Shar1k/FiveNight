package com.mygdx.game;



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

    Texture imgBackGround;

    SpaceButton btnBack;
    String textAbout = "Это супер игра.\n" +
            "В неё можно играть.\n"+
            "А можно не играть";

    public ScreenAbout(MyHorrorGame myHorrorGame) {
        this.myHorrorGame = myHorrorGame;
        batch = myHorrorGame.batch;
        touch = myHorrorGame.touch;
        camera = myHorrorGame.camera;
        font = tmyHorrorGame;

        imgBackGround = new Texture("space2.png");

        btnBack = new SpaceButton("Back", 300, 550, font);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // касания
        if(Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            myHorrorGame.unproject(touch);

            if(btnBack.hit(touch.x, touch.y)){
                sunSpaceArcade.setScreen(sunSpaceArcade.screenMenu);
            }
        }

        // события

        // отрисовка
        batch.setProjectionMatrix(myHorrorGame.combined);
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        font.draw(batch, textAbout, 100, 1200);
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
        imgBackGround.dispose();
    }
}
