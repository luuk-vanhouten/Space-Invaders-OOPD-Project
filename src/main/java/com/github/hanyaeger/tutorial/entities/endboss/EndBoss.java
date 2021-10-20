package com.github.hanyaeger.tutorial.entities.endboss;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.SpaceInvaders;
import com.github.hanyaeger.tutorial.entities.player.PlayerBullet;

public class EndBoss extends DynamicCompositeEntity implements SceneBorderTouchingWatcher, Collided, Collider {

    private EndBossSprite endBossSprite;
    private SpaceInvaders spaceInvaders;
    private int healthPoints;
    private EndBossHealthText healthText;

    public EndBoss(Coordinate2D initialLocation, SpaceInvaders spaceInvaders, EndBossHealthText healthText) {
        super(initialLocation);
        setMotion(3, 270d);
        healthPoints = 100;
        this.spaceInvaders = spaceInvaders;

        this.healthText = healthText;
        healthText.setHealthText(healthPoints);
    }

    @Override
    protected void setupEntities() {
        endBossSprite = new EndBossSprite(new Coordinate2D(0, 0));
        addEntity(endBossSprite);
        
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){

        switch (border) {
            case LEFT, RIGHT -> changeDirection(180);
            default -> {
            }
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof PlayerBullet) {
            loseHealth();
        }
    }

    private void loseHealth() {
        healthPoints--;
        healthText.setHealthText(healthPoints);

        if(healthPoints == 0){
            spaceInvaders.setActiveScene(4);
        }
    }
}
