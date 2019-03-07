package com.maycon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maycon.screens.battlefield.BattleScreen;

public class TankGame extends Game {
	public SpriteBatch batch;		

	@Override
	public void create () {	
		Assets.load();
		batch = new SpriteBatch();
		setScreen(new BattleScreen(batch));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();	
	}
}
