import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.Scanner;

public class Drawings extends Canvas {
    public static int numRows = 10;
    public static int numColumns = 20;
    public static int screenWidth = 800;
    public static int screenHeight = 400;
    public static Color[][] colorArray = new Color[numRows][numColumns];
    public static final int BLEND = 1;
    public static final int RANDOM = 0;
    public static int MODE = BLEND;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        chooseMode(sc);
        makePalette();
        Drawings canvas = new Drawings();
        setupScreen(canvas);
    }

    /**
     * This method sets up the screen
     * @param canvas the Drawings object to show output
     */
    public static void setupScreen(Drawings canvas){
        canvas.setSize(screenWidth, screenHeight);
        canvas.setBackground(new Color(243, 232, 222));
        JFrame frame = new JFrame("Drawings"); //give screen a name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * This method gets user input to choose the type of palette
     * @param sc the scanner object to get input
     */
    public static void chooseMode(Scanner sc){
        System.out.print("Which mode would you like to use? Type R for Random and B for blend: ");
        char letter = sc.next().trim().charAt(0);
        if (letter == 'R')
            MODE = RANDOM;
        else if (letter == 'B')
            MODE = BLEND;
    }

    /**
     * This method fills the color array based on chosen mode
     */
    public static void makePalette(){
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (MODE == BLEND)
                    colorArray[i][j] = new Color(255, 255 - ((i + 1) * 10), 255 - ((j + 1) * 10));
                else if (MODE == RANDOM)
                    colorArray[i][j] = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
            }
        }
    }

    /**
     * This method draws things on the screen.
     * @param g the graphics object (screen) to draw on
     * See https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
     * for more drawing features
     */
    public void paint(Graphics g) {
        for (int i=0;i<numRows;i++) {
            for (int j=0; j<numColumns; j++) {
                // See https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
                // for more information about color
                Color c = colorArray[i][j];
                g.setColor(c);
                g.fillOval(j*40 + 5,i*40 + 5,30,30);
            }
        }
    }
}