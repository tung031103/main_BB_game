

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class HUD {
    // Fields
    private int score;


    public HUD(){
        init();
    }

    public void init(){
        score = 0;

    }

    public void draw(Graphics2D g){
        g.setColor(Color.red);
        g.setFont(new Font("Courier New",Font.BOLD,14));
        g.drawString("Score: " + score, 20, 20);
    }

    public void addScore(int scoreToAdd){
        score += scoreToAdd;
    }

    public int getScore(){
        return score;
    }
}
