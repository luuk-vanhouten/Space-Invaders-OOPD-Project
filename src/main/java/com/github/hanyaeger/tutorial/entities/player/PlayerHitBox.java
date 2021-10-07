package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

class PlayerHitBox extends RectangleEntity implements Collider {

    public PlayerHitBox(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(39);
        setHeight(43);
        setFill(Color.TRANSPARENT);
    }
}
