package com.maycon.screens.battlefield;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.maycon.EntityFactory;
import com.maycon.systems.AnimationSystem;
import com.maycon.systems.TargetMovementSystem;
import com.maycon.systems.PlayerControllerSystem;
import com.maycon.systems.RenderingSystem;

public class BattleScreen extends ScreenAdapter {
	private boolean initialized;
	public SpriteBatch batch;
	public Engine engine;
	public World world;

	public BattleScreen(SpriteBatch batch) {
		super();		
		this.batch = batch;
	}

	private void init() {
		this.engine = new Engine();
		this.engine.addSystem(new AnimationSystem());
		this.engine.addSystem(new RenderingSystem(batch));
		this.engine.addSystem(new PlayerControllerSystem(engine));
		this.engine.addSystem(new TargetMovementSystem());				
		
		this.engine.addEntity(EntityFactory.createPlayer());
		this.engine.addEntity(EntityFactory.createEnemy(200, 200));
		
		this.initialized = true;
	}
	
	private void update(float delta) {
		engine.update(delta);
	}
	
	@Override
	public void render(float delta) {
		if (initialized) {
			update(delta);
		} else {
			init();
		}
	}
		
}
