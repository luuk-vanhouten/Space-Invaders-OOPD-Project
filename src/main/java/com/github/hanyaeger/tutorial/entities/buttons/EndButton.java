package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.SpaceInvaders;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private SpaceInvaders spaceInvaders;

    public EndButton(Coordinate2D initialLocation, SpaceInvaders spaceInvaders){
        super(initialLocation,"End Game");
        setFill(Color.BLUEVIOLET);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        this.spaceInvaders = spaceInvaders;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        spaceInvaders.quit();
    }

    @Override
    public void onMouseEntered(){
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.BLUEVIOLET);
        setCursor(Cursor.DEFAULT);
    }
}
