package com.maycon.components;

import com.badlogic.ashley.core.Component;

public class StateComponent implements Component {
	
	public static final int NORMAL = 0;
	public static final int MOVING = 1;
	
	public float stateTime;
	public int currentState;
	public int lastState;
	
	public void setState(int state) {
		if (this.currentState != state) {
			this.lastState = this.currentState;
			this.currentState = state;
			this.stateTime = 0;
		}		
	}
	
	public void update(float delta) {		
		if (MOVING == this.currentState) {
			stateTime += delta; 
		}
	}
}
