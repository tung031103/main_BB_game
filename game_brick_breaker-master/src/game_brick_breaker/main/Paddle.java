

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Paddle {
    
    //Fields

    private double x;
    private int width = 100, height = 20;

    public final int Ypos = BBMain.HEIGHT - 100; // set vi tri cho truc y


    public Paddle(){
        x = BBMain.WIDTH / 2 - width / 2; // set cho truc x
    }

    //update
    public void update(){

    }

    // draw
    public void draw(Graphics2D g){
        g.setColor(Color.red);
        g.fillRect((int)x, Ypos, width, height);
    }

    // dùng chuột để di chuyển Paddle
    public void MouseMoved(int mousePosX){
        x = mousePosX;
        if(x > BBMain.WIDTH - width){
            x = BBMain.WIDTH - width;
        }

    }


    public Rectangle getRect(){
        return new Rectangle((int)x,Ypos, width,height);
    }

    public int getWidth(){
        return width;
    }
}   
