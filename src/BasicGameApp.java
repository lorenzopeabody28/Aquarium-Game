//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1215;
    final int HEIGHT = 840;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    // Declare image variables to store pictures for each character and background
    public Image backgroundPic;
    public Image nemoPic;
    public Image doryPic;
    public Image brucePic;
    public Image hankPic;
    public Image squirtPic;
    public Image bloatPic;
    public Image winPic;

    //Declare the objects used in the program
    //These are things that are made up of more than one variable type
    // Declare game character objects for each character in the game
    public Nemo nemo1;
    public Dory dory1;
    public Bruce bruce1;
    public Hank hank1;
    public Squirt squirt1;
    public Bloat bloat1;


    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // Constructor Method
    // This has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() {

        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game and load up

        //creates random spawn location for characters
        int randu;
        int randv;
        int randw;
        int randx;
        int randy;
        int randz;
        randu = (int) (Math.random() * 1050) + 1;
        randv = (int) (Math.random() * 740) + 1;
        randw = (int) (Math.random() * 1050) + 1;
        randx = (int) (Math.random() * 740) + 1;
        randy = (int) (Math.random() * 1050) + 1;
        randz = (int) (Math.random() * 740) + 1;

        backgroundPic = Toolkit.getDefaultToolkit().getImage("CoralB.jpg");

        // loads nemoPic, creates a nemo character at a random position, and tells nemo their speed and direction
        nemoPic = Toolkit.getDefaultToolkit().getImage("Nemo.png"); //load the picture
        nemo1 = new Nemo(randu, randv);
        nemo1.dx = 7;
        // loads doryPic, creates a dory character at a random position, and tells dory their speed and direction
        doryPic = Toolkit.getDefaultToolkit().getImage("Dory.png"); //load the picture
        dory1 = new Dory(randw, randx);
        dory1.dx = 7;
        // loads brucePic, creates a bruce character at a random position, and tells bruce their speed and direction
        brucePic = Toolkit.getDefaultToolkit().getImage("Bruce.png"); //load the picture
        bruce1 = new Bruce(randy, randz);
        bruce1.dx = 5;
        // loads hankPic, creates a hank character at a random position, and tells hank their speed and direction
        hankPic = Toolkit.getDefaultToolkit().getImage("Hank.png"); //load the picture
        hank1 = new Hank(randu, randx);
        hank1.dx = 3;
        // loads squirtPic, creates a squirt character at a random position, and tells squirt their speed and direction
        squirtPic = Toolkit.getDefaultToolkit().getImage("Squirt.png"); //load the picture
        squirt1 = new Squirt(randw, randz);
        squirt1.dx = 6;
        // loads bloatPic, creates a bloat character at a random position, and tells bloat his speed and direction
        bloatPic = Toolkit.getDefaultToolkit().getImage("Bloat.png"); //load the picture
        bloat1 = new Bloat(randy, randz);
        bloat1.dx = 6;


        //asteroid1 = new Asteroid(467, randy);
        //asteroid1.dx = - asteroid1.dx;
        // asteroid2 = new Asteroid(randx, 267);;


    }// BasicGameApp()


