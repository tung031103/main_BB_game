
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

public class StartGame extends JFrame implements ActionListener{

    JPanel pnStart, pnImage;
    JButton buttonStart;
    ImageIcon imageIcon, img_BB;
    JLabel lbBackground;


    public StartGame(){
        img_BB = new ImageIcon("F:\\game\\java_Game_bb-master\\game_brick_breaker-master\\src\\res\\img_BB5.png");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Màn hình Start Game");
        this.setSize(500, 500);
        this.getContentPane().setBackground(Color.green);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnStart = new JPanel();
        pnStart.setBackground(Color.green);
        pnStart.setLayout(new FlowLayout(FlowLayout.CENTER));
        imageIcon = new ImageIcon("F:\\game\\java_Game_bb-master\\game_brick_breaker-master\\src\\res\\playGameBB1.png");
        buttonStart = new JButton(imageIcon);
        buttonStart.setPreferredSize(new Dimension(100, 36));
        buttonStart.setFocusable(false);
        buttonStart.addActionListener(this);
        pnStart.add(buttonStart);
        pnImage = new JPanel();
        pnImage.setPreferredSize(new Dimension(500, 430));
        lbBackground = new JLabel(img_BB);
        pnImage.add(lbBackground);
        pnImage.setBackground(Color.green);
        this.add(pnStart);
        this.add(pnImage);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonStart){
            new BBMain();
        }
    }
}
