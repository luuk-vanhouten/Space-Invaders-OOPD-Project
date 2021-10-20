package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.SpaceInvaders;
import com.github.hanyaeger.tutorial.entities.endboss.EndBossBullet;
import com.github.hanyaeger.tutorial.entities.enemy.Enemy;
import com.github.hanyaeger.tutorial.entities.enemy.EnemyBullet;
import com.github.hanyaeger.tutorial.scenes.GameLevel;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicCompositeEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Collider {

    private PlayerSprite playerSprite;
    private GameLevel gameLevel;
    private SpaceInvaders spaceInvaders;
    private int healthPoints;
    private PlayerHealthText healthText;

    public Player(Coordinate2D initialLocation, GameLevel gameLevel, SpaceInvaders spaceInvaders, PlayerHealthText healthText) {
        super(initialLocation);
        this.gameLevel = gameLevel;
        healthPoints = 10;
        this.spaceInvaders = spaceInvaders;
        this.healthText = healthText;
        healthText.setHealthText(healthPoints);
    }

    @Override
    protected void setupEntities() {
        playerSprite = new PlayerSprite(new Coordinate2D(0, 0));
        playerSprite.setCurrentFrameIndex(7);
        addEntity(playerSprite);
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
        if (pressedKeys.contains(KeyCode.SPACE)){
            fireGun();
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
        setMotion(3.5,0d);
    }

    private void fireGun(){
        gameLevel.addBullet(getAnchorLocation());
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

    @Override
    public void onCollision(Collider collider) {
//        if(collider instanceof EnemyBullet || collider instanceof EndBossBullet) {
//            loseHealth();
//        }
        if(collider instanceof Enemy e) {
            e.doDamage(this);
            loseHealth();
        }
    }

    private void loseHealth() {
//        healthPoints--;
        healthText.setHealthText(healthPoints);

        if(healthPoints <= 0){
            spaceInvaders.setActiveScene(3);
        }
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
