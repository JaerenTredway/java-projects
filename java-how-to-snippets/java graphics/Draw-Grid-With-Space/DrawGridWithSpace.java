import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.Scanner;

public class Assignment9 extends Canvas {
    static int rows;
    static int columns;
    static int gridSize = 50;
    static int width = 45;
    static int height =45;

    public static void main(String[] args) {
        Assignment9 canvas = new Assignment9(); // creating new object type canvas
        setup(canvas); // this sets up the screen
    }

    /**
     * This method draws things on the screen.
     * @param g the graphics object (screen) to draw on
     * See https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
     * for more drawing features
     */
    public void paint(Graphics g) {
        /**
         * This method iterates over two for loops using rows and columns as stopping points
         * In order to assign a new random color to each square that is drawn.
         */
        for (int i=0;i< rows;i++) {
            for (int j=0; j< columns; j++) {
                Color c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
                g.setColor(c);
                g.fillRect(j*gridSize, i*gridSize, width, height);
            }
        }
    }

    /**
     * This method sets up the screen and asks users for input.
     * @param canvas
     */
    public static void setup(Assignment9 canvas){
        String windowName;
        Scanner sc = new Scanner(System.in);
        System.out.print("How many rows do you want the grid to have? ");
        rows = sc.nextInt();
        System.out.print("How many columns do you want the grid to have? ");
        columns = sc.nextInt();
        System.out.print("What should the window be called? ");
        windowName = sc.next();

        canvas.setSize(columns*50, rows*50);
        canvas.setBackground(Color.WHITE);
        JFrame frame = new JFrame(windowName); //give screen a name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
