package com.mygdx.game;




import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class ScreenGame implements Screen {
    MyHorrorGame myHorrorGame;
    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;
    BitmapFont fontLarge, fontSmall;

    Texture imgBackGround;


    SpaceButton btnBack;


    boolean isGameOver;
    int kills;

    public ScreenGame(MyHorrorGame myHorrorGame) {
        this.myHorrorGame = myHorrorGame;
        batch = myHorrorGame.batch;
        touch = myHorrorGame.touch;
        camera = myHorrorGame.camera;
        font = tmyHorrorGame;


        imgBackGround = new Texture("space1.png");


    }

    @Override
    public void show() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        touch.set(0, 0, 0);
        gameStart();
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
        imgBackGround.dispose();
        imgShipsAtlas.dispose();
        imgShot.dispose();
    }



    private void gameOver(){
        isGameOver = true;
        players[players.length-1].name = sunSpaceArcade.playerName;
        players[players.length-1].score = kills;
        sortRecords();
        saveRecords();
    }

    private void gameStart(){
        isGameOver = false;
        kills = 0;
        enemies.clear();
        shots.clear();
        fragments.clear();
        respawnShip();
        ship.lives = nShipLives;
    }



    private void sortRecords(){
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i < players.length-1; i++) {
                if(players[i].score<players[i+1].score){
                    Player c = players[i];
                    players[i] = players[i+1];
                    players[i+1] = c;
                    flag = true;
                }
            }
        }
    }

    private void saveRecords(){
        Preferences prefs = Gdx.app.getPreferences("SunArcadeRecords");
        for (int i = 0; i < players.length; i++) {
            prefs.putString("name"+i, players[i].name);
            prefs.putInteger("score"+i, players[i].score);
        }
        prefs.flush();
    }

    private void loadRecords(){
        Preferences prefs = Gdx.app.getPreferences("SunArcadeRecords");
        for (int i = 0; i < players.length; i++) {
            if(prefs.contains("name"+i)) players[i].name = prefs.getString("name"+i);
            if(prefs.contains("score"+i)) players[i].score = prefs.getInteger("score"+i);
        }
    }

    public void clearRecords(){
        for (int i = 0; i < players.length; i++) {
            players[i].name = "Noname";
            players[i].score = 0;
        }
    }
}
