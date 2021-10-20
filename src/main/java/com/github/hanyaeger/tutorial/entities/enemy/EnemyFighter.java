package com.github.hanyaeger.tutorial.entities.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class EnemyFighter extends Enemy{

    public EnemyFighter(Coordinate2D initialLocation) {
        super("sprites/spaceship4.png", initialLocation, 6, new Size(40, 47), 4);
    }

    @Override
    public void doDamage(Player player) {
        player.setHealthPoints(player.getHealthPoints() - 2);
    }
}