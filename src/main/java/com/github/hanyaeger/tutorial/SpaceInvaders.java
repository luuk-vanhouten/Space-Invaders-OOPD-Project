package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class SpaceInvaders extends YaegerGame {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Space Invaders");
        setSize(new Size(800, 800));
    }


    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new LevelSelectorScene(this));
        addScene(2, new GameLevel());
        addScene(3, new EndScene(this));
    }
}