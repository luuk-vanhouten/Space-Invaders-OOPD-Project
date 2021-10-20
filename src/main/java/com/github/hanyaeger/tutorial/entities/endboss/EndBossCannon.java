package com.github.hanyaeger.tutorial.entities.endboss;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class EndBossCannon extends EntitySpawner {

    private Coordinate2D initialLocation;

    protected EndBossCannon(Coordinate2D initialLocation, long intervalInMs) {
        super(intervalInMs);
        this.initialLocation = initialLocation;
    }

    @Override
    protected void spawnEntities() {
        spawn(new EndBossBullet(initialLocation));
    }
}
