package com.github.hanyaeger.tutorial.entities.stars;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicEllipseEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class Star extends DynamicEllipseEntity implements SceneBorderCrossingWatcher {

    public Star(Coordinate2D initialLocation, int speed) {
        super(initialLocation, new Size(1, 40));
        setMotion(speed, 0d);
        setOpacity(0.2);
        setStrokeColor(Color.WHITE);
        setFill(Color.LIGHTSKYBLUE);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.BOTTOM) {
            remove();
        }
    }
}

