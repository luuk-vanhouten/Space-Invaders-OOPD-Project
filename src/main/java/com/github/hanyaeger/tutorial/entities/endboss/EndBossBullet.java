package com.github.hanyaeger.tutorial.entities.endboss;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class EndBossBullet extends DynamicCircleEntity implements SceneBorderCrossingWatcher, Collider, Collided {

    public EndBossBullet(Coordinate2D initialLocation) {
        super(initialLocation);
        setRadius(5);
        setMotion(10, 180d);
        setStrokeColor(Color.ORANGE);
        setFill(Color.ORANGERED);
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.TOP) {
            remove();
        }
    }

    @Override
    public void onCollision(Collider collider) {
        remove();
    }
}
