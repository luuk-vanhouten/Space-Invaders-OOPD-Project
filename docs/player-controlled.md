# Adding a player controlled entity

The player will control Hanny by using the arrow keys. Again we will use
a `DynamicSpriteEntity`.

<<<<<<< HEAD
![Edit](images/edit.png) Create a new Class for Hanny in the same package as
SwordFish . Make sure Hanny is placed at the top left corner of the Scene.
=======
![Edit](images/edit.png) Create a class for Hanny in the same package as
`SwordFish`. Make sure Hanny is placed in the top left corner of the scene.
>>>>>>> development

![Hanny](images/game/hanny.png)

You might notice that the image of Hanny contains two Hannies. This approach is
a standard way to animate a figure in a game. The image itself contains multiple
<<<<<<< HEAD
sprites, and the Game Engine is responsible for showing only one of those
=======
sprites, and the game engine is responsible for showing only one of those
>>>>>>> development
sprites, or cycling through them to create the impression of movement.

Yaeger supports this through its `DynamicSpriteEntity`, by explicitly stating
the number of rows and columns of sprites an image contains. In case of Hanny,
we have one row, that contains two columns. By default, a `DynamicSpriteEntity`
assumes the image contains only one sprite, but by calling the correct
constructor, we can change this.

![Edit](images/edit.png) With this in mind, the constructor of `Hanny` should
look like:

```java
public Hanny(Coordinate2D location){
<<<<<<< HEAD
        super("sprites/hanny.png",location,new Size(20,40),1,2);
        }
=======
    super("sprites/hanny.png",location,new Size(20,40), 1, 2);
}
>>>>>>> development
```

![Edit](images/edit.png) Now use the `setupEntities()` from the `GameLevel` to
add `Hanny`. Place her in the top left corner of the screen.

## Animate Hanny

To animate Hanny, we are going to let her listen to user input through the
<<<<<<< HEAD
keyboard. As with the
`MouseButtonPressedListener`, we are going to add an interface. In its event
handler, we are going to call
`setMotion()`, so we can change the direction based on the key being pressed.
When no buttons are pressed, we use
`setSpeed(0)` to make sure Hanny keeps her location.
=======
keyboard. As with the `MouseButtonPressedListener`, we are going to add an 
interface. In its event handler, we are going to call `setMotion()`, so we 
can change the direction based on the key being pressed. When no buttons are 
pressed, we use `setSpeed(0)` to make sure Hanny keeps her location.
>>>>>>> development

![Edit](images/edit.png) Let `Hanny` implement the interface `KeyListener` and
implement the event handler in the following way:

```java
@Override
public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        if(pressedKeys.contains(KeyCode.LEFT)){
        setMotion(3,270d);
        }else if(pressedKeys.contains(KeyCode.RIGHT)){
        setMotion(3,90d);
        }else if(pressedKeys.contains(KeyCode.UP)){
        setMotion(3,180d);
        }else if(pressedKeys.contains(KeyCode.DOWN)){
        setMotion(3,0d);
        }else if(pressedKeys.isEmpty()){
        setSpeed(0);
        }
        }
```

Notice how the event handler receives a `Set<KeyCode>`. This `Set` will contain
all the keys that are currently being pressed. Depending on which keys are in
this `Set`, we set the motion of Hanny.

## Change the frame index depending on the direction of the Hanny

We must still change the frame index depending on the direction of Hanny. For
<<<<<<< HEAD
this, a `DynamicSpriteEntity`
provides the method ` setCurrentFrameIndex(int)`.
=======
this, a `DynamicSpriteEntity` provides the method ` setCurrentFrameIndex(int)`.
>>>>>>> development

![Edit](images/edit.png) Set the correct frame index. Make sure only the left
and right buttons change the direction in which Hanny seems to be swimming.

## Make sure Hanny doesn't leave the scene

<<<<<<< HEAD
To ensure that Hanny remains on the Scene, we can use the
interface `SceneBorderTouchingWatcher`, which provides an event handler that
gets called whenever the Entity touches the border of the Scene. By implementing
this Interface, the Entity needs to implement the
method `void notifyBoundaryTouching(SceneBorder)`, which receives which of the
four borders was touched. We can use this the set either the `x` or `y`
coordinate of Hanny to ensure she remains within the Scene. Besides that, we
=======
To ensure that Hanny remains on the screen, we can use the interface 
`SceneBorderTouchingWatcher`, which provides an event handler that gets called 
whenever the entity touches the border of the scene. By implementing this 
interface, the entity needs to implement the method 
`void notifyBoundaryTouching(SceneBorder)`, which receives which of the four 
borders was touched. We can use this the set either the x or 
y-coordinate of Hanny to ensure she remains within the screen. Besides that, we
>>>>>>> development
also set her speed to 0.

