package com.github.hanyaeger.tutorial.entities.stars;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class StarSpawner extends EntitySpawner {

    private final double sceneWidth;

    public StarSpawner(double sceneWidth) {
        super(10);
        this.sceneWidth = sceneWidth;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Star(randomLocation(), 20));
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, 0);
    }
}
