import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class GameOutLine extends Canvas implements KeyListener {
    Sprite sprite;
    Target[] targets;
    int keycode;
    int screenSize;
    Color backgroundColor;
    int score;
    int level;

    public static void main(String[] args) {}

    /**
     * Game constructor. Initializes all game variables
     */
    GameOutLine() {}

    /**
     * sets up the screen
     */
    void setupScreen() {}

    /**
     * draws a different background depending on the level
     * @param level the level of the game
     */
    void drawBackground(int level) {}

    /**
     * draws everything
     * @param g the Graphics object everything is drawn on
     */
    public void paint(Graphics g) {}

    /**
     * This method responds to the keyTyped event
     * @param e the key event that happened
     */
    public void keyTyped(KeyEvent e) {}

    /**
     * This method responds to the keyPressed event
     * @param e the key event that happened
     */
    public void keyPressed(KeyEvent e) {}

    /**
     * This method responds to the keyReleased event
     * @param e the key event that happened
     */
    public void keyReleased(KeyEvent e) {}

    /* This method pauses your program for delayTime
     * @param delayTime the time to pause the program
     */
    static void delay(int delayTime) {}

}

class Sprite {
    int size;
    int xPosition, yPosition;
    int xSpeed,ySpeed;
    Color spriteColor;

    /**
     * creates the sprite
     * @param xPositionIn the x position of the sprite
     * @param yPositionIn the y position of the sprite
     * @param sizeIn the size of the sprite
     */
    Sprite (int xPositionIn, int yPositionIn, int sizeIn) { }

    /**
     * Sets the x and y position of the sprite
     */
    public void move (KeyEvent e, int screenSize) {}

    /**
     * checks to see if the sprite is falling off the screen
     * if so, redraws it on the other side of the screen
     * @param screenSize the size of the screen
     */
    public void wrapAround (int screenSize) {}

    /**
     * draws the sprite
     * @param g the Graphics object that the sprite
     *          will be drawn on
     */
    public void drawSprite (Graphics2D g) {}

    /**
     * checks for a collision between sprite and target
     * @param target the target to check
     * @return true if there is a collision and false if
     *         there is no collision
     */
    public boolean checkCollision (Target target) {}
}

class Target {
    int size;
    int xPosition, yPosition;
    int xSpeed,ySpeed;
    static Color targetColor;

    /**
     * creates the target
     * @param xPositionIn the x position of the target
     * @param yPositionIn the y position of the target
     */
    Target (int xPositionIn, int yPositionIn, int sizeIn) {}

    /**
     * Sets the x and y position of the target
     */
    public void move (int screenSize) {}

    /**
     * makes the target bounce of the edges of the screen
     * @param screenSize the size of the screen
     */
    public void bounce(int screenSize) {}

}