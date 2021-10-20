package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.SpaceInvaders;
import com.github.hanyaeger.tutorial.entities.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private SpaceInvaders spaceInvaders;

    public TitleScene(SpaceInvaders spaceInvaders){
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
        var spaceInvadersText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2.3), "Space Invaders");
        var startButton = new StartButton(new Coordinate2D(getWidth() / 2, 475), spaceInvaders);

        spaceInvadersText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        spaceInvadersText.setFill(Color.LIGHTSKYBLUE);
        spaceInvadersText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(spaceInvadersText);
        addEntity(startButton);


    }
}
