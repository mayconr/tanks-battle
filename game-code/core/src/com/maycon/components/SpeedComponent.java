package com.maycon.components;

import com.badlogic.ashley.core.Component;

public class SpeedComponent implements Component {	
	public float speed = 100;

	public SpeedComponent(float speed) {
		super();
		this.speed = speed;
	}
	
}
