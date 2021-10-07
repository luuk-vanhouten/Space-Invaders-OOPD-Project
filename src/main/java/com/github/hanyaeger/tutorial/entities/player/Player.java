package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicCompositeEntity implements KeyListener {

    private PlayerSprite playerSprite;

    public Player(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        playerSprite = new PlayerSprite(new Coordinate2D(0, 0));
        playerSprite.setCurrentFrameIndex(7);
        addEntity(playerSprite);
        addEntity(new PlayerHitBox(new Coordinate2D(0, 0)));
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.A)){
            moveLeft();
            playerSprite.turnLeft();
        } else if(pressedKeys.contains(KeyCode.D)){
            moveRight();
            playerSprite.turnRight();
        } else if(pressedKeys.contains(KeyCode.W)){
            moveForward();
            playerSprite.goForwards();
        } else if(pressedKeys.contains(KeyCode.S)){
            moveBackward();
            playerSprite.goBackwards();
        } else if(pressedKeys.isEmpty()){
            setSpeed(0);
            playerSprite.stayStill();
        }
    }

    private void moveLeft(){
        setMotion(4,270d);
    }

    private void moveRight(){
        setMotion(4,90d);
    }

    private void moveForward(){
        setMotion(5,180d);
    }

    private void moveBackward(){
        setMotion(3,0d);
    }
}
