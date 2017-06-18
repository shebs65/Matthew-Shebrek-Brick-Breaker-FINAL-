package pkgfinal.assignment;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

/**
 *
 * @author shebm3906
 */
public class Stacker extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    //Title of the window
    String title = "Stacker";

    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;


    // YOUR GAME VARIABLES WOULD GO HERE
    
    boolean spawn;

    int firstBrickX = 0;
    int firstBrickY = HEIGHT - 50;
    int firstBrickWidth = 150;
    int firstBrickHeight = 25;
    // blockX[0] = HEIGHT - 50;        
    
    int newBrickX = 0;
    int newBrickY = firstBrickY - firstBrickHeight;
    
    
    ArrayList<Rectangle> blocks = new ArrayList();
    
    boolean spacePressed;
    
    int i = 0;
    
    //int layer = 0;
    
    int[] layer = new int[i];
    
    //int[] blockX = new int[i];
   // for (int i = 0; i < 10; i++) {
    //brickX(i) = 0;
   // brickY(i) = brickY(i) - firstBrickHeight;

    // GAME VARIABLES END HERE   

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public Stacker(){
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
    }
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        
        g.drawRect(firstBrickX, firstBrickY, firstBrickWidth, firstBrickHeight);
        for(Rectangle block: blocks){
            g.drawRect(newBrickX, newBrickY, 150, 25);
        }
        {
            //if (spacePressed) {
             //   newBrickY = newBrickY - 50;
      // g.drawRect(newBrickX, newBrickY, 100, 100);
        
        
            
     
       // }
        // GAME DRAWING ENDS HERE
    
        }
        
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void  preSetup(){
       // Any of your pre setup before the loop starts should go here

       
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
       
            
            //if (spacePressed = false) {
            // move until space is pressed
            for (int i = 0; i < 100; i++) {
           // if (spacePressed == false && layer[0]) {  
            firstBrickX = firstBrickX + 5;
            
            }  
while(true) {
            if (spacePressed) {
                //layer++;
                spawn = true;
                blocks.add(new Rectangle(newBrickX,newBrickY,150,25));
                if (spacePressed == false) {
                newBrickY = newBrickY - 25;
                newBrickX = newBrickX + 5;
            }
            }
            if(spacePressed == false){
                
            }
            
            
            
            for(Rectangle block: blocks){
                block.x += 5;
                }
            
            
            
            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    
    
    }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e){
            
        }
        
        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e){
            
        }
        
        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e){
            
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e){
            
        }
    }
    
    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter{
        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e){
            
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                spacePressed = true;
            }
            
        }
        
        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                spacePressed = false;
            }
        
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        Stacker game = new Stacker();
                
        // starts the game loop
        game.run();
    }
    
    public void resetBlock(Graphics g){
        
        
        spawn = true;
        g.drawRect(newBrickX, newBrickY, 150, 25);
        newBrickY = newBrickY - 50;
        
}
    
        }
    

