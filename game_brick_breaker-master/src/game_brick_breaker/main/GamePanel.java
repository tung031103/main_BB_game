

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
public class GamePanel extends JPanel implements Runnable{

    // Fields
    private boolean running;
    private BufferedImage image;
    private Graphics2D g;
    private MyMouseMotionListener mouseMotionListener;

    private int mousex;

    // entities
    Ball ball;
    Paddle paddle;
    Map map;
    HUD hud;


    public GamePanel(){
        init();
        this.setPreferredSize(new Dimension(BBMain.WIDTH,BBMain.HEIGHT));
    }


    public void init(){

        mousex = 0;
        ball = new Ball();
        paddle = new Paddle();
        map = new Map(6, 10); // khởi tạo 6 hàng và 10 cột
        hud = new HUD();


        mouseMotionListener = new MyMouseMotionListener();
        addMouseMotionListener(mouseMotionListener);
        running = true; 
        image = new BufferedImage(BBMain.WIDTH,BBMain.HEIGHT,BufferedImage.TYPE_INT_RGB); 
        g = (Graphics2D) image.getGraphics();// khởi tạo để draw mọi thứ trong game

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }
    @Override
    public void run() {
        
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            
        }

        // game loop
        while(running){
            // update
            update(); // cập nhật lại những


            // render or draw
            draw();

            //display
            repaint(); // vẽ lại những gì đã diễn ra

            try{
                Thread.sleep(12);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    // check sự va chạm giữa ball và paddle
    public void checkCollision(){
        Rectangle ballRect = ball.getRect();
        Rectangle paddleRect = paddle.getRect();

        if(ballRect.intersects(paddleRect)){  // check sự va nhau giữa ball và paddle
            ball.setDY(-ball.getDY()); 

            //giảm tốc độ bóng
            if(ball.getX() < mousex + paddle.getWidth()/4 ){
                ball.setDX(ball.getDX()- 1.0);
            }

            //tăng tốc độ bóng
            if(ball.getX() < mousex + paddle.getWidth() && ball.getX() > mousex + paddle.getWidth() / 4){
                ball.setDX(ball.getDX()+ 1.0);
            }


        } 

        // A: nghĩa là sau khi tìm thấy một vụ va chạm,
        // ta muốn tiếp tuc kiem tra phan con lai cua map
        A: for(int row=0;row<map.getMapArray().length;row++){
            for(int col =0;col<map.getMapArray()[0].length;col++){
                if(map.getMapArray()[row][col]> 0){
                    int brickx =  col * map.getBrickWidth() + map.HOR_PAD;
                    int bricky = row * map.getBrickHeight() + map.VERT_PAD;
                    int brickWidth = map.getBrickWidth();
                    int brickHeight = map.getBrickHeight();

                    Rectangle brickRect = new Rectangle(brickx, bricky, brickWidth, brickHeight);
                    if(ballRect.intersects(brickRect)){
                        map.hitBrick(row, col);
                        ball.setDY(-ball.getDY());

                        hud.addScore(50);

                        break A;
                        // break A nghĩa là khi thấy sự va chạm giữa bóng 
                        //va map thì hãy dừng tất cả mọi thứ sau đó tiếp 
                        //tục với chương trình dể quả di chuyển về phía trước
                    
                    }
                }
            }
        }
        
    }



    public void update(){
        checkCollision();  
        ball.update();


        // paddle.update();
    }

    public void draw(){

        // draw background
        g.setColor(Color.white);
        g.fillRect(0, 0, BBMain.WIDTH, BBMain.HEIGHT);

        map.draw(g); // gọi hàm vẽ gạch
        ball.draw(g); // gọi hàm vẽ bóng
        paddle.draw(g); // gọi hàm vẽ 
        hud.draw(g); // gọi hàm vẽ điểm


        // nếu vỡ hết gạch sẽ Win 
        if(map.isThereAWin() == true){
            drawWin(g);
            running = false;
        }

        // nếu bóng rơi xuống dưới thấp hơn paddle sẽ thua
        if(ball.youLose()){
            drawLoser(g);
            running = false;
        }

        
    }

    public void drawWin(Graphics2D g){
        g.setColor(Color.red);
        g.setFont(new Font("Courier New",Font.BOLD,50));
        g.drawString("Winner!", 200, 200);
    }

    public void drawLoser(Graphics2D g){
        g.setColor(Color.red);
        g.setFont(new Font("Courier New",Font.BOLD,50));
        g.drawString("Loser!", 200, 200);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image, 0, 0, BBMain.WIDTH,BBMain.HEIGHT,null); 
        g2.dispose(); // để loại bổ những thứ đã vẽ trước đó
    }


    // dùng chuột để di chuyển Paddle
    private class MyMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mousex = e.getX();
            paddle.MouseMoved(e.getX());
        }
        
    }

}
