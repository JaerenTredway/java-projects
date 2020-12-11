import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.Scanner;

public class Drawings extends Canvas {
    public static Color[][] colorArray = new Color[10][20];
    public static final int BLEND = 1;
    public static final int RANDOM = 0;
    public static final int CHECKER = 2;
    public static int MODE = BLEND;
    public static final Color BLACK = new Color(0,0,0);
    public static final Color WHITE = new Color(255,255,255);
    public static Color Background = new Color(243, 232, 222);


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which mode would you like to use? Type R for Random, B for blend, or C for checkerboard: ");
        char letter = sc.next().trim().charAt(0);
        if (letter == 'R')
            MODE = RANDOM;
        else if (letter == 'B')
            MODE = BLEND;
        else if (letter == 'C')
            MODE = CHECKER;

        if (MODE == BLEND) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    colorArray[i][j] = new Color(255, 255 - ((i + 1) * 10), 255 - ((j + 1) * 10));
                }
            }
        }
        else if (MODE == RANDOM ) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    colorArray[i][j] = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
                }
            }
        }
        if (MODE == CHECKER) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    if ((i+j) % 2 == 0) {
                        colorArray[i][j] = BLACK;
                        Background = new Color(9, 30, 158);
                    }
                    else if ((i+j) % 2 == 1) {
                        colorArray[i][j] = WHITE;
                        Background = new Color(9, 30, 158);
                        }
                    }
                }
            }


        Drawings canvas = new Drawings();
        canvas.setSize(800, 400);
        canvas.setBackground(Background);
        JFrame frame = new JFrame("Drawings"); //give screen a name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * This method draws things on the screen.
     * @param g the graphics object (screen) to draw on
     * See https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
     * for more drawing features
     */
    public void paint(Graphics g) {
        for (int i=0;i<10;i++) {
            for (int j=0; j<20; j++) {
                // See https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
                // for more information about color
                Color c = colorArray[i][j];
                g.setColor(c);
                g.fillOval(j*40 + 5,i*40 + 5,30,30);
            }
        }
    }
}