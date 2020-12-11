import java.awt.*;
import java.awt.geom.Point2D;

public class Sprite {

    // Creates variables
    int xPosition, yPosition;
    int size;
    int xSpeed, ySpeed;
    int keycode;
    Color color;
    Color eyeColor;
    Point2D.Double point;

    /**
     * Initializes variables
     * @param xPositionIn set as xPosition
     * @param yPositionIn set as yPosition
     * @param sizeIn sets size of Sprite
     * @param keycodeIn creates the keycode that will be used
     *                  as a parameter.
     */
    Sprite(int xPositionIn, int yPositionIn, int sizeIn, int keycodeIn) {
        xPosition = xPositionIn;
        yPosition = yPositionIn;
        size = sizeIn;
        xSpeed = 50;
        ySpeed = 50;
        keycode = keycodeIn;
        color = new Color(2, 156, 2);
        eyeColor = new Color(222, 193, 29);

        // Creates distance that is used for collision in Game.
        point = new Point2D.Double(xPositionIn, yPositionIn);
    }

    /**
     * Sets the color for the sprite
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws the sprite on the screen by calling the methods
     * that create the sprite.
     * @param g the Graphics object to draw on
     */
    public void drawSprite(Graphics g) {
        drawHead(g);
        drawSmileandNose((Graphics2D) g);
        drawEyes(g);
        drawHat(g);
       }

    /**
     * Draws head
     * @param g the Graphics object to draw on
     */
    public void drawHead(Graphics g) {
           g.setColor(color);
           g.fillOval(xPosition+size/4, yPosition-size/2, size, size + (size / 2));
           g.fillOval(xPosition, yPosition, size + (size / 2), size);
       }

    /**
     * Draws smile and nose
     * @param g2 the Graphics object to draw on
     */
    public void drawSmileandNose(Graphics2D g2) {
           // Draws Smile
           g2.setStroke(new BasicStroke(1));
           g2.setColor(Color.BLACK);
           g2.drawArc(xPosition+size/4,yPosition,size,size,180,180);
           g2.drawLine(xPosition+size/10, yPosition+size/2, xPosition+size/5*2, yPosition+size/2);
           g2.drawLine(xPosition+size+size/10, yPosition+size/2, xPosition+140, yPosition+size/2);

           // Draws nose
           g2.fillOval(xPosition+size/4*3,yPosition+size/4,size/10, size/10);
       }

    /**
     * Draws eyes
     * @param g the Graphics object to draw on
     */
    public void drawEyes(Graphics g) {
           g.setColor(eyeColor);
           g.fillRect(xPosition+size/2,yPosition-size/10,size/7,size/5);
           g.fillOval(xPosition+size/2,yPosition-size/10,size/4,size/3);
           g.fillRect(xPosition+size/20*19,yPosition-size/10,size/7,size/5);
           g.fillOval(xPosition+size/20*17,yPosition-size/10,size/4,size/3);
           g.setColor(Color.BLACK);
           g.fillOval(xPosition+size/20*11,yPosition-size/10,10,20);
           g.fillOval(xPosition+size/20*18,yPosition-size/10,10,20);
           g.setColor(eyeColor);
           g.fillOval(xPosition+size/20*11,yPosition-size/10,5,10);
           g.fillOval(xPosition+size/20*18,yPosition-size/10,5,10);
    }

    /**
     * Draws hat
     * @param g the Graphics object to draw on
     */
       public void drawHat(Graphics g) {
           g.setColor(Color.WHITE);
           g.fillOval(xPosition+size/4,yPosition-size/2,size,size/4);
           g.setColor(Color.RED);
           int xPoints[] = {xPosition+size/2, xPosition+size/4*3, xPosition+size};
           int yPoints[] = {yPosition-size/2, yPosition - size, yPosition-size/2};
           int cPoints = 3;
           g.fillPolygon(xPoints, yPoints, cPoints);
           g.setColor(Color.WHITE);
           g.fillOval(xPosition+size/20*13, yPosition-size, size/5,size/5);
       }

    /**
     * Moves sprite with keycode
     * @param keycode used to move sprite
     */
    public void move(int keycode) {
        if (keycode == 39) { //right arrow key
            xPosition += xSpeed;
        }
        if (keycode == 37) { //left arrow key
            xPosition -= xSpeed;
        }
        if (keycode == 38) { //up arrow key
            yPosition -= ySpeed;
        }
        if (keycode == 40) { //down arrow key
            yPosition += ySpeed;
        }
    }

    /**
     * Makes sure sprite does not fall off screen
     * @param screenSize used to set perimeter for screen
     */
    public void playArea(int screenSize) {
        if(xPosition < 0)
            xPosition = screenSize;
        if(xPosition > screenSize)
            xPosition = 0;
        if(yPosition < 0)
            yPosition = screenSize;
        if(yPosition > screenSize)
            yPosition = 0;
    }
}
