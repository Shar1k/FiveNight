package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;


public class MyHorrorGame extends Game {
	public static final float SCR_WIDTH = 1600, SCR_HEIGHT = 900;

	SpriteBatch batch;
	Texture img;
	Vector3 touch;
	OrthographicCamera camera;
	BitmapFont font;

	ScreenAbout screenAbout;
	ScreenGame screenGame;
	ScreenMenu screenMenu;
	ScreenSettings screenSettings;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		fontGenerate();
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
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	void fontGenerate () {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("MyHorrorFont.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 50;
		font = generator.generateFont(parameter);
	}
}
