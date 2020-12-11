import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.awt.geom.*;

public class Game extends Canvas implements KeyListener {
    static int score;
    static int screenSize = 500;
    static Color backgroundColor = new Color(255, 255, 255);
    static Sprite sprite1;
    static Target target;
    static Target target2;
    public int[] targetColBox;
    public int[] spriteColBox;
    public static int[] movementArray = {0,0,0,0};
    int yTracker = 0;
    int xTracker = 0;

    Game() {
        sprite1 = new Sprite(screenSize / 2 + 101, screenSize / 2, 50);
        target = new Target(screenSize / 2, screenSize / 2, 100);
        target2 = new Target(0,0,75);
        targetColBox = target.returnCollisionBox();
        spriteColBox = sprite1.returnCollisionBox();
    }

    /**
     * @param g: The Graphics class that will allow the game to be drawn;
     *           <p>
     *           This function will draw the Targets and Sprite onto the screen;
     */
    public void paint(Graphics g) {
        xTracker = 0;
        yTracker =0;
        for(int i =0; i<(screenSize/50); i++){
            xTracker =0;
            for(int j=0; j<(screenSize/50); j++){
                g.setColor(new Color(255-(10*i),(i*j)+30, (i*j)+30));
                g.fillRect(xTracker,yTracker,50,50);
                xTracker = xTracker + 50;
            }
            yTracker += 50;
        }
        sprite1.drawSprite((Graphics2D) g);
        target.drawTarget((Graphics2D) g);
        target2.drawTarget((Graphics2D) g);
        g.setColor(Color.WHITE);
        g.drawString("Your Score: "+score, 5,15);
    }
    public void update(Graphics g){
        paint(g);
    }

    /**
     * @param args: The argument of the main function;
     *              <p>
     *              The main function of the program
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.setupScreen(game);
        while (true) {
            game.delay(20);
            game.oneIteration();
        }
    }


    /**
     * The class that is responsible for moving the sprite
     */
    int keyCode;

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        keyCode = e.getKeyCode();
        if (keyCode == 37 && sprite1.xMove > 0) {
            sprite1.xMove *= -1;
        } else if (keyCode == 38 && sprite1.yMove > 0) {
            sprite1.yMove *= -1;
        } else if (keyCode == 39 && sprite1.xMove < 0) {
            sprite1.xMove *= -1;
        } else if (keyCode == 40 && sprite1.yMove < 0) {
            sprite1.yMove *= -1;
        }
    }

    /**
     * @param canvas: The canvas that the game will be run on;
     *                <p>
     *                This will setup the screen that will be drawn on;
     */
    void setupScreen(Game canvas) {
        JFrame frame = new JFrame("Game File"); //give screen a name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setSize(screenSize, screenSize);
        canvas.setBackground(backgroundColor);
        canvas.addKeyListener(canvas); //tell the canvas that you will be "listening for keyboard interactions"
        canvas.setBackground(Color.GRAY);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        canvas.requestFocusInWindow();
    }

    static void checkForCollision(Target target, Sprite sprite) {
        double distance = Point2D.distance(target.xPosition+(target.size/2), target.yPosition+(target.size/2), sprite.xPosition+(sprite.size/2), sprite.yPosition+(sprite.size/2));
        if(distance <= sprite.size/2 + target.size/2){
            target.changeColor();
            target.xMove = -target.xMove;
            target.yMove = -target.yMove;
            sprite1.xMove = -sprite1.xMove;
            sprite1.yMove = -sprite1.yMove;
            score++;
        }
    }
    void delay(int delayTime){
        try {
            Thread.sleep(delayTime);
        } catch (Exception exc)
        {
        }
    }
    void oneIteration(){
        targetColBox = target.returnCollisionBox();
        spriteColBox = sprite1.returnCollisionBox();
        checkForCollision(target,sprite1);
        checkForCollision(target2,sprite1);
        target.moveTarget();
        sprite1.moveSprite();
        target2.moveTarget();
        sprite1.bounce(screenSize);
        target.bounce(screenSize);
        target2.bounce(screenSize);
        repaint();
    }
}

