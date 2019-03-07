package com.maycon.components;

import com.badlogic.ashley.core.Component;

public class TargetComponent implements Component {
	public float x;
	public float y;
	public TargetComponent(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
