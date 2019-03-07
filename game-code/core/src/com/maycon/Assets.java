package com.maycon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	
	public static Texture bullet1;
	public static Texture bullet2;
	public static Texture redTank1;
	public static Texture redTank2;
	public static Texture blackTank1;
	public static Texture blackTank2;
	public static Texture redTurret;
	public static Texture blackTurret;
	
	public static void load() {
		bullet1 = new Texture(Gdx.files.internal("tank/bullets/rocket_1.png"));
		bullet2 = new Texture(Gdx.files.internal("tank/bullets/rocket_2.png"));
		redTank1 = new Texture(Gdx.files.internal("tank/tanks/tank_red_01.png"));
		
		redTank2 = new Texture(Gdx.files.internal("tank/tanks/tank_red_02.png"));
		blackTank1 = new Texture(Gdx.files.internal("tank/tanks/tank_black_01.png"));
		blackTank2 = new Texture(Gdx.files.internal("tank/tanks/tank_black_02.png"));
		redTurret = new Texture(Gdx.files.internal("tank/turrets/standard_red.png"));
		blackTurret = new Texture(Gdx.files.internal("tank/turrets/standard_black.png"));
	}
	
	public static void dispose() {
		bullet1.dispose();
		bullet2.dispose();
		redTank1.dispose();
	}
}
