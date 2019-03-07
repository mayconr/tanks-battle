package com.maycon;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.maycon.components.AIComponent;
import com.maycon.components.AnimKey;
import com.maycon.components.AnimationComponent;
import com.maycon.components.PlayerComponent;
import com.maycon.components.SpeedComponent;
import com.maycon.components.SpriteComponent;
import com.maycon.components.StateComponent;
import com.maycon.components.TargetComponent;
import com.maycon.components.TransformComponent;
import com.maycon.components.TurrentComponent;

public class EntityFactory {
	
	
	private EntityFactory() {
		super();
	}

	public static Entity createPlayer() {
		final Entity player = new Entity();
		
		// Animation Component
		final AnimationComponent animationComponent = new AnimationComponent();
		
		// Tank Body
		final Array<Sprite> anims = new Array<Sprite>();
		anims.add(new Sprite(Assets.redTank1));
		anims.add(new Sprite(Assets.redTank2));
		final Animation<Sprite> tank = new Animation<Sprite>(0.05f, anims, PlayMode.LOOP);
		animationComponent.animations.put(AnimKey.TANK, tank);
		
		// Tank Turret
		final Animation<Sprite> turret = new Animation<Sprite>(0.05f, new Sprite(Assets.redTurret));		
		animationComponent.animations.put(AnimKey.TURRET, turret);
		player.add(animationComponent);
		player.add(new SpriteComponent());
		
		// Transform Component
		final TransformComponent transformComponent = new TransformComponent();
		transformComponent.x = 10;
		transformComponent.y = 10;
		transformComponent.degrees = 90;
		transformComponent.width = Assets.redTank1.getWidth();
		transformComponent.heigth = Assets.redTank1.getHeight();
		player.add(transformComponent);
		
		player.add(new SpeedComponent(100));					
		player.add(new PlayerComponent());
		player.add(new StateComponent());
		player.add(new TurrentComponent());
		return player;
	}
	
	public static Entity createEnemy(float x, float y) {
		final Entity enemy = new Entity();

		// Animation Component
		final AnimationComponent animationComponent = new AnimationComponent();
		// Tank Body
		final Array<Sprite> anims = new Array<Sprite>();
		anims.add(new Sprite(Assets.blackTank1));
		anims.add(new Sprite(Assets.blackTank2));
		final Animation<Sprite> tank = new Animation<Sprite>(0.05f, anims, PlayMode.LOOP);
		animationComponent.animations.put(AnimKey.TANK, tank);
		// Tank Turret
		final Animation<Sprite> turret = new Animation<Sprite>(0.025f, new Sprite(Assets.blackTurret));
		animationComponent.animations.put(AnimKey.TURRET, turret);
		enemy.add(animationComponent);
		
		// Transform Component
		final TransformComponent transformComponent = new TransformComponent();
		transformComponent.x = x;
		transformComponent.y = y;
		transformComponent.degrees = 180;
		transformComponent.width = Assets.blackTank1.getWidth();
		transformComponent.heigth = Assets.blackTank1.getHeight();
		enemy.add(transformComponent);
		
		// Others Components
		enemy.add(new SpeedComponent(100));					
		enemy.add(new AIComponent());
		enemy.add(new StateComponent());
		enemy.add(new TurrentComponent());
		enemy.add(new SpriteComponent());
		return enemy;
	}
	
	/**
	 * Creates a new ballet into the scenario
	 * @param sourceTransform Position of the creator
	 * @param targetPosition Position where the bullet must be moved
	 * @return  Bullet Entity
	 */
	public static Entity createBullet(float x, float y, float rotation, float targetX, float targetY) {
		final Entity entity = new Entity();
		
		// Animation Component
		final AnimationComponent animationComponent = new AnimationComponent();
		final Array<Sprite> bullets = new Array<Sprite>();
		bullets.add(new Sprite(Assets.bullet1));
		bullets.add(new Sprite(Assets.bullet2));
		animationComponent.animations.put(AnimKey.BULLET, new Animation<Sprite>(0.03f, bullets, PlayMode.LOOP));
		entity.add(animationComponent);
		
		// Transform Component
		final TransformComponent transformComponent = new TransformComponent();
		transformComponent.x = x - (Assets.bullet1.getWidth() / 2);
		transformComponent.y = y;
		transformComponent.degrees = rotation;
		entity.add(transformComponent);
		
		// Others Componentts
		entity.add(new SpriteComponent());
		entity.add(new TargetComponent(targetX, targetY));
		entity.add(new StateComponent());
		entity.add(new SpeedComponent(150));
		return entity;
	}
}
