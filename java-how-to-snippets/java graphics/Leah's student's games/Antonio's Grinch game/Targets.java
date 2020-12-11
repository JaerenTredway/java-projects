import java.awt.*;

public class Targets {

    // Creates variables
    int xPosition, yPosition;
    int size;
    int xSpeed, ySpeed;
    int min, max, max1;
    Color color, wrapColor;

    /**
     * Initializes variables
     * @param xPositionIn sets xPosition
     * @param yPositionIn sets yPosition
     * @param sizeIn sets size of targets
     */
    Targets(int xPositionIn, int yPositionIn, int sizeIn) {
        xPosition = xPositionIn;
        yPosition = yPositionIn;
        size = sizeIn;
        min = 3;
        max = 7;
        max1 = 10;
        xSpeed = (int)(Math.random()*(max - min +1) + min);
        ySpeed = (int)(Math.random()*(max1 - min + 1) + min);
        color = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
        wrapColor = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    }

    /**
     * Sets color for targets
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws the targets onto the screen
     * @param g the Graphics object to draw on
     */
    public void drawTargets(Graphics g) {
            g.setColor(color);
            g.fillRect(xPosition-size/2, yPosition-size/2, size, size);
            g.setColor(wrapColor);
            g.fillRect(xPosition-size/10, yPosition-size/2, size/4, size);
            g.fillRect(xPosition-size/2, yPosition-size/10, size, size/4);
            g.setColor(Color.RED);
            g.fillOval(xPosition-8, yPosition-40, size/3, size/3);
    }

    /**
     * Moves the targets automatically
     */
    public void move() {
        xPosition += xSpeed;
        yPosition += ySpeed;
    }

    /**
     * Makes targets bounce off walls
     * @param screenSize used as perimeter for screen
     */
    public void bounce(int screenSize) {
        if(xPosition < 0 || xPosition > screenSize)
            xSpeed = -xSpeed;
        if(yPosition < 0 || yPosition > screenSize)
            ySpeed = -ySpeed;
    }
}
