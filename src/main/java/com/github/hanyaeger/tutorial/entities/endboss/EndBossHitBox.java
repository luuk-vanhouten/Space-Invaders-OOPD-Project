package com.github.hanyaeger.tutorial.entities.endboss;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

class EndBossHitBox extends RectangleEntity implements Collider {

    public EndBossHitBox(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(66);
        setHeight(105);
        setFill(Color.TRANSPARENT);
    }
}
