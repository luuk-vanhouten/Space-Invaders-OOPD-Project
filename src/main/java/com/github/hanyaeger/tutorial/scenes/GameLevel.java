package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.SpaceInvaders;
import com.github.hanyaeger.tutorial.entities.endboss.EndBoss;
import com.github.hanyaeger.tutorial.entities.endboss.EndBossHealthText;
import com.github.hanyaeger.tutorial.entities.enemy.*;
import com.github.hanyaeger.tutorial.entities.player.Player;
import com.github.hanyaeger.tutorial.entities.player.PlayerBullet;
import com.github.hanyaeger.tutorial.entities.player.PlayerHealthText;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    private SpaceInvaders spaceInvaders;

    public GameLevel(SpaceInvaders spaceInvaders) {
        this.spaceInvaders = spaceInvaders;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
        setBackgroundAudio("audio/backgroundmusic2.mp3");
        setBackgroundAudioVolume(0.15);
//        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new EnemySpawner(getWidth()));
//        addEntitySpawner(new StarSpawner(getWidth()));
    }

    @Override
    public void setupEntities() {
        var playerHealthText = new PlayerHealthText(new Coordinate2D(0, 0));
        var endBossHealthText = new EndBossHealthText(new Coordinate2D(0, 40));
        Player player = new Player(new Coordinate2D(getWidth() / 2 - 20, 600), this, spaceInvaders, playerHealthText);
        addEntity(player);
        addEntity(new EndBoss(new Coordinate2D(getWidth() / 2 - 33, 100), spaceInvaders, endBossHealthText));
        addEntity(playerHealthText);
        addEntity(endBossHealthText);
    }

    public void addBullet(Coordinate2D coordinate2D){
  addEntity(new PlayerBullet(coordinate2D));
    }
}
