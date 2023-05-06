
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

public class StartGame extends JFrame implements ActionListener{

    JPanel pnStart;
    JButton buttonStart;
    ImageIcon imageIcon;


    public StartGame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.getContentPane().setBackground(Color.blue);
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
        this.add(pnStart);
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
