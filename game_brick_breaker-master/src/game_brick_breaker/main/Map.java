

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Map {
    // Fields 
    private int[][] theMap;
    private int brickHeight, brickWidth; // chieu dai va chieu rong cua vien gach

    public final int HOR_PAD = 80, VERT_PAD = 50; // set gap của chiều dọc và chiều ngang


    public Map(int row, int col){
        initMap(row, col);
        brickWidth = (BBMain.WIDTH - 2 * HOR_PAD) / col; // set chiều rộng cho viên gạch
        brickHeight =  (BBMain.HEIGHT / 2 - VERT_PAD*2)/ row; // set chiều dài cho viên gạch
    }

    // khoi tao Map
    public void initMap(int row, int col){
        theMap = new int[row][col];
        for(int i=0;i<theMap.length;i++){
            for(int j=0;j<theMap[0].length;j++){
                // tăng độ cứng của viên gạch từ 1 đến 4 random
                int r = (int)(Math.random()*4 + 1);
                theMap[i][j] = r;
            }
        }
    }

    // vẽ những viên gạch
    public void draw(Graphics2D g){
        for(int row = 0; row <theMap.length; row++){
            for(int col =0; col<theMap[0].length; col++){
                if(theMap[row][col] > 0){
                    
                    if(theMap[row][col]==1){
                        g.setColor(new Color(0, 200, 200));
                    }

                    if(theMap[row][col]==2){
                        g.setColor(new Color(0, 150, 150));
                    }

                    if(theMap[row][col]==3){
                        g.setColor(new Color(0, 100, 100));
                    }

                    if(theMap[row][col]==4){
                        g.setColor(new Color(0, 50, 50));
                    }


                    g.fillRect(col * brickWidth + HOR_PAD, row * brickHeight + VERT_PAD, brickWidth, brickHeight);
                    g.setStroke(new BasicStroke(2));
                    g.setColor(Color.WHITE);
                    g.drawRect(col * brickWidth + HOR_PAD, row * brickHeight + VERT_PAD, brickWidth, brickHeight);
                }
                
            }
        }
    }

    // check đã phá hết gạch hay chưa 
    public boolean isThereAWin(){
        
        boolean thereIsWin = false;
        int bricksRemaining = 0;

        for(int row = 0; row <theMap.length; row++){
            for(int col = 0 ; col < theMap[0].length; col++){
                bricksRemaining += theMap[row][col];
            }
        }

        if(bricksRemaining == 0){
            thereIsWin = true;
        }

        return thereIsWin;
    }


    public int[][] getMapArray(){
        return theMap;
    }

    public void setBrick(int row, int col, int value){
        theMap[row][col] = value;
    }

    public int getBrickWidth(){
        return brickWidth;
    }

    public int getBrickHeight(){
        return brickHeight;
    }

    public void hitBrick(int row, int col){
        theMap[row][col] -= 1;
        if(theMap[row][col]<0){
            theMap[row][col] = 0;
        }
    }
    
}
