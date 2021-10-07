package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PlayerSprite extends DynamicSpriteEntity {

    public PlayerSprite(Coordinate2D initialLocation) {
        super("sprites/playerspritemap.png", initialLocation,new Size(39,43), 3, 3);
    }

    public void turnLeft() {
        setCurrentFrameIndex(6);
    }

    public void turnRight() {
        setCurrentFrameIndex(8);
    }

    public void goForwards() {
        setCurrentFrameIndex(4);
    }

    public void goBackwards() {
        setCurrentFrameIndex(1);
    }

    public void stayStill() {
        setCurrentFrameIndex(7);
    }
}

