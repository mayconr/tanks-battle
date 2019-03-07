package com.maycon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maycon.components.SpriteComponent;

public class RenderingSystem extends IteratingSystem  {

	private ComponentMapper<SpriteComponent> tm = ComponentMapper.getFor(SpriteComponent.class);
	private SpriteBatch batch;
	private OrthographicCamera cam;
	
	@SuppressWarnings("unchecked")
	public RenderingSystem(SpriteBatch batch) {
		super(Family.all(SpriteComponent.class).get(), 1);
		this.batch = batch;
		this.cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.cam.setToOrtho(true);
		this.cam.zoom = 1.3f;
		this.cam.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
	}	
		
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		final SpriteComponent sprite = tm.get(entity);
		cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.enableBlending();
        batch.begin();
        for (Sprite s : sprite.sprites) {
        	s.draw(batch);
        }
        batch.end();
	}
}
