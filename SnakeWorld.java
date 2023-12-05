import greenfoot.*;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

//world map image is under GNU Free Documentation License
public class SnakeWorld extends World {
    static String[] locations = {"China", "Japan", "South Korea", "North Korea", "Russia", "Mongolia", "Nepal", "Bhutan", "Bangladesh", "India", "Myanmar", "Thailand", "Laos", "Vietnam", "Cambodia", "Malaysia", "Indonesia", "Brunei", "Singapore", "Pakistan", "Afghanistan", "Tajikistan", "Uzbekistan", "Kyrgyztan", "Kazakhstan", "Turkmenistan", "Sri Lanka", "Philippines"};
    static int[][] foodLocations = {{417, 274}, {719, 126}, {627, 169}, {598, 137}, {241, 72}, {368,131}, {233, 356}, {300, 361}, {302, 398}, {169, 439}, {363, 420}, {428, 471}, {434, 425}, {468, 401}, {469, 503}, {450, 613}, {582, 645}, {592, 568}, {473, 639}, {84, 342}, {55, 287}, {99, 232}, {58, 204}, {154, 204}, {121, 128}, {25, 230}, {205, 595}, {648, 433}};  
    public static int score = 0;
    public static int correctIndex = -1;
    private int previousCorrect;
    private snake snakeObj = new snake();
    public static int lives = 3; //number of lives
    private int numOfFood = 4; // Config for number of food on screen at a time
    
    public SnakeWorld() {
        super(758, 750, 1);
        addObject(this.snakeObj, getWidth() / 2, getHeight() / 2);
        score = 0;
        lives = 3;
        refreshFood();
    }
    
    public void act(){
      showText("Score : " + score, 100, 50);
      showText("Lives : " + lives, 100, 100);
      showText("Country: " + locations[correctIndex], 575, 50);   
    }
    
    
    //add locations of dots
    public void refreshFood() {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < locations.length; i++) {
            double distX = Math.pow((this.snakeObj.getX()-foodLocations[i][0]), 2);
            double distY = Math.pow((this.snakeObj.getY()-foodLocations[i][1]), 2);
            // Calculate a dot's distance from the snake
            double dist = Math.sqrt(distX+distY);
            // Only put the dot in the pool if the dot is more than 70 pixels from the snake
            if (dist > 70) {
                nums.add(i);
            }
            
        }
        
        // Generate a sequence of random numbers
        Collections.shuffle(nums);
        // Designate a dot as the correct answer       
        correctIndex = nums.get(Greenfoot.getRandomNumber(numOfFood));
        
        // Pull the first 'x' numbers in the list
        // Use them as indexes for in the coords list
        for (int i = 0; i < this.numOfFood; i++) {
            int index = nums.get(i);
            
            // For debugging purposes
            // Set the correct dot color to green
            /*
            if (correctIndex == index) {
                addObject(new Food(0), foodLocations[index][0], foodLocations[index][1]);
                continue;
            }
            */
            addObject(new Food(1), foodLocations[index][0], foodLocations[index][1]);
        }
        
    }
}
