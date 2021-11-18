package NaLongKa_Game;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;


public class Sahatsakuman1 {
    public ImageIcon YakORG = new ImageIcon(this.getClass().getResource("SahatsaKuman_org1.gif"));
    public ImageIcon YakORGh = new ImageIcon(this.getClass().getResource("SahatsaKuman_org1.gif"));
    public int x = 400;
    public int y = 130;
    public int hp = 100;
    public int damage = 10;
    public boolean alive = true;
    public int count = 0;
    int distanceP;
    int hit;

    Sahatsakuman1(int o){
        if(o==1){
            x=200;
            y=130;

        }
        else if(o==2){           
            x=600;
            y=480;

        }
    }

    
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,90,70));
	}
}
