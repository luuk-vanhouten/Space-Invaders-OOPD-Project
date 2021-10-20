package com.github.hanyaeger.tutorial.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
 
public class PlayerHealthText extends TextEntity {

    public PlayerHealthText(Coordinate2D initialLocation){
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.LIGHTSKYBLUE);
    }

    public void setHealthText(int health){
        setText("Player HP: " + health);
    }

}
