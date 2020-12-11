/*****************************************
 * Assignment 10: Part 2
 * Name:    Antonio Medina
 * E-mail:  amedina07@unm.edu
 * Course:      CS 152 - Section 006
 * Submitted:    12/02/2020
 *
 * A game which a user controls a sprite with
 * the arrow keys and has to catch the targets
 * that are falling/moving around the screen.
 * This is a Christmas theme with the Grinch,
 * snow, trees, and mountains. Score and lives
 * are kept count on the top of the screen.
 * There are two levels: Level 1 has one target
 * and a score of 10 must be scored in order to
 * move onto level 2. Level 2 consists of two
 * targets and a score of 10 must be met to win.
 ***********************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements KeyListener {

    char keypressed;
    int screenSize;
    int xPosition, yPosition;
    int keycode;
    int speed;
    int spriteSize;
    int levelOneScore, levelTwoScore;
    int levelOneLives, levelTwoLives;
    int snowSize;
    Sprite sprite;
    Trees[] levelOneTrees;
    Trees[] levelTwoTrees;
    Targets[] levelOneTargets;
    Targets[] levelTwoTargets;
    BackgroundSnow[] snow;
    Color backgroundColor;
    Color treeColor;
    Color houseColor, roofColor;
    BufferStrategy bufferStrategy;

    /**
     * Constructor, initializes all class variables.
     */
    Game () {
        screenSize = 800;
        backgroundColor = new Color(63, 75, 184);
        xPosition = screenSize / 2;
        yPosition = screenSize / 2;
        speed = 10;
        levelOneScore = 0;
        levelTwoScore = 0;
        levelOneLives = 3;
        levelTwoLives = 4;
        spriteSize = 100;
        houseColor = new Color(217, 166, 166);
        roofColor = new Color(104, 7, 7);
        treeColor = new Color(22, 160, 3);
        snowSize = (int)(Math.random()*10);
        snow = new BackgroundSnow[100];
        sprite = new Sprite(xPosition,yPosition * 2-(spriteSize),spriteSize,keycode);
        initializeSnow();
        initializeLevelOneTargets();
        initializeLevelTwoTargets();
        initializeLevelOneTrees();
        initializeLevelTwoTrees();
    }

    /**
     * Initializes our array of snowflakes that is
     * used in level 1 and 2 of game. Method is called in
     * Game constructor.
     */
    public void initializeSnow() {
        for(int i = 0; i < snow.length; i++) {
            int x = (int)(Math.random() * screenSize);
            int y = (int)(Math.random() * screenSize);
            snow[i] = new BackgroundSnow(x, y, snowSize);
            snow[i].setColor(Color.WHITE);
        }
    }

    /**
     * Initializes our array of targets that is
     * used in level 1 of game. Method is called in
     * Game constructor.
     */
    public void initializeLevelOneTargets() {
        levelOneTargets = new Targets[1];
        for(int i = 0; i < levelOneTargets.length; i++) {
            int x = (int)(Math.random() * screenSize);
            int y = screenSize / 80;
            levelOneTargets[i] = new Targets(x, y, 50);
            int r = (int)(Math.random() * 256);
            int g = (int)(Math.random() * 256);
            int b = (int)(Math.random() * 256);
            Color c = new Color(r, g, b);
            levelOneTargets[i].setColor(c);
        }
    }

    /**
     * Initializes our array of targets that is
     * used in level 2 of game. Method is called in
     * Game constructor.
     */
    public void initializeLevelTwoTargets() {
        levelTwoTargets = new Targets[2];
        for(int i = 0; i < levelTwoTargets.length; i++) {
            int x = (int)(Math.random() * screenSize);
            int y = screenSize / 80;
            levelTwoTargets[i] = new Targets(x, y, 50);
            int r = (int)(Math.random() * 256);
            int g = (int)(Math.random() * 256);
            int b = (int)(Math.random() * 256);
            Color c = new Color(r, g, b);
            levelTwoTargets[i].setColor(c);
        }
    }

    /**
     * Initializes our array of trees that is
     * used in level 1 of game. Method is called in
     * Game constructor.
     */
    public void initializeLevelOneTrees() {
        levelOneTrees = new Trees[1];
        for(int i = 0; i < levelOneTrees.length; i++) {
            levelOneTrees[i] = new Trees(xPosition-200, yPosition+100,
                    spriteSize+(spriteSize/2));
        }
    }

    /**
     * Initializes our array of trees that is
     * used in level 2 of game. Method is called in
     * Game constructor.
     */
    public void initializeLevelTwoTrees() {
        levelTwoTrees = new Trees[30];
        for(int i = 0; i < levelTwoTrees.length; i++) {
            int x = (int)(Math.random() * screenSize);
            int y = (int)(Math.random() * (700 - 300 + 1) + 300);
            levelTwoTrees[i] = new Trees(x, y, (int)(Math.random()*(50 - 20 + 1) + 20));
        }
    }



    /**
     * The main part of the program that initializes
     * movement and play area from classes.
     * Also initializes paint and delayTime.
     */
    public static void main(String[] args) {
        Game keyboardExample = new Game();
        keyboardExample.setupScreen(keyboardExample);
        while(true) {
            for(int i = 0; i < keyboardExample.levelOneTargets.length; i++) {
                keyboardExample.levelOneTargets[i].move();
                keyboardExample.levelOneTargets[i].bounce(keyboardExample.screenSize);
            }
            for(int i = 0; i < keyboardExample.levelTwoTargets.length; i++) {
                keyboardExample.levelTwoTargets[i].move();
                keyboardExample.levelTwoTargets[i].bounce(keyboardExample.screenSize);
            }
            for(int i = 0; i < keyboardExample.snow.length; i++) {
                keyboardExample.snow[i].move();
                keyboardExample.snow[i].snowArea(keyboardExample.screenSize);
            }
            keyboardExample.sprite.playArea(keyboardExample.screenSize);
            keyboardExample.repaint();
            keyboardExample.delay(20);
        }
    }

    /**
     * Sets up the screen
     * @param canvas the Canvas object that is the main
     *               part of the screen
     */
    void setupScreen(Game canvas) {
        JFrame frame = new JFrame("Keyboard interaction"); //give screen a name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize, screenSize);
        canvas.setSize(screenSize, screenSize);
        canvas.setBackground(backgroundColor);
        canvas.addKeyListener(canvas);  //tell the canvas that you will be "listening for keyboard interactions"
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        canvas.requestFocusInWindow();
        canvas.listFonts();

        // Helps with buffering
        canvas.createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();
    }

    /**
     * draws everything on the screen
     * @param g the Graphics object to draw on
     */
    public void paint(Graphics g) {
        /*
         * Calls and sets keycode as parameter in
         * move method from Sprite class.
         */
        sprite.move(keycode);
        keycode = '0';

        // Calls methods that draw game sets lives.
        drawGame(g);
        loseLives(g);

        // Calls method that draws score and lives onto screen.
        drawScoreAndLives(g);
    }

    /**
     * Draws background, targets, and sprite for each
     * level. Also counts score.
     * @param g the Graphics object to draw on
     */
    public void drawGame(Graphics g) {
        drawBackground(g);
        if(levelOneScore <= 10) {

            // Runs through array
            for (int i = 0; i < levelOneTargets.length; i++) {
                if (checkCollision(sprite, levelOneTargets[i])) {
                    levelOneScore++;
                    sprite.yPosition = yPosition * 2-(spriteSize);
                    sprite.setColor(sprite.color);
                    levelOneTargets[i].xPosition = (int) (Math.random() * screenSize);
                    levelOneTargets[i].yPosition = 0;
                } else {
                    sprite.setColor(sprite.color);
                    sprite.drawSprite(g);
                    levelOneTargets[i].drawTargets(g);
                }
            }
        } else

            // Runs through array
            for (int i = 0; i < levelTwoTargets.length; i++) {
                if (checkCollision(sprite, levelTwoTargets[i])) {
                    levelTwoScore++;
                    sprite.yPosition = yPosition * 2-(spriteSize);
                    sprite.setColor(sprite.color);
                    levelTwoTargets[i].xPosition = (int) (Math.random() * screenSize);
                    levelTwoTargets[i].yPosition = 0;
                } else {
                    sprite.setColor(sprite.color);
                    sprite.drawSprite(g);
                    levelTwoTargets[i].drawTargets(g);
                }
            }
        winGame(g);
    }

    /**
     * Draws score and lives onto screen.
     * @param g the Graphics object to draw on
     */
    public void drawScoreAndLives(Graphics g) {

        // Creates and sets new Geneva font.
        Font geneva = new Font("Geneva", Font.BOLD, 18);
        g.setFont(geneva);
        g.setColor(Color.WHITE);
        if(levelOneScore <= 10) {
            g.drawString("Score: " + levelOneScore, 50, 50);
            g.drawString("Lives: " + levelOneLives, screenSize - 150, 50);
        } else {
            g.drawString("Score: " + levelTwoScore, 50, 50);
            g.drawString("Lives: " + levelTwoLives, screenSize - 150, 50);
        }
    }

    /**
     * Draws background for level 1 and 2.
     * @param g the Graphics object to draw on
     */
    public void drawBackground(Graphics g) {
        if(levelOneScore <= 10) {
            levelOneBackground(g);
        } else
            levelTwoBackground(g);
    }

    /**
     * Draws background for level 1.
     * @param g the Graphics object to draw on
     */
    public void levelOneBackground(Graphics g) {
        levelOneTree(g);
        for (int i = 0; i < snow.length; i++) {
            g.setColor(Color.WHITE);
            snow[i].drawSnow(g);
        }
    }

    /**
     * Draws background for level 2.
     * @param g the Graphics object to draw on
     */
    public void levelTwoBackground(Graphics g) {
        mountains(g);
        levelTwoTree(g);
        for (int i = 0; i < snow.length; i++) {
            g.setColor(Color.WHITE);
            snow[i].drawSnow(g);
        }
    }

    /**
     * Draws mountain used in level 2
     * @param g the Graphics object to draw on
     */
    public void mountains(Graphics g) {
        int xPoints[] = {0, 75, 125, 150, 300, 400, 450, 575, 625, 700, 750, 800};
        int yPoints[] = {300, 200, 175, 150, 50, 100, 175, 125, 200, 150, 250, 300};
        int cPoints = 12;
        g.setColor(Color.WHITE);
        g.fillPolygon(xPoints, yPoints, cPoints);
    }

    /**
     * Draws trees used in level 1.
     * @param g the Graphics object to draw on
     */
    public void levelOneTree(Graphics g) {
        for (int i = 0; i < levelOneTrees.length; i++) {
            g.setColor(Color.WHITE);
            levelOneTrees[i].drawTrees(g);
        }
    }

    /**
     * Draws trees for level 2.
     * @param g the Graphics object to draw on
     */
    public void levelTwoTree(Graphics g) {
        for (int i = 0; i < levelTwoTrees.length; i++) {
            g.setColor(Color.WHITE);
            levelTwoTrees[i].drawTrees(g);
        }
    }

    /**
     * Decreases lives for levels 1 and 2 if
     * target hits bottom of screen.
     * @param g the Graphics object to draw on
     */
    public void loseLives(Graphics g) {
        if(levelOneScore <= 10) {
            for (int i = 0; i < levelOneTargets.length; i++) {
                if (levelOneTargets[i].yPosition > screenSize) {
                    levelOneLives--;
                }
                printLevelOneLoss(g);
            }
        } else
            for (int i = 0; i < levelTwoTargets.length; i++) {
                if (levelTwoTargets[i].yPosition > screenSize) {
                    levelTwoLives--;
                }
                printLevelTwoLoss(g);
            }
    }

    /**
     * Prints You Lose! if lives reach 0 for level 1.
     * @param g the Graphics object to draw on
     */
    public void printLevelOneLoss(Graphics g) {
        if (levelOneLives <= 0) {
            Font myFont = new Font("myFont", Font.BOLD, 28);
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, screenSize, screenSize);
            g.setColor(Color.WHITE);
            g.drawString("You Lose!", xPosition - spriteSize / 2, yPosition - spriteSize / 2);
        }
    }

    /**
     * Prints You Lose! if lives reach 0 for level 2.
     * @param g the Graphics object to draw on
     */
    public void printLevelTwoLoss(Graphics g) {
        if (levelTwoLives <= 0) {
            Font myFont = new Font("myFont", Font.BOLD, 28);
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, screenSize, screenSize);
            g.setColor(Color.WHITE);
            g.drawString("You Lose", xPosition - spriteSize / 2, yPosition - spriteSize / 2);
        }
    }

    /**
     * Print You Win! if score reaches 10 in level 2.
     * @param g the Graphics object to draw on
     */
    public void winGame(Graphics g) {
        if(levelTwoScore >= 10) {
            Font myFont = new Font("myFont", Font.BOLD, 28);
            g.setFont(myFont);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, screenSize, screenSize);
            g.setColor(Color.WHITE);
            g.drawString("You Win!", xPosition - spriteSize / 2, yPosition - spriteSize / 2);
        }
    }

    /**
     * Checks for collision between sprite and targets.
     * @param sprite pulls info from sprite.
     * @param targets pulls info from targets.
     * @return true for collision and false for no collision.
     */
    public boolean checkCollision(Sprite sprite, Targets targets) {
        double distance = Point2D.distance(sprite.xPosition, sprite.yPosition, targets.xPosition, targets.yPosition);
        if(distance < sprite.size/2 + targets.size)
            return true;
        else
            return false;
    }

    /**
     * This method responds to the keyTyped event
     * by setting the keypressed variable to the key
     * that was typed. keyTyped responds to "regular"
     * character keys. It does not respond to special
     * keys like return, delete, shift, etc.
     * @param e the key event that happened
     */
    public void keyTyped(KeyEvent e) {
        keypressed = e.getKeyChar();
        repaint();
    }

    /**
     * This method responds to the keyPressed event
     * by printing out the keycode for the key
     * that was typed. keyPressed responds to all
     * keys, including special keys. For a list of
     * keycodes, see: http://www.foreui.com/articles/Key_Code_Table.htm
     * @param e the key event that happened
     */
    public void keyPressed(KeyEvent e) {
        System.out.println("The keycode for this key is: " + e.getKeyCode());
        keycode = e.getKeyCode();
        repaint();
    }

    /**
     * This method responds to the keyReleased event
     * @param e the key event that happened
     */
    public void keyReleased(KeyEvent e) {
    }

    /**
     * This method lists out all of the available fonts
     */
    void listFonts() {
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for ( int i = 0; i < fonts.length; i++ )
        {
            System.out.println(fonts[i]);
        }
    }

    /**
     * This method pauses your program for delayTime.
     * @param delayTime the time to pause the program
     */
    void delay(int delayTime) {
        try {
            Thread.sleep(delayTime);
        } catch (Exception exc) {

        }
    }

    /**
     * Fixes buffering of screen in game.
     * @param g the Graphics object to draw on
     */
    public void update(Graphics g) {
        bufferStrategy = getBufferStrategy();
        g = bufferStrategy.getDrawGraphics();
        g.clearRect(0,0,screenSize,screenSize);
        paint(g);
        bufferStrategy.show();
    }
}
