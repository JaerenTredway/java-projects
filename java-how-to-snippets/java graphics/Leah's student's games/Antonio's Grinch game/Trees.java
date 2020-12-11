import java.awt.*;

public class Trees {

    // Creates variables
    int xPosition, yPosition;
    int size;
    Color color, lightColor;

    /**
     * Initializes variables
     * @param xPositionIn sets xPosition
     * @param yPositionIn sets yPosition
     * @param sizeIn sets size
     */
    Trees(int xPositionIn, int yPositionIn, int sizeIn) {
        xPosition = xPositionIn;
        yPosition = yPositionIn;
        size = sizeIn;
        color = new Color(33, 125, 7);
        lightColor = new Color(255, 0, 0);
    }

    /**
     * Sets color of trees.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws trees onto screen by calling the methods
     * that create the tree.
     * @param g the Graphics object to draw on
     */
    public void drawTrees(Graphics g) {
        drawTrunk(g);
        drawTreetop((Graphics2D) g);
    }

    /**
     * Draws trunk of tree
     * @param g the Graphics object to draw on
     */
    public void drawTrunk(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(xPosition+size+size/6, yPosition+size, size/5,size/5*3);
        g.setColor(color);
    }

    /**
     * Draws the top part of the tree.
     * @param g2 the Graphics object to draw on
     */
    public void drawTreetop(Graphics2D g2) {
        int xPoints[] = {xPosition, xPosition+size/2, xPosition+size/4, xPosition+size/4*3, xPosition+size/2, xPosition+size, xPosition+size/4*3,
                xPosition+size+size/4, xPosition+size+size/4*3, xPosition+size+size/2, xPosition+size*2, xPosition+size+size/4*3, xPosition+size*2+size/4,
                xPosition+size*2, xPosition+size*2+size/2};
        int yPoints[] = {yPosition+size, yPosition, yPosition, yPosition-size, yPosition-size, (yPosition+size)-size*3,
                yPosition-size*2, yPosition-size*3, yPosition-size*2, yPosition-size*2, yPosition-size,
                yPosition-size, yPosition, yPosition, yPosition+size};
        int cPoints = 15;
        g2.fillPolygon(xPoints, yPoints, cPoints);
        g2.setStroke(new BasicStroke(size/15));
        g2.setColor(lightColor);
        g2.drawLine(xPosition+size/2, yPosition, xPosition+size*2+size/2, yPosition+size);
        g2.setColor(Color.BLUE);
        g2.drawLine(xPosition+size/4*3, yPosition-size, xPosition+size*2, yPosition);
        g2.setColor(Color.GREEN);
        g2.drawLine(xPosition+size, yPosition-size*2, xPosition+size+size/4*3,yPosition-size);
    }
}