package com.maycon.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.maycon.components.AnimKey;
import com.maycon.components.AnimationComponent;
import com.maycon.components.SpriteComponent;
import com.maycon.components.StateComponent;
import com.maycon.components.TransformComponent;

public class AnimationSystem extends IteratingSystem {

	private final ComponentMapper<TransformComponent> pm = ComponentMapper.getFor(TransformComponent.class);
	private final ComponentMapper<AnimationComponent> am = ComponentMapper.getFor(AnimationComponent.class);
	private final ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);
	private final ComponentMapper<StateComponent> stm = ComponentMapper.getFor(StateComponent.class);
	
	@SuppressWarnings("unchecked")
	public AnimationSystem() {
		super(Family.all(TransformComponent.class, AnimationComponent.class, SpriteComponent.class, StateComponent.class).get(), 0);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		final TransformComponent transform = pm.get(entity);
		final AnimationComponent animation = am.get(entity);
		final SpriteComponent sprite = sm.get(entity);
		final StateComponent state = stm.get(entity);
		
		state.update(deltaTime);
		sprite.sprites.clear();
		Sprite mainSprite = null;
		for (AnimKey key : AnimKey.values()) {
			if (animation.animations.containsKey(key)) {
				final Sprite s1 = animation.animations.get(key).getKeyFrame(state.stateTime);
				if (mainSprite == null) {
					mainSprite = s1;
				} else {
					s1.setOrigin(mainSprite.getOriginX(), mainSprite.getOriginY());
					/*System.out.println("X "+(transform.x-10)+" Y:"+transform.y+" "
							+ "\nMX: "+mainSprite.getX()+" MY:"+mainSprite.getY()
							+ "\nMOX:"+mainSprite.getOriginX()+" MOY:"+mainSprite.getOriginY());
					System.out.println("------------------------------------");*/
				}
				s1.setPosition(transform.x, transform.y);
				s1.setRotation(transform.degrees);				
				sprite.sprites.add(s1);
			}
		}		
	}

}
