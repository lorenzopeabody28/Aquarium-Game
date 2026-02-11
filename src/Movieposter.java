import java.awt.*;

public class Movieposter {
    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
    public Rectangle hitbox;
    public boolean isCrashing;

    public Movieposter(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        width = 160;
        height = 160;
        isAlive = true;
        hitbox = new Rectangle(xpos, ypos, width, height);
        isCrashing = false;
    }
}
