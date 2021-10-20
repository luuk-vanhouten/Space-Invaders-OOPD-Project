package com.github.hanyaeger.tutorial.entities.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.player.PlayerBullet;

import java.util.Random;

public abstract class Enemy extends DynamicSpriteEntity implements Collided, Collider, SceneBorderTouchingWatcher, SceneBorderCrossingWatcher {

    private int healthPoints;

    public Enemy(String resource, Coordinate2D initialLocation, int healthPoints, Size size, int speed) {
        super(resource, initialLocation, size);
        this.healthPoints = healthPoints;
        setMotion(speed, new Random().nextInt(360));
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof PlayerBullet) {
            loseHealth();
        }
        if (collider instanceof Player) {
            remove();
        }
    }

    private void loseHealth() {
        healthPoints--;

        if(healthPoints == 0){
            remove();
        }
    }

    public abstract void doDamage(Player player) ;

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {

        switch (border) {
            case LEFT, RIGHT, TOP, BOTTOM-> setDirection(new Random().nextInt(360));
            default -> {
            }
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case LEFT, RIGHT, TOP, BOTTOM-> remove();
            default -> {
            }
        }
    }
}