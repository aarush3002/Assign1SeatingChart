import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.Random;
/**
 *
 * 
 * @author Aarush Aitha, CSA Per. 3
 * @version 2.0 Aug 16, 2019
 */
public class AarushAitha extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the AarushAitha class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public AarushAitha(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public AarushAitha() {
       firstName="Aarush";
       lastName="Aitha";
       myRow=1;
       mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
       soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
       setImage(portraitFile);
       sitting=true;
    }
    
     /**
     * Act - do whatever the AarushAitha actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to program!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            }
            else {
                answerQuestion();
                sitDown();
            }
                    
        }
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know?");
        boolean flag = true;
        while (flag)
        {
            if (q.contains("hard")){
                q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");
                flag = false;
            }
            else if (q.contains("easy")){
                q=Greenfoot.ask("for and while loops, variables, and array lists... May I sit down?");
                flag = false;
            }
            else {
                q=Greenfoot.ask("I don't understand the question! What would you like to know?"); 
            }
        }
        flag = true;
        while (flag){
            if (q.equals("yes")){
                sitDown();
                flag = false;
            }
            else {
                q=Greenfoot.ask("Please! May I sit down?");
            }
        }
    }
    /**
     * This is a local method specific to the AarushAitha class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        int[][] coords = new int[50][2];
        for (int row = 0; row < coords.length; row++) {
            for (int col = 0; col < coords[row].length; col++) {
                if (col == 0){
                    coords[row][col] = (int)(Math.random() * 9 + 1);
                }
                if (col == 1){
                    coords[row][col] = (int)(Math.random() * 5 + 1);
                }
            }
        }
        for (int row = 0; row < coords.length; row++) {
            setLocation(coords[row][0], coords[row][1]);
            getImage().rotate((int)(Math.random() * 360 + 1));
            Greenfoot.delay(5);
        }
        setImage(standingFile);
        Greenfoot.delay(2);
        returnToSeat();
    }
     public void myHobby(String s) {
         System.out.println(s);
}

}