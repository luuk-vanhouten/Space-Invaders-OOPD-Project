package com.github.hanyaeger.tutorial.entities.endboss;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class EndBossSprite extends DynamicSpriteEntity {

    public EndBossSprite(Coordinate2D initialLocation) {
        super("sprites/endbossship.png", initialLocation, new Size(66, 105), 1, 8);
        setAutoCycle(40);
    }
}
