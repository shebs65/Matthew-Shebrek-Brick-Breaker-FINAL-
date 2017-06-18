package pkgfinal.assignment;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import static pkgfinal.assignment.BrickBreaker.WIDTH;

/**
 *
 * @author shebm3906
 */
public class BrickBreaker extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "My Game";
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // YOUR GAME VARIABLES WOULD GO HERE
    Rectangle player = new Rectangle(WIDTH / 2 - 50, HEIGHT - 50, 100, 25);
    int playerWidth = 100;
    int playerHeight = 25;
    int brickWidth = 50;
    int brickHeight = 20;
    Rectangle ball = new Rectangle(WIDTH / 2, HEIGHT / 2, 25, 25);
    boolean leftPressed;
    boolean rightPressed;
    int velocityX = 6;
    int velocityY = 6;
    ArrayList<Rectangle> bricks = new ArrayList();
    int score = 0;
    int lives = 3;
    Font myFont = new Font("Arial", Font.BOLD, 50);
    boolean gameOver = false;

    // GAME VARIABLES END HERE   
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public BrickBreaker() {
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
        // draw paddle
        g.drawRect(player.x, player.y, player.width, player.height);

        // draw ball
        g.drawOval(ball.x, ball.y, ball.width, ball.height);

        // set color blue
        g.setColor(Color.BLUE);

        // create bricks
        for (Rectangle brick : bricks) {
            g.drawRect(brick.x, brick.y, brick.width, brick.height);
        }

        // display score and lives
        g.setFont(myFont);
        g.setColor(Color.cyan);
        g.drawString("" + score, WIDTH - 100, 100);
        g.drawString("Lives: " + lives, 100, 100);
//       
//            // GAME DRAWING ENDS HERE
//        }
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here

        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 10; y++) {

                bricks.add(new Rectangle(brickWidth * x, brickHeight * y, brickWidth, brickHeight));
            }
        }





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
            
            // while gameover = false run game
           // while (!gameOver) {

                if (lives == 0) {
                    gameOver = true;
                }
                
                if (score == 160) {
                    gameOver = true;
                }
        
    
                collisions();

                if (ball.y > HEIGHT) {
                    resetBall();
                }

                if (leftPressed) {
                    player.x = player.x - 10;
                }
                if (rightPressed) {
                    player.x = player.x + 10;
                }

                // updates x coordinate every second
                ball.x += velocityX;
                // updates y coordinate every second
                ball.y += velocityY;

        
    
        
    


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

    private Rectangle Rectangle(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = false;



            }

        }
    }

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        BrickBreaker game = new BrickBreaker();

        // starts the game loop
        game.run();
    }

    public void collisions() {

        if (ball.intersects(player)) {
            velocityY = -velocityY;
        }
        if (ball.x > 780) {
            velocityX = -velocityX;
        }
        if (ball.x < 0) {
            velocityX = -velocityX;
        }
        if (ball.y < 0) {
            velocityY = -velocityY;
        }

        if (player.x + player.width > WIDTH) {
            player.x = player.x - 10;
        }

        if (player.x < 0) {
            player.x = player.x + 10;
        }

        if (ball.y > HEIGHT) {
            lives = lives - 1;
        }

        for (int i = 0; i < bricks.size(); i++) {
            if (ball.intersects(bricks.get(i))) {
                removeBlock(i);
                score = score + 1;
                velocityY = -velocityY;

            }
        }
    }

    public void removeBlock(int brick) {
        bricks.remove(brick);

    }

    public void resetBall() {
        ball.x = WIDTH / 2;
        ball.y = HEIGHT / 2;
        velocityX = 6;
        velocityY = 6;


    }
}
