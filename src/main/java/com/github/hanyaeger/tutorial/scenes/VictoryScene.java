package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.SpaceInvaders;
import com.github.hanyaeger.tutorial.entities.buttons.EndButton;
import com.github.hanyaeger.tutorial.entities.buttons.PlayAgainButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VictoryScene extends StaticScene {

    private SpaceInvaders spaceInvaders;

    public VictoryScene(SpaceInvaders spaceInvaders) {
        this.spaceInvaders = spaceInvaders;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.jpg");
        setBackgroundAudio("audio/victorysound.mp3");
        setBackgroundAudioVolume(0.5);
    }

    @Override
    public void setupEntities() {
        var youWonText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2.5), "You Won!");
        var endButton = new EndButton(new Coordinate2D(getWidth() / 2, 400), spaceInvaders);
        var playAgainButton = new PlayAgainButton(new Coordinate2D(getWidth() / 2, 450), spaceInvaders);

        youWonText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        youWonText.setFill(Color.LIGHTSKYBLUE);
        youWonText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        endButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        playAgainButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(youWonText);
        addEntity(endButton);
        addEntity(playAgainButton);
    }
}
