package com.maycon.components;

public enum AnimKey {
	TANK(0, 0), TURRET(18, 0), BULLET(0,0);

	private final float adjustX;
	private final float adjustY;

	private AnimKey(float adjustX, float adjustY) {
		this.adjustX = adjustX;
		this.adjustY = adjustY;
	}

	public float getAdjustX() {
		return adjustX;
	}

	public float getAdjustY() {
		return adjustY;
	}

}
