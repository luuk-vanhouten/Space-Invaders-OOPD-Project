package com.github.hanyaeger.tutorial.entities.endboss;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class EndBoss extends DynamicCompositeEntity implements SceneBorderTouchingWatcher{

    private EndBossSprite endBossSprite;

    public EndBoss(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(3, 270d);
    }

    @Override
    protected void setupEntities() {
        endBossSprite = new EndBossSprite(new Coordinate2D(0, 0));
        addEntity(endBossSprite);
        addEntity(new EndBossHitBox(new Coordinate2D(0, 0)));
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                setMotion(3, 90d);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
                setMotion(3, 270d);
            default:
                break;
        }
    }
}
