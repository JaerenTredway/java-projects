//package events;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interactive extends Canvas implements KeyListener
{
    char keypressed;
    int screenSize;
    Color backgroundColor;

    public static void main(String[] args) {
        Interactive keyboardExample = new Interactive();
        keyboardExample.setupScreen(keyboardExample);
    }

    //CONSTRUCTOR:
    Interactive () {
        screenSize = 500;
        backgroundColor = new Color(239,248,207);
    }

    //build the screen:
    void setupScreen(Interactive canvas) {
        JFrame frame = new JFrame("Keyboard interaction"); //give screen a name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setSize(screenSize, screenSize);
        canvas.setBackground(new Color(239, 248, 207));
        canvas.addKeyListener(canvas);  //tell the canvas that you will be "listening for keyboard interactions"
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        canvas.requestFocusInWindow();
        //prints out a list of all available fonts
        canvas.listFonts();
    }


    //draws everything on the screen:
    public void paint(Graphics g) {
        // See https://docs.oracle.com/javase/7/docs/api/java/awt/Font.html
        // for more information about what you can do with fonts
        Font zapfino = new Font("Zapfino", Font.BOLD, 78);
        g.setFont(zapfino);
        g.setColor(Color.BLACK);
        g.drawString(Character.toString(keypressed), 240,250);

        if (keypressed == 'r') {
            g.setColor(Color.RED);
            g.fillRect(screenSize/2-50, screenSize/2-50, 100, 100);
        }
        else if (keypressed == 'b') {
            g.setColor(Color.BLUE);
            g.fillOval(screenSize/2-50, screenSize/2-50, 100, 100);
        }
        else if (keypressed == 'g') {
            g.setColor(Color.GREEN);
            int[] xPoints = {screenSize/2-50, screenSize/2, screenSize/2 + 50};
            int[] yPoints = {screenSize/2+50, screenSize/2-50, screenSize/2 + 50};
            g.fillPolygon(xPoints,yPoints,3);
        }
    }


    //this listens for keyboard events and records them:
    //(does not pick up return, delete, shift, etc)
    public void keyTyped(KeyEvent e) {
        keypressed = e.getKeyChar();
        repaint();
    }


    //this prints out the code of each key pressed:
    //(includes special keys like return, shift, etc.)
    public void keyPressed(KeyEvent e) {
        System.out.println("The keycode for this key is: " + e.getKeyCode());
        repaint();
    }

    //responds to release of a key:
    public void keyReleased(KeyEvent e) {
    }


    //prints out all available fonts:
    void listFonts() {
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for ( int i = 0; i < fonts.length; i++ )
        {
            System.out.println(fonts[i]);
        }
    }

}//EOF
