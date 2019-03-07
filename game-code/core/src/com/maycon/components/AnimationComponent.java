package com.maycon.components;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AnimationComponent implements Component {
	public Map<AnimKey, Animation<Sprite>> animations = new HashMap<AnimKey, Animation<Sprite>>();
}
