package com.github.hanyaeger.tutorial.entities.endboss;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class EndBoss extends DynamicCompositeEntity implements KeyListener, SceneBorderTouchingWatcher{

    private EndBossSprite endBossSprite;

    public EndBoss(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        endBossSprite = new EndBossSprite(new Coordinate2D(0, 0));
        addEntity(endBossSprite);
        addEntity(new EndBossHitBox(new Coordinate2D(0, 0)));
    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
            moveLeft();
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            moveRight();
        } else if(pressedKeys.contains(KeyCode.UP)){
            moveForward();
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            moveBackward();
        } else if(pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }

    private void moveLeft(){
        setMotion(5,270d);
    }

    private void moveRight(){
        setMotion(5,90d);
    }

    private void moveForward(){
        setMotion(5,180d);
    }

    private void moveBackward(){
        setMotion(5,0d);
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
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }
}
