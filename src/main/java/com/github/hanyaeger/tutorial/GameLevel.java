package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupEntitySpawners() {
    }
}
