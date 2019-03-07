package com.maycon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.maycon.EntityFactory;
import com.maycon.components.PlayerComponent;
import com.maycon.components.SpeedComponent;
import com.maycon.components.StateComponent;
import com.maycon.components.TransformComponent;

public class PlayerControllerSystem extends IteratingSystem {

	private final ComponentMapper<TransformComponent> pm = ComponentMapper.getFor(TransformComponent.class);
	private final ComponentMapper<SpeedComponent> sm = ComponentMapper.getFor(SpeedComponent.class);
	private final ComponentMapper<StateComponent> stm = ComponentMapper.getFor(StateComponent.class);
	
	private final Engine engine;
	
	@SuppressWarnings("unchecked")
	public PlayerControllerSystem(Engine engine) {
		super(Family.all(TransformComponent.class, SpeedComponent.class, PlayerComponent.class).get());
		this.engine = engine;
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		final TransformComponent transform = pm.get(entity);
		final SpeedComponent speed = sm.get(entity);
		final StateComponent state = stm.get(entity);
				
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {			
			transform.degrees -= speed.speed * deltaTime;
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			transform.degrees += speed.speed * deltaTime;
		}
		
		if (Gdx.input.isKeyPressed(Keys.UP)) {						
			transform.x += (float) Math.cos(Math.toRadians(transform.degrees)) * (speed.speed * deltaTime);
			transform.y += (float) Math.sin(Math.toRadians(transform.degrees)) * (speed.speed * deltaTime);
			
			state.setState(StateComponent.MOVING);
		}
		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {						
			engine.addEntity(EntityFactory.createBullet((transform.x + (transform.width / 2)) , transform.y, transform.degrees, transform.x + 200, transform.y + 200));
		}
	}

}
