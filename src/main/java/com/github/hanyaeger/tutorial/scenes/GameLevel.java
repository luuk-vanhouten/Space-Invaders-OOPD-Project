package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.entities.endboss.EndBoss;
import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.player.PlayerBullet;
import com.github.hanyaeger.tutorial.entities.stars.StarSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntitySpawners() {
       addEntitySpawner(new StarSpawner(getWidth()));
    }

    @Override
    public void setupEntities() {
        addEntity(new Player(new Coordinate2D(getWidth() / 2 - 20, 600), this));
        addEntity(new EndBoss(new Coordinate2D(getWidth() / 2 - 33, 100)));
    }

    public void addBullet(Coordinate2D coordinate2D){
  addEntity(new PlayerBullet(coordinate2D));
    }
}
