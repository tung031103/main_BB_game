

import javax.swing.JFrame;

public class BBMain {
    public static final int WIDTH = 640, HEIGHT = 480;
    public BBMain(){
        GamePanel gamePanel = new GamePanel();
        JFrame frame = new JFrame("Brick breaker");
        Thread thread = new Thread(gamePanel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(WIDTH,HEIGHT);
        frame.add(gamePanel);
        thread.start();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
