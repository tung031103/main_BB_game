

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
 
    private double x, y, dx, dy;
    private int ballSize = 30;
    public Ball(){
        x = 200;
        y = 200;
        dx = 1;
        dy = 3;
    }   

    public void update(){
        setPosition();
    }

    public void setPosition(){

        // tăng vận tốc quả bóng
        x += dx;
        y += dy;


        // check collision(kiểm tra bóng đã va chạm)
        if(x < 0){
            dx = -dx;
        }
        if(y < 0){
            dy = -dy;
        }

        if(x > BBMain.WIDTH - ballSize){
            dx = -dx;
        }

        if(y > BBMain.HEIGHT - ballSize){
            dy = -dy;
        }
    }

    public void draw(Graphics2D g){
        g.setColor(Color.green);
        g.setStroke(new BasicStroke(4));
        g.fillOval((int)x, (int)y, ballSize, ballSize);
    }

    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,ballSize,ballSize);
    }

    // get direction Y
    public double getDY(){
        return dy;
    }

    public void setDY(double dy){
        this.dy = dy;
    }

    public void setDX(double dx){
        this.dx = dx;
    }

    public double getDX(){
        return dx;
    }

    public double getX(){
        return x;
    }


    // check quả bóng có vượt qua paddle hay ko
    public boolean youLose(){
        boolean loser = false;
        if(y > BBMain.HEIGHT - ballSize * 2){
            loser = true;
        }

        return loser;
    }

}
