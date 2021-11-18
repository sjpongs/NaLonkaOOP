package NaLongKa_Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StartGame extends JPanel {
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("1index.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("startb.png"));
    public JButton StartGame = new JButton(starts);
    
    
    StartGame(){
        setLayout(null);
        StartGame.setBounds(800, 488, 300, 100); 
        StartGame.setBorderPainted(false);
        StartGame.setBorder(null);
        StartGame.setOpaque(false);
        StartGame.setContentAreaFilled(false);
        add(StartGame);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
         g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
    }
}
