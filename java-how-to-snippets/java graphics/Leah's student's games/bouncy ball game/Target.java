import java.awt.*;
public class Target {
    int xPosition;
    int yPosition;
    int xMove;
    int yMove;
    int size;
    Color color;

    /**
     *
     * @param xPositionIn: starting xPosition of the Target;
     * @param yPositionIn: starting yPosition of the Target;
     * @param sizeIn: the starting size of the Target;
     *
     *  The constructor for the target; When called it will
     *  create the target in the location specified with the size.
     */
    Target(int xPositionIn, int yPositionIn, int sizeIn){
        xPosition = xPositionIn;
        yPosition = yPositionIn;
        size = sizeIn;
        color = new Color(0,0,0);
        xMove = (int)(1 + Math.random() * 5);
        yMove = (int)(1 + Math.random() * 5);
    }

    /**
     * Will change the colour of the Target when a collision is detected;
     */
    void changeColor(){
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);
        color = new Color(r, g, b);
    }

    void moveTarget(){
        xPosition = xPosition + xMove;
        yPosition = yPosition + yMove;
    }
    /**
     * Will change the size of the Target when a collision is detected;
     */

    /**
     *
     * @param g: The canvas the project will be drawn on
     *
     * Draws the object onto the screen;
     */
    void drawTarget(Graphics g){
        g.setColor(color);
        g.fillOval(xPosition,yPosition,size,size);
        g.setColor(Color.BLUE);
        g.setColor(Color.BLACK);
        g.fillOval((xPosition+(size/3)),yPosition+(size/3),size/4,size/4);
    }

    int[] returnCollisionBox(){
        int leftLocationX = xPosition - 1;
        int topLocationY = yPosition - 1;
        int rightLocationX = xPosition + size + 1;
        int bottomLocationY = yPosition + size + 1;

        int[] collisionCords = {leftLocationX, topLocationY, rightLocationX, bottomLocationY};
        return collisionCords;
    }
    void bounce(int screenSize){
        if(xPosition < 0 || xPosition+size >screenSize){
            xMove = -xMove;
        }
        if(yPosition < 0 || yPosition+size > screenSize){
            yMove = -yMove;
        }
    }
}
