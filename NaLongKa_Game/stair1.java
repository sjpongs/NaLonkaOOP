package NaLongKa_Game;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class stair1 {
    public ImageIcon stair = new ImageIcon(this.getClass().getResource("stair1.png"));
   
    public int x;
    public int y;
    public int w;
    public int h;
    stair1(int m){
        if(m==1){
            x=430;
            y=380;
            w=380;
            h=200;
            
        }
        else if(m==2){
                     
            x=600;
            y=142;
            w=38;
            h=200;
            
        }
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,w,h));
	}
    
}
