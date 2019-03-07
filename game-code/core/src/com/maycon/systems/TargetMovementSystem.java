package com.maycon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.maycon.components.TransformComponent;
import com.maycon.components.SpeedComponent;
import com.maycon.components.TargetComponent;

public class TargetMovementSystem extends IteratingSystem {

	private final ComponentMapper<TransformComponent> pm = ComponentMapper.getFor(TransformComponent.class);
	private final ComponentMapper<TargetComponent> tm = ComponentMapper.getFor(TargetComponent.class);
	private final ComponentMapper<SpeedComponent> spm = ComponentMapper.getFor(SpeedComponent.class);
	
	@SuppressWarnings("unchecked")
	public TargetMovementSystem() {
		super(Family.all(TransformComponent.class, TargetComponent.class, SpeedComponent.class).get());		
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		TransformComponent position = pm.get(entity);
		TargetComponent target = tm.get(entity);		
		SpeedComponent speed = spm.get(entity);
		
		int posX = (int) position.x;
		int posY = (int) position.y;
		
		int targetX = (int) target.x;
		int targetY = (int) target.y;
		
		if (posX != targetX) {
			if (position.x < target.x) {
				position.x += Math.cos(Math.toRadians(position.degrees)) * speed.speed * deltaTime;
			} else {
				position.x -= Math.cos(Math.toRadians(position.degrees)) * speed.speed * deltaTime;;
			}			
		}
		if (posY != targetY) {
			if (position.y < target.y) {
				position.y += Math.sin(Math.toRadians(position.degrees)) * speed.speed * deltaTime;
			} else {
				position.y -= Math.sin(Math.toRadians(position.degrees)) * speed.speed * deltaTime;
			}
		}
		
	}

}
