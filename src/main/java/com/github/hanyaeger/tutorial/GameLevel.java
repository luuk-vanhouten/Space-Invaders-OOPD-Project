package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.endboss.EndBoss;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        addEntity(new Player(new Coordinate2D(getWidth() / 2 - 20, 600)));
        addEntity(new EndBoss(new Coordinate2D(getWidth() / 2 - 33, 100)));
    }

    @Override
    public void setupEntitySpawners() {
    }
}
