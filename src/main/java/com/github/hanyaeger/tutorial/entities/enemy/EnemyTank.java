package com.github.hanyaeger.tutorial.entities.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class EnemyTank extends Enemy{

    public EnemyTank(Coordinate2D initialLocation) {
        super("sprites/spaceship5.png", initialLocation, 9, new Size(50, 100), 1);
    }

    @Override
    public void doDamage(Player player) {
        player.setHealthPoints(player.getHealthPoints() - 3);
    }
}
