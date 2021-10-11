package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class PlayerBullet extends DynamicCircleEntity implements SceneBorderCrossingWatcher {


    public PlayerBullet(Coordinate2D initialLocation) {
        super(initialLocation);
        setRadius(3);
        setMotion(15, 180d);
        setStrokeColor(Color.BLUE);
        setFill(Color.DEEPSKYBLUE);
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.TOP) {
            remove();
        }
    }
}
