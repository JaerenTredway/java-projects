import java.awt.*;

public class BackgroundSnow {

    // Creates variables
    int xPosition, yPosition;
    int size;
    int xSpeed, ySpeed;
    int min, max;
    Color color;

    /**
     * Initializes variables
     * @param xPositionIn sets xPosition
     * @param yPositionIn sets yPosition
     * @param sizeIn sets size
     */
    BackgroundSnow(int xPositionIn, int yPositionIn, int sizeIn) {
        xPosition = xPositionIn;
        yPosition = yPositionIn;
        size = sizeIn;
        min = 1;
        max = 10;
        xSpeed = (int)(Math.random()*1);
        ySpeed = (int)(Math.random()*(max - min + 1) + min);
        color = new Color(255,255,255);
    }

    /**
     * Sets color for snow
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws the snow on the screen
     * @param g the Graphics object to draw on
     */
    public void drawSnow(Graphics g) {
        g.setColor(color);
        g.fillOval(xPosition-size/2, yPosition-size/2, size, size);
    }

    /**
     * Moves the snow automatically
     */
    public void move() {
        xPosition += xSpeed;
        yPosition += ySpeed;
    }

    /**
     * Sets area for snow to move
     */
    public void snowArea(int screenSize) {
        if(yPosition > screenSize)
            yPosition = 0;
    }
}