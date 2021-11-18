package NaLongKa_Game;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class Hanuman {
    public ImageIcon Hw = new ImageIcon(this.getClass().getResource("Hanuman_walk.GIF"));
    public ImageIcon Hwk = new ImageIcon(this.getClass().getResource("Hanuman_walk.GIF"));
    public ImageIcon Hwb = new ImageIcon(this.getClass().getResource("Hanuman_back.gif"));
    public ImageIcon Hwbk = new ImageIcon(this.getClass().getResource("Hanuman_back.gif"));
    public ImageIcon Htkf = new ImageIcon(this.getClass().getResource("Hanuman_punch.gif"));
    public ImageIcon Htkb = new ImageIcon(this.getClass().getResource("Hanuman_punb.gif"));
    public int x = 5;
    public int y = 565; 
    public int hp = 300;
    public int damage = 20;
    public int count = 0;
    public int floor = 0;
    public int score = 0;
    public boolean door = false;
    int distanceP;
    int hit;
    
    Hanuman(int m){
        if(m==1){
            x=5; 
            y=400;
        }
        else if(m==2){
            x=5; 
            y=400;
        }
        else if(m==3){
            x=5;    
            y=400;
        }
    }
     public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,175,170)); 
	}
}