```java
@Override
public void notifyBoundaryTouching(SceneBorder border){
    setSpeed(0);

    switch(border){
        case TOP:
            setAnchorLocationY(1);
            break;
        case BOTTOM:
            setAnchorLocationY(getSceneHeight()-getHeight()-1);
            break;
        case LEFT:
            setAnchorLocationX(1);
            break;
        case RIGHT:
            setAnchorLocationX(getSceneWidth()-getWidth()-1);
        default:
            break;
        }
}
```

<<<<<<< HEAD
Note that when Hanny is initially being placed on the Scene, we should make sure
she doesn't touch the Scene Border, because that will lead to strange unwanted
behaviour.

![Edit](images/edit.png) Implement the interface `SceneBorderTouchingWatcher`
and use the event handler to ensure that Hanny doesn't leave the Scene.

## Make Hanny experience gravity and friction

Yaeger supports a simple approach to enable gravity and friction, which van be
enabled by implementing the `Newtonian`
interface. With that interface the Entity will continually experience
gravitational pull and friction whenever it moves. To learn more about this
interface, have a look at
the [API](https://han-yaeger.github.io/yaeger/hanyaeger.api/com/github/hanyaeger/api/engine/entities/entity/motion/Moveable.html)
=======
Note that when Hanny is initially being placed on the scene, we should make sure
she doesn't touch the scene border, because that will lead to strange unwanted
behaviour.

![Edit](images/edit.png) Implement the interface `SceneBorderTouchingWatcher`
and use the event handler to ensure that Hanny doesn't leave the screen.

## Make Hanny experience gravity and friction

Yaeger supports a simple approach to enable gravity and friction, which can be
enabled by implementing the `Newtonian` interface. With that interface the 
entity will continually experience gravitational pull and friction whenever 
it moves. To learn more about this interface, have a look at
the [API](https://han-yaeger.github.io/yaeger/hanyaeger/com/github/hanyaeger/core/entities/motion/Movable.html)
>>>>>>> development
.

![Edit](images/edit.png) Add the interface `Newtonian` to Hanny and add the
following two lines to Hanny's constructor:

```java
setGravityConstant(0.005);
setFrictionConstant(0.04);
```

They will ensure very low gravity and high friction, which would be the case
when swimming in the ocean.

Last thing to do, is to make sure Hanny does not stop swimming when none of the
arrow buttons are pressed. To do this remove the following line from the event
handler from the `KeyListener` interface:

```java
else if(pressedKeys.isEmpty()){
    setSpeed(0);
}
```

![Edit](images/edit.png) Change the event handler from the `KeyListener`
interface to ensure the speed is no longer set to 0.

## Add a game over scene for when health reaches zero

<<<<<<< HEAD
When health reaches 0 Hanny dies, and the player should see a new Scene
containing the text Game Over, with below it the clickable text *Play again*. We
have seen all of Yaeger's features that are required for this, so it should be
clear how to implement this.
=======
When health reaches 0 Hanny dies, and the player should see a new scene
containing the text *Game Over*, with below it the clickable text *Play 
again*. We have seen all of Yaeger's features that are required for this, so 
it should be clear how to implement this.
>>>>>>> development

![Edit](images/edit.png) Add a *Game Over* scene with a *Play Again* button.
Clicking the *Play Again* button should load the Game Level Scene.

![Edit](images/edit.png) Change the event handler in Hanny in such a way that
<<<<<<< HEAD
when the health reaches zero, the Game Over Scene is loaded.
=======
when the health reaches zero, the Game Over scene is loaded.
>>>>>>> development

## Add a quit game button to the game over scene

![Edit](images/edit.png) Add a second button to the *Game Over* scene. Clicking
<<<<<<< HEAD
this button should quit Yaeger. The Class
`YaegerGame` provides a method to quit the game, so use
the [JavaDoc](https://han-yaeger.github.io/yaeger/hanyaeger.api/com/github/hanyaeger/api/engine/YaegerGame.html)
=======
this button should quit Yaeger. The class `YaegerGame` provides a method to 
quit the game, so use
the [JavaDoc](https://han-yaeger.github.io/yaeger/hanyaeger/com/github/hanyaeger/api/YaegerGame.html)
>>>>>>> development
to figure out which one it is.

![Run](images/play.png) Run the game and test if the quit button works.
