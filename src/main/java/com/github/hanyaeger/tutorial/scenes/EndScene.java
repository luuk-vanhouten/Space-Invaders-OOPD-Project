package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.SpaceInvaders;
import com.github.hanyaeger.tutorial.entities.buttons.EndButton;
import com.github.hanyaeger.tutorial.entities.buttons.PlayAgainButton;

public class EndScene extends StaticScene {

    private SpaceInvaders spaceInvaders;

    public EndScene(SpaceInvaders spaceInvaders) {
        this.spaceInvaders = spaceInvaders;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.jpg");
    }

    @Override
    public void setupEntities() {
        var endButton = new EndButton(new Coordinate2D(getWidth() / 2, getHeight() / 1.8), spaceInvaders);
        var playAgainButton = new PlayAgainButton(new Coordinate2D(getWidth() / 2, getHeight() / 2.3), spaceInvaders);

        endButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        playAgainButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(endButton);
        addEntity(playAgainButton);
    }
}
