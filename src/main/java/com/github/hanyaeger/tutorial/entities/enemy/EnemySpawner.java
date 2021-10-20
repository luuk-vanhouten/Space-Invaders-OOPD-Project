package com.github.hanyaeger.tutorial.entities.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.player.Player;

import java.util.Random;

public class EnemySpawner extends EntitySpawner {

    private final double sceneWidth;
    private Player player;

    public EnemySpawner(double sceneWidth) {
        super(1500);
        this.sceneWidth = sceneWidth;
    }

    @Override
    protected void spawnEntities() {
        if(new Random().nextInt(10) < 1){
            spawn(new EnemyTank(randomLocation()));
        }else if(new Random().nextInt(10) < 3){
            spawn(new EnemyFighter(randomLocation()));
        }else if(new Random().nextInt(10) < 4){
            spawn(new EnemyScout(randomLocation()));
        }else{
            spawn(new EnemyGrunt(randomLocation()));
        }
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, 0);
    }
}
