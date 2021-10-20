package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.endboss.EndBoss;
import com.github.hanyaeger.tutorial.entities.enemy.Enemy;
import javafx.scene.paint.Color;

public class PlayerBullet extends DynamicCircleEntity implements SceneBorderCrossingWatcher, Collider, Collided {


    public PlayerBullet(Coordinate2D initialLocation) {
        super(initialLocation);
        setRadius(3);
        setMotion(15, 180d);
        setStrokeColor(Color.BLUE);
        setFill(Color.DEEPSKYBLUE);
        new SoundClip("audio/lasergunsound.wav").play();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.TOP) {
            remove();
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof EndBoss || collider instanceof Enemy) {
            remove();
        }
    }
}
