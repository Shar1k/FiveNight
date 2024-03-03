package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;


public class MyHorrorGame extends Game {
	public static final float SCR_WIDTH = 900, SCR_HEIGHT = 1600;

	SpriteBatch batch;
	Texture img;
	Vector3 touch;
	OrthographicCamera camera;

	ScreenAbout screenAbout;
	ScreenGame screenGame;
	ScreenMenu screenMenu;
	ScreenSettings screenSettings;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		camera =  new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		touch = new Vector3();

		  screenAbout = new ScreenAbout(this);
		  screenGame = new ScreenGame(this);
		  screenMenu = new ScreenMenu(this);
		  screenSettings = new ScreenSettings(this);
		  setScreen(screenMenu);

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
