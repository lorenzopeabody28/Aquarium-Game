import java.awt.*;

/**
 * Created by chales on 11/6/2017.
 */
public class Nemo {

    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;                //holds the name of the character
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the character in the x direction
    public int dy;                    //the speed of the character in the y direction
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the character is alive or dead.
    public Rectangle hitbox;


    // METHOD DEFINITION SECTION

    // Constructor Definition
    // A constructor builds the object when called and sets variable values.


    //This is a SECOND constructor that takes 2 parameters.  This allows us to specify the character's name and position when we build it.
    // if you put in a String, an int and an int the program will use this constructor instead of the one above.
    public Nemo(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx = 5;
        dy = 5;
        width = 85;
        height = 85;
        isAlive = true;
        hitbox = new Rectangle(xpos, ypos, width, height);

    } // constructor

    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {
        if (xpos < 0) { //bounce off the left wall
            dx = -dx;
        }
        if (xpos > 1200-width) { //bounce off right wall
            dx = -dx;
        }
        if (ypos < 0) {    //bounce off top
            dy = -dy;
        }
        if (ypos > 840-height) { //bounce off bottom
            dy = -dy;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;

        hitbox = new Rectangle(xpos, ypos, width, height);


        //todo: bounce off all walls

    }
}

