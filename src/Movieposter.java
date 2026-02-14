import java.awt.*;

public class Movieposter {
    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;
    public int xpos;
    public int ypos;
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
    public Rectangle hitbox;
    public boolean isCrashing;

    public Movieposter(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        width = 1200;
        height = 840;
        isAlive = true;
        hitbox = new Rectangle(xpos, ypos, width, height);
        isCrashing = false;
    }
}
