package com.maycon.components;


import java.util.LinkedList;
import java.util.List;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteComponent implements Component {
	public final List<Sprite> sprites = new LinkedList<Sprite>();
}
