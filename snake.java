import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class snake extends Actor {
    private int speed = 3;
    private int length = 1;
    SnakeWorld thisGame;
    public void act() {
        checkKeyPress();
        move(speed);
        checkCollision();
    }

    private void checkKeyPress() {
        if (Greenfoot.isKeyDown("up")) {
            setRotation(270);
        } else if (Greenfoot.isKeyDown("down")) {
            setRotation(90);
        } else if (Greenfoot.isKeyDown("left")) {
            setRotation(180);
        } else if (Greenfoot.isKeyDown("right")) {
            setRotation(0);
        }
    }

    private void checkCollision() {
        eatAvailableDot();

        if (isTouching(snake.class)) {
            Greenfoot.stop();
        }

        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1 || getY() <= 0 || getY() >= getWorld().getHeight() - 1) {
            Greenfoot.stop();
        }
    }
    
    private void eatAvailableDot() {
        Actor dot = getOneIntersectingObject(Food.class);
        if (dot != null) {
            int[] pos = {dot.getX(), dot.getY()};
            getWorld().removeObjects(getWorld().getObjects(Food.class));
            int[] correctPos = {SnakeWorld.foodLocations[SnakeWorld.correctIndex][0], SnakeWorld.foodLocations[SnakeWorld.correctIndex][1]};
            if (pos[0] == correctPos[0] && pos[1] == correctPos[1]) {
                // Correct dot
                SnakeWorld.score++;
                Greenfoot.playSound("crunch.wav");
            } else {
                // Subtract score here, or lose a life?
                SnakeWorld.lives--;
                if (SnakeWorld.lives <= 0) {
                    Greenfoot.stop();
                }
            }
            // Place new dots
            ((SnakeWorld)getWorld()).refreshFood();     
        }
    }
}
