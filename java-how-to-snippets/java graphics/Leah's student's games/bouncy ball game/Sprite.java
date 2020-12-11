import java.awt.*;

public class Sprite {
    int xPosition;
    int yPosition;
    int size;
    int xMove;
    int yMove;
    Color color;

    /**
     *
     * @param xPositionIn: xPosition of the Sprite;;
     * @param yPositionIn: yPosition of the Sprite;
     * @param sizeIn: xize of the Sprite;
     *
     * Will create the sprite object onto the screen;
     */
    Sprite(int xPositionIn, int yPositionIn, int sizeIn){
        xPosition = xPositionIn;
        yPosition = yPositionIn;
        color = new Color(0,0,0);
        size = sizeIn;
        xMove = (int)(2 + Math.random() * 5);
        yMove = (int)(2 + Math.random() * 5);

    }
    void bounce(int screenSize){
        if(xPosition < 0 || xPosition+size >screenSize){
            xMove = -xMove;
        }
        if(yPosition < 0 || yPosition+size > screenSize){
            yMove = -yMove;
        }
    }

    /**
     * Will change the colour of the Sprite when a collision is detected;
     */
    void changeColor(){
        color = new Color((int)Math.random()*255,(int)Math.random()*255,(int)Math.random()*255);
    }

    /**
     * Will change the size of the Sprite when a collision is detected;
     */
    void changeSize(){

    }

    /**
     *
     * @param g: The canvas the project will be drawn on
     *
     * Draws the object onto the screen;
     */
    void drawSprite(Graphics g){
        g.setColor(color);
        g.fillOval(xPosition,yPosition,size,size);
        g.setColor(Color.WHITE);
        g.fillOval((xPosition+(size/3)),yPosition+(size/3),size/4,size/4);
    }

    /**
     *
     * Will change the xPosition of the Sprite in the amount specified by
     * the function call;
     */
    void moveSprite(){
        xPosition = xPosition + xMove;
        yPosition = yPosition + yMove;
    }
    int[] returnCollisionBox(){
        int leftLocationX = xPosition - 1;
        int topLocationY = yPosition - 1;
        int rightLocationX = xPosition + size + 1;
        int bottomLocationY = yPosition + size + 1;

        int[] collisionCords = {leftLocationX, topLocationY, rightLocationX, bottomLocationY};
        return collisionCords;
    }
}
