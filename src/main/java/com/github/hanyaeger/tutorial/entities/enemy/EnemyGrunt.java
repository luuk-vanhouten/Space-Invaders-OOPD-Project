package com.github.hanyaeger.tutorial.entities.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.player.Player;

public class EnemyGrunt extends Enemy {

    public EnemyGrunt(Coordinate2D initialLocation) {
        super("sprites/spaceship1.png", initialLocation, 3, new Size(40, 40), 3);
    }

    @Override
    public void doDamage(Player player) {
        player.setHealthPoints(player.getHealthPoints() - 1);
    }
}
