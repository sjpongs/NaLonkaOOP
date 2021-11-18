package NaLongKa_Game;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class trephet {
    public ImageIcon lever = new ImageIcon(this.getClass().getResource("trephet.png"));
    public ImageIcon leverb = new ImageIcon(this.getClass().getResource("trephetNULL.png"));
    public int x;
    public int y;
    int distanceP;
    trephet(int m){
        if(m==1){
            x = 650;
            y = 158;
        }
        else if(m==2){
            x = 1100;
            y = 505;
        }
        else if(m==3){
            x = 680;
            y = 430;
        }
        else if(m==22){
            x = 1000;
            y = 105;
        }
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,40,45));
	}
}
