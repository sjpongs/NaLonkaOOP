package NaLongKa_Game;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

public class Sahatsakuman2 {
    public ImageIcon MonsterSk = new ImageIcon(this.getClass().getResource("SahatsaKumanvol1.gif"));
    public ImageIcon MonsterSkat = new ImageIcon(this.getClass().getResource("SahatsaKumanvol1.gif"));
    public int x;
    public int y;
    public int count=0;
    public int hp = 130;
    public int damage = 15;
    public boolean alive = true;
    Sahatsakuman2(int m){
        if(m==1){
            x=200;  
            y=80;
        }
        else if(m==2){           
            x=700;  
            y=475;
        }
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,90,70));
    }
}
