package com.github.hanyaeger.tutorial.entities.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class EnemyScout extends Enemy{

    public EnemyScout(Coordinate2D initialLocation) {
        super("sprites/spaceship2.png", initialLocation, 6, new Size(45, 41), 3);
    }

    @Override
    public void doDamage(Player player) {
        player.setHealthPoints(player.getHealthPoints() - 1);
    }
}
