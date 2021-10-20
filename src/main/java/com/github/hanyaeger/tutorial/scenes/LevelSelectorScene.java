package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.SpaceInvaders;
import com.github.hanyaeger.tutorial.entities.buttons.EasyButton;
import com.github.hanyaeger.tutorial.entities.buttons.HardButton;
import com.github.hanyaeger.tutorial.entities.buttons.NormalButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevelSelectorScene extends StaticScene {

    private SpaceInvaders spaceInvaders;

    public LevelSelectorScene(SpaceInvaders spaceInvaders) {
        this.spaceInvaders = spaceInvaders;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.jpg");
        setBackgroundAudio("audio/backgroundmusic1.mp3");
        setBackgroundAudioVolume(0.5);
    }

    @Override
    public void setupEntities() {
        var levelSelectorText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2.5), "Select Difficulty");
        var easyButton = new EasyButton(new Coordinate2D(getWidth() / 2, 400), spaceInvaders);
        var normalButton = new NormalButton(new Coordinate2D(getWidth() / 2, 450), spaceInvaders);
        var hardButton = new HardButton(new Coordinate2D(getWidth() / 2, 500), spaceInvaders);

        levelSelectorText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        levelSelectorText.setFill(Color.LIGHTSKYBLUE);
        levelSelectorText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        easyButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        normalButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        hardButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);


        addEntity(levelSelectorText);
        addEntity(easyButton);
        addEntity(normalButton);
        addEntity(hardButton);
    }
}