//*******************************************************************************
//User Method Section
//
// put your code to do things here.


    // main thread
    // this is the code that plays the game after you set things up
    public void run() {

        //if only one character is left, the win screen will be displayed

        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(20); // sleep for 10 ms
            //if bloat is the only one alive then the winPic is displayed
            if (bloat1.isAlive == true && bruce1.isAlive == false && dory1.isAlive == false && hank1.isAlive == false && nemo1.isAlive == false && squirt1.isAlive == false) {
                winPic = Toolkit.getDefaultToolkit().getImage("Movieposter.jpg");
            }
            //if dory is the only one alive then the winPic is displayed
            else if (bloat1.isAlive == false && bruce1.isAlive == false && dory1.isAlive == true && hank1.isAlive == false && nemo1.isAlive == false && squirt1.isAlive == false) {
                winPic = Toolkit.getDefaultToolkit().getImage("Movieposter.jpg");
            }
            //if bruce is the only one alive then the winPic is displayed
            else if (bloat1.isAlive == false && bruce1.isAlive == true && dory1.isAlive == false && hank1.isAlive == false && nemo1.isAlive == false && squirt1.isAlive == false) {
                winPic = Toolkit.getDefaultToolkit().getImage("Movieposter.jpg");
            }
            //if hank is the only one alive then the winPic is displayed
            else if (bloat1.isAlive == false && bruce1.isAlive == false && dory1.isAlive == false && hank1.isAlive == true && nemo1.isAlive == false && squirt1.isAlive == false) {
                winPic = Toolkit.getDefaultToolkit().getImage("Movieposter.jpg");
            }
            //if nemo is the only one alive then the winPic is displayed
            else if (bloat1.isAlive == false && bruce1.isAlive == false && dory1.isAlive == false && hank1.isAlive == false && nemo1.isAlive == true && squirt1.isAlive == false) {
                winPic = Toolkit.getDefaultToolkit().getImage("Movieposter.jpg");
            }
            //if squirt is the only one alive then the winPic is displayed
            else if (bloat1.isAlive == false && bruce1.isAlive == false && dory1.isAlive == false && hank1.isAlive == false && nemo1.isAlive == false && squirt1.isAlive == true) {
                winPic = Toolkit.getDefaultToolkit().getImage("Movieposter.jpg");
            }
            //if there is more than one character left, then "No Win" will be printed
            else {
                System.out.println("No Win");
            }
        }
    }

        //only moves a character if they are alive
    public void moveThings() {
        //calls the move( ) code in the objects
        if (nemo1.isAlive) {
            nemo1.move();
        }
        if (dory1.isAlive) {
            dory1.move();
        }
        if (bruce1.isAlive) {
            bruce1.move();
        }
        if (hank1.isAlive) {
            hank1.move();
        }
        if (squirt1.isAlive) {
            squirt1.move();
        }
        if (bloat1.isAlive) {
            bloat1.move();
        }
        crashing();

    }
    //each if statement, in crashing method causes the death of a character by another, many different ones used
    public void crashing() {
        // if nemo hits bruce, bruce dies
        if (nemo1.hitbox.intersects(bruce1.hitbox) && nemo1.isAlive && bruce1.isAlive) {
            System.out.println("Crash!!");
            nemo1.dx = -nemo1.dx;
            bruce1.dx = -bruce1.dx;
            nemo1.dy = -nemo1.dy;
            bruce1.dy = -bruce1.dy;
            bruce1.isAlive = false;
        }
        // if bruce hits dory, dory dies
        if (bruce1.hitbox.intersects(dory1.hitbox) && bruce1.isAlive && dory1.isAlive) {
            System.out.println("Crash!!");
            hank1.dx = -bruce1.dx;
            dory1.dx = -dory1.dx;
            bruce1.dy = -bruce1.dy;
            dory1.dy = -dory1.dy;
            dory1.isAlive = false;
        }
        //everytime bloat hits bruce, bloat increases in width and height by 5, but if his width and height are above 175, bloat dies
        if (bloat1.hitbox.intersects(bruce1.hitbox) && bloat1.isAlive && bruce1.isAlive) {
            System.out.println("Crash!!");
            bruce1.dx = -bruce1.dx;
            bloat1.dx = -bloat1.dx;
            bruce1.dy = -bruce1.dy;
            bloat1.dy = -bloat1.dy;
            bruce1.xpos = bruce1.hitbox.x;
            bloat1.width += 5;
            bloat1.height += 5;
            if (bloat1.width > 175 && bloat1.height > 175) {
                bloat1.isAlive = false;
            }
        }
        // if squirt hits bruce, bruce dies
        if (squirt1.hitbox.intersects(bruce1.hitbox) && squirt1.isAlive && bruce1.isAlive) {
            System.out.println("Crash!!");
            squirt1.dx = -squirt1.dx;
            bruce1.dx = -bruce1.dx;
            squirt1.dy = -squirt1.dy;
            bruce1.dy = -bruce1.dy;
            bruce1.isAlive = false;
        }
        // if bruce hits hank, hank dies
        if (bruce1.hitbox.intersects(hank1.hitbox) && bruce1.isAlive && hank1.isAlive) {
            System.out.println("Crash!!");
            bruce1.dx = -bruce1.dx;
            hank1.dx = -hank1.dx;
            bruce1.dy = -bruce1.dy;
            hank1.dy = -hank1.dy;
            hank1.isAlive = false;
        }
        // if hank hits squirt, squirt dies
        if (hank1.hitbox.intersects(squirt1.hitbox) && hank1.isAlive && squirt1.isAlive) {
            System.out.println("Crash!!");
            hank1.dx = -hank1.dx;
            squirt1.dx = -squirt1.dx;
            hank1.dy = -hank1.dy;
            squirt1.dy = -squirt1.dy;
            squirt1.isAlive = false;
        }
        // if bloat hits nemo, nemo dies
        if (bloat1.hitbox.intersects(nemo1.hitbox) && bloat1.isAlive && nemo1.isAlive) {
            System.out.println("Crash!!");
            bloat1.dx = -bloat1.dx;
            nemo1.dx = -nemo1.dx;
            bloat1.dy = -bloat1.dy;
            nemo1.dy = -nemo1.dy;
            nemo1.isAlive = false;
        }
        // if nemo hits squirt, squirt dies
        if (nemo1.hitbox.intersects(squirt1.hitbox) && nemo1.isAlive && squirt1.isAlive) {
            System.out.println("Crash!!");
            nemo1.dx = -nemo1.dx;
            squirt1.dx = -squirt1.dx;
            nemo1.dy = -nemo1.dy;
            squirt1.dy = -squirt1.dy;
            squirt1.isAlive = false;
        }
        // if dory hits squirt, squirt dies
        if (dory1.hitbox.intersects(squirt1.hitbox) && dory1.isAlive && squirt1.isAlive) {
            System.out.println("Crash!!");
            dory1.dx = -dory1.dx;
            nemo1.dx = -nemo1.dx;
            dory1.dy = -dory1.dy;
            nemo1.dy = -nemo1.dy;
            nemo1.isAlive = false;
        }
        // if nemo hits hank, hank dies
        if (nemo1.hitbox.intersects(hank1.hitbox) && nemo1.isAlive && hank1.isAlive) {
            System.out.println("Crash!!");
            nemo1.dx = -nemo1.dx;
            hank1.dx = -hank1.dx;
            bloat1.dy = -bloat1.dy;
            hank1.dy = -hank1.dy;
            hank1.isAlive = false;

        }
        // if squirt hits dory, dory dies
        if (squirt1.hitbox.intersects(dory1.hitbox) && squirt1.isAlive && dory1.isAlive) {
            System.out.println("Crash!!");
            squirt1.dx = -squirt1.dx;
            dory1.dx = -dory1.dx;
            squirt1.dy = -squirt1.dy;
            dory1.dy = -dory1.dy;
            dory1.isAlive = false;
        }
        // if bloat hits dory, dory dies
        if (bloat1.hitbox.intersects(dory1.hitbox) && bloat1.isAlive && dory1.isAlive) {
            System.out.println("Crash!!");
            bloat1.dx = -bloat1.dx;
            dory1.dx = -dory1.dx;
            bloat1.dy = -bloat1.dy;
            dory1.dy = -dory1.dy;
            dory1.isAlive = false;
        }
        // if dory hits hank, hank dies
        if (dory1.hitbox.intersects(hank1.hitbox) && dory1.isAlive && hank1.isAlive) {
            System.out.println("Crash!!");
            dory1.dx = -dory1.dx;
            hank1.dx = -hank1.dx;
            dory1.dy = -dory1.dy;
            hank1.dy = -hank1.dy;
            hank1.isAlive = false;
        }
        // if hank hits bloat, bloat dies
        if (hank1.hitbox.intersects(bloat1.hitbox) && hank1.isAlive && bloat1.isAlive) {
            System.out.println("Crash!!");
            hank1.dx = -hank1.dx;
            bloat1.dx = -bloat1.dx;
            hank1.dy = -hank1.dy;
            bloat1.dy = -bloat1.dy;
            bloat1.isAlive = false;
        }
        // if nemo hits dory, dory dies
        if (nemo1.hitbox.intersects(dory1.hitbox) && nemo1.isAlive && dory1.isAlive) {
            System.out.println("Crash!!");
            nemo1.dx = -nemo1.dx;
            dory1.dx = -dory1.dx;
            nemo1.dy = -nemo1.dy;
            dory1.dy = -dory1.dy;
            dory1.isAlive = false;
        }
    }



    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }


    //paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // draws background image
        g.drawImage(backgroundPic, 0, 0, WIDTH, HEIGHT, null);

        // drawing of nemo character image if their alive, draws image bloatPic, where to draw, the size to draw it.
            if (nemo1.isAlive) {
                g.drawImage(nemoPic, nemo1.xpos, nemo1.ypos, nemo1.width, nemo1.height, null);
            }
        // drawing of dory character image if their alive, draws image bloatPic, where to draw, the size to draw it.
            if (dory1.isAlive) {
                g.drawImage(doryPic, dory1.xpos, dory1.ypos, dory1.width, dory1.height, null);
            }
        // drawing of bruce character image if their alive, draws image bloatPic, where to draw, the size to draw it.
            if (bruce1.isAlive) {
                g.drawImage(brucePic, bruce1.xpos, bruce1.ypos, bruce1.width, bruce1.height, null);
            }
        // drawing of hank character image if their alive, draws image bloatPic, where to draw, the size to draw it.
            if (hank1.isAlive) {
                g.drawImage(hankPic, hank1.xpos, hank1.ypos, hank1.width, hank1.height, null);
            }
        // drawing of squirt character image if their alive, draws image bloatPic, where to draw, the size to draw it.
            if (squirt1.isAlive) {
                g.drawImage(squirtPic, squirt1.xpos, squirt1.ypos, squirt1.width, squirt1.height, null);
            }
            // drawing of bloat character image if their alive, draws image bloatPic, where to draw, the size to draw it.
            if (bloat1.isAlive) {
                g.drawImage(bloatPic, bloat1.xpos, bloat1.ypos, bloat1.width, bloat1.height, null);
            }
            //displaying of winPic
            if (winPic != null) {
                g.drawImage(winPic, 0, 0, WIDTH, HEIGHT, null);
            }

            //g.drawRect(bruce1.hitbox.x, bruce1.hitbox.y, bruce1.hitbox.width, bruce1.hitbox.height);
            //g.drawRect(nemo1.hitbox.x, nemo1.hitbox.y, nemo1.hitbox.width, nemo1.hitbox.height);
            //g.drawRect(dory1.hitbox.x, dory1.hitbox.y, dory1.hitbox.width, dory1.hitbox.height);
            //g.drawRect(squirt1.hitbox.x, squirt1.hitbox.y, squirt1.hitbox.width, squirt1.hitbox.height);
            //g.drawRect(hank1.hitbox.x, hank1.hitbox.y, hank1.hitbox.width, hank1.hitbox.height);
            //g.drawRect(bloat1.hitbox.x, bloat1.hitbox.y, bloat1.hitbox.width, bloat1.hitbox.height);


                g.dispose();

                bufferStrategy.show();
            }
        }