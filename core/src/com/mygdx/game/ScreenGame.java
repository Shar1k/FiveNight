package com.mygdx.game;




import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class ScreenGame implements Screen {
    MyHorrorGame myHorrorGame;
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;
    BitmapFont font;


    Button btnBack;

    boolean isGameOver;
    int kills;

    public ScreenGame(MyHorrorGame myHorrorGame) {
        this.myHorrorGame = myHorrorGame;
        batch = myHorrorGame.batch;
        touch = myHorrorGame.touch;
        camera = myHorrorGame.camera;
        font = myHorrorGame.font;


        btnBack = new Button("Back", 100, 650, font);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // касания
        if(Gdx.input.isTouched()){
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



    private void gameOver(){
        isGameOver = true;
        sortRecords();
        saveRecords();
    }

    private void gameStart(){
        isGameOver = false;
        kills = 0;

    }



    private void sortRecords(){
        boolean flag = true;

    }

    private void saveRecords(){
        Preferences prefs = Gdx.app.getPreferences("");

        prefs.flush();
    }

    private void loadRecords(){
        Preferences prefs = Gdx.app.getPreferences("");

    }

    public void clearRecords(){

    }
}
