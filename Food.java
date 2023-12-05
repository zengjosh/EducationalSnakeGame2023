import greenfoot.*;

public class Food extends Actor {

    public Food(int color) {
        GreenfootImage foodImage = new GreenfootImage(25, 25);
        
        // For debugging purposes
        // See which dot should be correct (the green dot)
        if (color == 0) {
            foodImage.setColor(Color.GREEN);
        } else {
            foodImage.setColor(Color.RED);
        }
        foodImage.fillOval(0, 0, 15, 15);
        setImage(foodImage);
    }

    public void act(){
 
    }
}
