/*****************************************
 * Assignment 10
 * Name: Gonzalo Morales & Sho Komiyama
 * E-mail: gmoraleschaya@unm.edu & kmymsho0227@unm.edu
 * Course: CS 152 - Section 006
 * Submitted: 12/3/2020
 * Summary: An interactive game where the player utilizes the
 * arrow keys to control the basket and collect the apples
 * through 3 different levels of difficulty. Once the game
 * is finished, the terminal displays the termination of the game.
 ***********************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.awt.geom.*;
//this class draws the apple
class Target {
    int x, y, size, speed;
    Random rand = new Random();
    Target (int screenSize, int levelIn) {
        int r = rand.nextInt(7);
        speed = (int)(3*levelIn/2 + 3.5);
        size = 20 + r;
        x = rand.nextInt(screenSize);
        y = 0;
    }
    //method that actually draws the apple
    public void drawTarget(Graphics g) {
        g.setColor(new Color (0x436D16));
        g.fillRect(x-size/3,y-size,size/6,size);
        g.fillArc(x-size/2, y-size, size/2, size,30,-180);
        g.setColor(Color.red);
        g.fillOval(x-size/2, y-size/2, size, size*3/2);
        g.fillOval(x-size,y-size/2,size,size*3/2);
    }
    //method that allows the apple to move and relocate
    public void moveTarget() {
        y += speed;
    }
}
//this class draws the basket
class Sprite {
    int x, y, size, speed, screenSize; //x position, y position, size of the sprite, amount of move, size of screen
    int RgradientPaint, GgradientPaint, BgradientPaint;
    Sprite (int scrSizeIn, int sizeIn, int xIn, int yIn) {
        size = sizeIn;
        screenSize = scrSizeIn;
        x = xIn;
        y = yIn + 150;
        speed = 13;
        RgradientPaint = 100;
        GgradientPaint = 104;
        BgradientPaint = 80;
    }
    //this method actually makes the drawing of the basket
    public void drawSprite(Graphics g) {
        //the character drawing
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(
                new GradientPaint(0, 0, new Color(RgradientPaint,GgradientPaint,BgradientPaint), 50, 25, new Color(0xD7923E), true));
        g.fillArc(x, y, size, size,0,-180);
        g.setColor( new Color (0x6D5605));
        g.fillRect(x,y+(size/2),size,size/10);
        g2.drawArc(x,y,size,size,0,180);
    }
    //this method changes the color of the basket gradient when the collision happens
    public void CollisionReaction() {
        RgradientPaint = (int)(Math.random()*256);
        GgradientPaint = (int)(Math.random()*256);
        BgradientPaint = (int)(Math.random()*256);
    }
    //this method allows for the basket to move
    public void moveSprite(int pressedKey) {
        //controls the player
        switch (pressedKey) {
            case 37 -> x -= speed;
            case 38 -> y -= speed;
            case 39 -> x += speed;
            case 40 -> y += speed;
        }

        //in case the player leaves the canvas
        if (x < 0)
            x = screenSize-speed;
        else if (x > screenSize)
            x = speed;
        else if (y < 0)
            y = screenSize-speed;
        else if (y > screenSize)
            y = speed;
    }
}

public class Assignment10 extends Canvas implements KeyListener{
    int screenSize;
    int keyCode;
    int xPosition, yPosition;
    int health;
    int targetCount;
    int level = 0;
    int Size;
    boolean winner;
    Color backgroundColor;
    Target target;
    Sprite sprite;
    Random rand;
    BufferStrategy bs;
    Font font;
    Font bigFont;
    int[] difficulties;

        //constructor, initializes all class variables
    Assignment10 () {
        health = 640; //this is starting health as well as maximum
        targetCount = 0;//number of targets captured aka score
        Size = 100;
        screenSize = 700;
        xPosition = screenSize/2;
        yPosition = screenSize/2;
        sprite = new Sprite(screenSize, Size, xPosition, yPosition);
        target = new Target(screenSize, 1);
        rand = new Random();
        backgroundColor = new Color(167, 227, 222, 255);
        font = new Font("Courier New", 1, 30);
        bigFont = new Font("Courier New", 1, 100);
        winner = false; //always false unless player wins
        difficulties = new int[]{3, 5, 7}; //numbers of targets that will appear in each level. 1 target in
    }

    //main code
    public static void main(String[] args) {
        Assignment10 assign = new Assignment10();
        assign.setupScreen(assign);


        for (int i : assign.difficulties) {//goes through each item in "difficulty" array
            if (!assign.isPlayerAlive())
                break;
            assign.level += 1;
            assign.delay(100);
            for (int j = 0; j < i; j++) {
                if (!assign.isPlayerAlive())
                    break;
                assign.target = new Target(assign.screenSize, assign.level);
                while (!assign.checkCollision()) {
                    if(!assign.isPlayerAlive())
                        break;
                    assign.target.moveTarget();
                    assign.hunger(2); //decrease the health
                    assign.delay(20); //this value can decrease over time, in order to increase the difficulties
                    assign.repaint();
                    if (assign.touchingGround()){
                        assign.health -= 150;
                        assign.targetCount += -1;
                        break;
                    }
                }
                if(assign.checkCollision()) {
                    assign.sprite.CollisionReaction();
                    assign.repaint();
                }

                if (assign.isPlayerAlive()){
                    assign.addHealth();
                    assign.targetCount += 1;
                }
                else
                    break;
            }
        }
        if(assign.isPlayerAlive()){
            assign.winner = true;
            assign.repaint();
            System.out.println("You Won");
        }
        else {
            assign.repaint();
            System.out.println("Game Over");
        }
    }

    //setup the screen
    void setupScreen (Assignment10 canvas) {
        JFrame frame = new JFrame("Assignment 10"); //give screen a name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize,screenSize);
        canvas.setSize(screenSize, screenSize);
        canvas.addKeyListener(canvas);  //tell the canvas that you will be "listening for keyboard interactions"
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        canvas.requestFocusInWindow();
        canvas.createBufferStrategy(3);
        bs = getBufferStrategy();
    }

    //draw stuff here
    public void  paint (Graphics g) {
        DrawBackground(g);
        //draw player here
        sprite.drawSprite(g);
        //draw targets here
        target.drawTarget(g);
        if (winner) {
            g.setFont(bigFont);
            g.setColor(Color.ORANGE);
            g.drawString("You Won!", 130, 300);
        } else if (!isPlayerAlive()) {
            g.setFont(bigFont);
            g.setColor(Color.BLACK);
            g.drawString("Game Over!", 100, 300);
        }
    }


    //this method does the actuall drawing of all of the background
    public void DrawBackground(Graphics g) {

        switch (level) {
            case 1 -> g.setColor(new Color(118, 176, 213));
            case 2 -> g.setColor(new Color(236, 82, 48));
            case 3 -> g.setColor(new Color(21, 42, 83));
        }
        g.fillRect(0, 0, screenSize, screenSize);
        g.setColor(new Color (0xA0D06F));
        g.fillRect(0, yPosition+(yPosition/2),screenSize,screenSize);
        g.setColor(Color.white);
        //cloud to the left
        g.fillOval(xPosition+(xPosition/2),yPosition-Size,Size,Size);
        g.fillOval(xPosition+(xPosition/3),yPosition-Size,Size,Size+(Size/6));
        g.fillOval(xPosition+(xPosition/6),yPosition-Size,Size,Size);
        //tree to the left
        g.setColor( new Color(0x3E2801));
        g.fillRect(0,yPosition/2,Size/2, screenSize/2);
        //tree to the right
        g.fillRect(screenSize-Size/2,yPosition/2,Size/2, screenSize/2);
        //middle tree
        g.fillRect(xPosition,yPosition/2,Size/2, screenSize/2);
        //leaves to the left
        g.setColor (new Color(0x0D3602));
        g.fillOval(-Size/2,-Size/2,Size*3,Size*3);
        //leaves to the right
        g.fillOval(screenSize-Size*2,-Size/2,Size*3,Size*3);
        //leaves in the middle
        g.fillOval(xPosition-(xPosition/2),-Size/2,Size*4,Size*3);
        g.setColor(Color.red);
        g.setFont(font);
        g.drawString("Catch the apples", screenSize/2-150, 40);
        //display the current health and the score
        g.setColor(Color.red);
        g.fillRect(30, screenSize-80, health, 50);
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString("Score:" + targetCount, 20, screenSize-100);
        g.drawString("Level:" + level + "/3",screenSize-500,screenSize-100);
    }
    public void keyPressed (KeyEvent e) {
        keyCode = e.getKeyCode();
        sprite.moveSprite(keyCode);
        repaint();
    }
    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    //this boolean responds true for collision
    public boolean checkCollision () {
        double distance = Point2D.distance(sprite.x,sprite.y,target.x,target.y);
        return distance <= Size;
    }

    //this boolean responds true if the apple touches the ground


    //This method pauses your program for delayTime
    void delay(int delayTime) {
        try {
            Thread.sleep(delayTime);
        } catch (Exception exc) {
        }
    }

    public void update(Graphics g) {
        bs = getBufferStrategy();
        g = bs.getDrawGraphics();
        bs.show();
        g.clearRect(0, 0, screenSize, screenSize);
        paint(g);
    }

    public void hunger(int a) {//decreases the health
        if(health > a)
            health -= a;
        else
            health = 0;
    }

    public void addHealth() {//increase the health
        if(health > 640-150)
            health = 640;
        else
            health += 150;
    }

    public boolean isPlayerAlive() {//checks the player's health
        return health > 0;
    }

    public boolean touchingGround() {
        return target.y > screenSize-100;
    }
}