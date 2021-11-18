package NaLongKa_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;// import

public class stage1 extends JPanel implements ActionListener{
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("scenehaft.png")); //v1
    private ImageIcon day = new ImageIcon(this.getClass().getResource("day.png"));
    private ImageIcon died = new ImageIcon(this.getClass().getResource("died.png"));
    private ImageIcon stone = new ImageIcon(this.getClass().getResource("it.png")); 
    private ImageIcon stone2 = new ImageIcon(this.getClass().getResource("it2.png")); 
    private ImageIcon aa = new ImageIcon(this.getClass().getResource("trephet.png"));
    private ImageIcon water = new ImageIcon(this.getClass().getResource("nam.png"));
    private ImageIcon nextstagebutton = new ImageIcon(this.getClass().getResource("nextstage.png")); 
    private ImageIcon againbutton = new ImageIcon(this.getClass().getResource("click to play again.png")); //agin
    private ImageIcon closebutton = new ImageIcon(this.getClass().getResource("closebt.png")); 
    Hanuman RingRam = new Hanuman(1);
    Sahatsakuman1 SH = new Sahatsakuman1(1);
    Sahatsakuman1 SH2 = new Sahatsakuman1(2);
    trephet lever = new trephet(1);
    door door = new door(1);
    stair1 stair1 = new stair1(1);
    stair2 stair2 = new stair2(1);
    stair3 stair3 = new stair3(1);
    int checkbacktofront = 0;
    boolean hit = false;
    boolean hit2 = false;
    public int checkdoor = 0;
    public int checklever = 0;
    public int checknear = 0;
    public int times;
    public int checkattack;
    boolean timestart = true;
    boolean nextstage = false;
    //////////////////////////////////////////////////////////////////////////////
    public int xx = RingRam.x;
    public int yy = RingRam.y;
    public int hpp = RingRam.hp;
    public int floors = RingRam.floor;
    public boolean doors = RingRam.door;
    /////////////////////////////////////////////////////////////////////////////////
    private Timer timer = new Timer(100, new Listener());
    private Timer timercount = new Timer(1000, new Listener());
    public JButton nextstagebt = new JButton(nextstagebutton);
    public JButton closebt = new JButton(closebutton);
    Thread time = new Thread(new Runnable(){
        public void run(){
            int check=0;
            while(true){
                try{
                    
                    if(Intersect(SH.getbound(),RingRam.getbound())){
                        SH.count=1; 
                    }
                    else{
                        if(SH.alive == true){
                            if(SH.x==400){ // 400
                                check = 0;
                                SH.x+=5; // + 5
                            }
                            else if(SH.x==500){ // 500
                                check = 1; //1
                                SH.x-=5;//5
                            }
                            else{
                                if(check==0){ //0
                                  SH.x+=5;  //5
                                }
                                else{
                                    SH.x-=5; //5
                                }
                            }
                    }
                 }                   
                    Thread.sleep(100);
                    
                }catch(Exception e){
                 
                }
                
                if(timestart == false){
                    repaint();
                }
            }
        }
    });

    stage1(){
        timer.start();
        time.start();
        timercount.start();
        this.setFocusable(true);
        this.setLayout(null);
        
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a==KeyEvent.VK_RIGHT){
                    checkbacktofront = 0;
                    if(checkbacktofront==0){
                        if(RingRam.floor == 0){
                            if(RingRam.x>=1100){
                                RingRam.x = 1100;
                            }
                            else if(Intersect(stair1.getbound(),RingRam.getbound())){   
                                if(RingRam.y>=565){ //565
                                    RingRam.x+=10;
                                }
                            }
                             else if(Intersect(stair3.getbound(),RingRam.getbound())){   
                                if(RingRam.y>=565){
                                    RingRam.x+=10;
                                }
                            }
                            else{
                                RingRam.x+=10;
                                RingRam.count++;
                            }
                        }
                        else if(RingRam.floor == 1){
                            if(RingRam.x>=290){
                                RingRam.x = 290;
                            }
                            else if(Intersect(stair1.getbound(),RingRam.getbound())){   
                                if(RingRam.y<=565){
                                    RingRam.x+=10;
                                }
                            }
                            else if(Intersect(stair2.getbound(),RingRam.getbound())){
                                if(RingRam.y>=355){
                                    RingRam.x+=10;
                                }
                            }
                            else{
                                RingRam.x+=10;
                                RingRam.count++;
                            }
                        }
                        else if(RingRam.floor == 3){
                            if(RingRam.x>=580){
                                RingRam.x = 580;
                            }                          
                            else if(Intersect(stair2.getbound(),RingRam.getbound())){
                                if(RingRam.y>=130){
                                    RingRam.x+=10;
                                }
                            }
                            else{
                                RingRam.x+=10;
                                RingRam.count++;
                            }
                        }
                        else if(RingRam.floor == 2){
                            if(RingRam.x>=1100){
                                RingRam.x = 1100;
                            }                          
                            else if(Intersect(stair3.getbound(),RingRam.getbound())){
                                if(RingRam.y<=310){
                                    RingRam.x+=10;
                                }
                            }
                            else{
                                RingRam.x+=10;
                                RingRam.count++;
                            }
                        }
                    }
                    if(RingRam.count >= 2){
                        RingRam.count = 0;
                    }
                }
                else if(a==KeyEvent.VK_LEFT){
                    checkbacktofront = 1;
                    if(RingRam.floor==0){
                        if(RingRam.x <= 0){
                            RingRam.x = 0;
                        }
                        else if(Intersect(stair1.getbound(),RingRam.getbound())){
                            if(RingRam.y >= 565){
                                RingRam.x-=10;
                            }
                        }
                        else if(Intersect(stair3.getbound(),RingRam.getbound())){
                            if(RingRam.y >= 565){
                                RingRam.x-=10;
                            }
                        }
                        else{
                            RingRam.x-=10;
                            RingRam.count++;
                        }
                    }
                    else if(RingRam.floor==1){
                        if(RingRam.x <= 0){
                            RingRam.x = 0;
                        }
                        else if(Intersect(stair1.getbound(),RingRam.getbound())){
                            if(RingRam.y <= 355){
                                RingRam.x-=10;
                            }
                        }
                        else if(Intersect(stair2.getbound(),RingRam.getbound())){
                             if(RingRam.y >= 355){
                                RingRam.x-=10;
                            }
                        }
                        else{
                            RingRam.x-=10;
                            RingRam.count++;
                        }
                    }
                    else if(RingRam.floor==3){
                        if(RingRam.x <= 0){
                            RingRam.x = 0;
                        }
                        else if(Intersect(stair2.getbound(),RingRam.getbound())){
                             if(RingRam.y <= 130){
                                RingRam.x-=10;
                            }
                        }
                        else{
                            RingRam.x-=10;
                            RingRam.count++;
                        }
                    }
                    else if(RingRam.floor==2){
                        if(RingRam.x <= 850){
                            RingRam.x = 850;
                        }
                        else if(Intersect(stair3.getbound(),RingRam.getbound())){
                             if(RingRam.y <= 310){
                                RingRam.x-=10;
                            }
                        }
                        else{
                            RingRam.x-=10;
                            RingRam.count++;
                        }
                    }
                    if(RingRam.count >= 2){
                        RingRam.count = 0;
                    }  
                }
                else if(a == KeyEvent.VK_SPACE){
                    if(checkattack == 0){
                        checkattack = 1;
                    }
                    if(Intersect(SH.getbound(),RingRam.getbound())){
                        if(SH.hp==0){
                            SH.hp=0;
                        }
                        SH.hp-=RingRam.damage;
                    }
                }
                else if(a == KeyEvent.VK_X){
                    
                    if(Intersect(lever.getbound(),RingRam.getbound())){
                        checklever = 1;
                        checkdoor = 1;
                    }
                    if(Intersect(door.getbound(),RingRam.getbound())){
                        if(checkdoor == 1){
                            nextstage = true;
                        }
                        else nextstage = false;
                        
                    }
                    else nextstage = false;
                }
                else if(a == KeyEvent.VK_G){
                    nextstage = true;
                }
////////////////////////////////////////////////////////////////ตำแหน่งทางเดิน
                else if(a==KeyEvent.VK_UP){
                    if(RingRam.floor==0){
                        if(Intersect(stair1.getbound(),RingRam.getbound())){
                            if(RingRam.y<=400){ //355 
                                RingRam.y=300;
                                RingRam.floor=1;
                            }
                            else{
                                RingRam.y-=10;
                            }
                        }
                        else if(Intersect(stair3.getbound(),RingRam.getbound())){
                            if(RingRam.y<=315){
                                RingRam.y=310;
                                RingRam.floor=2;
                            }
                            else{
                                RingRam.y-=10;
                            }
                        }
                    }
                    else if(RingRam.floor==1){
                        if(Intersect(stair2.getbound(),RingRam.getbound())){
                            if(RingRam.y<=135){
                                RingRam.y = 130;
                                RingRam.floor=3;
                            }
                            else{
                                RingRam.y-=10;
                            }
                        }
                    }
                }
                else if(a==KeyEvent.VK_DOWN){
                    if(RingRam.floor==1){
                        if(Intersect(stair1.getbound(),RingRam.getbound())){
                            if(RingRam.y>=565){
                                RingRam.y=565;
                                RingRam.floor=0;
                            }
                            else{
                                RingRam.y+=10;
                            }
                        }
                    }
                    else if(RingRam.floor==3){
                        if(Intersect(stair2.getbound(),RingRam.getbound())){
                            if(RingRam.y>=355){
                                RingRam.y=355;
                                RingRam.floor=1;
                            }
                            else{
                                RingRam.y+=10;
                            }
                        }
                    }
                    else if(RingRam.floor==2){
                        if(Intersect(stair3.getbound(),RingRam.getbound())){
                            if(RingRam.y>=565){
                                RingRam.y=565;
                                RingRam.floor=0;
                            }
                            else{
                                RingRam.y+=10;
                            }
                        }
                    }
                }      
            }
              
            public void keyReleased(KeyEvent e){
                RingRam.count=0;
            }
        });
    }
    
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timercount){
                times--;
            }
            
            repaint();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {       
        repaint();
    }   //ขนาดภาพที่แสดง
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
        g.drawImage(stone.getImage(), 0, 425, 350, 45, this);
        g.drawImage(stone.getImage(), 900, 380, 350, 45, this);
        g.drawImage(stone2.getImage(), 0, 240, 700, 45, this);
        g.drawImage(stair1.stair.getImage(), stair1.x-150 , stair1.y+65, 80, 300, this); //80 - 215
        g.drawImage(stair2.stair.getImage(), stair2.x, stair2.y, 80, 240, this);
        g.drawImage(stair3.stair.getImage(), stair3.x, stair3.y, 80, 260, this);
       // g.drawImage(water.getImage(), 20 , 200 , 1100, 460, this);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Fixedsys Regular",Font.HANGING_BASELINE,30));
        g.drawString("Score : "+ RingRam.score,900, 60);
         
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
   
        
       if(checklever==1){ //คันโยก
            g.drawImage(lever.leverb.getImage(), lever.x, lever.y+40, 40, 45, this); //40-45
            g.drawImage(door.dooropen.getImage(), door.x+2, door.y, 82, 80, this);
        }
        else if(checklever==0){
            g.drawImage(lever.lever.getImage(), lever.x, lever.y+40, 40, 45, this);           
            g.drawImage(door.doorclose.getImage(), door.x, door.y, 86, 80, this);
        }
        
        
        if(checkbacktofront==0){           
            if(RingRam.count==0){
                if(checkattack == 1){
                    g.drawImage(RingRam.Htkf.getImage(), RingRam.x, RingRam.y, 120,120, this);
                    g.drawString("Hanuman : "+RingRam.hp, RingRam.x, RingRam.y-15);
                    checkattack = 0;
                   
                        if(SH.hp==0){
                            SH.alive = false;
                            RingRam.score+=100;
                            if(RingRam.score==100){
                                RingRam.score=100;
                            }
                        }
                }
                else { //Hanuman
                    g.drawImage(RingRam.Hw.getImage(), RingRam.x, RingRam.y, 120,120, this);
                    g.drawString("Hanuman : "+RingRam.hp, RingRam.x, RingRam.y-15);
                }            
            }
            else {
                g.drawImage(RingRam.Hwk.getImage(), RingRam.x, RingRam.y, 120,120, this);
                g.drawString("Hanuman : "+RingRam.hp, RingRam.x, RingRam.y-15);
            }
            
        }
        else if(checkbacktofront==1){
            if(RingRam.count==0){
                if(checkattack == 1){                           //x-41                
                    g.drawImage(RingRam.Htkb .getImage(), RingRam.x-41, RingRam.y, 120,120, this);
                    g.drawString("Hanuman : "+RingRam.hp, RingRam.x, RingRam.y-15);
                    checkattack = 0;
                        if(SH.hp==0){
                            SH.alive = false; 
                            RingRam.score+=100;
                            if(RingRam.score==100){
                                RingRam.score=100;
                            }
                        }        
                }
                else {
                    g.drawImage(RingRam.Hwb.getImage(), RingRam.x, RingRam.y, 120,120, this);
                    g.drawString("Hanuman : "+RingRam.hp, RingRam.x, RingRam.y-15);
                }         
            }
            else{
                g.drawImage(RingRam.Hwbk.getImage(), RingRam.x, RingRam.y, 120,120, this);
                g.drawString("Hanuman : "+RingRam.hp, RingRam.x, RingRam.y-15);
            }
        }
        else if(checkbacktofront==2){
            g.drawImage(RingRam.Hwb.getImage(), RingRam.x, RingRam.y, 120,120, this);
            g.drawString("Hanuman : "+RingRam.hp, RingRam.x, RingRam.y-15);
        }
        if(SH.count == 1){ 
            if(SH.alive == true){
               g.drawImage(SH.YakORGh.getImage(), SH.x, SH.y-90, 180,200, this); 
               g.drawString("SahatsaKuman : "+SH.hp, SH.x-10, SH.y-80); //x-10 y-15
               SH.count = 0;
               hit = true;
            }           
        }
        else { ///ยักษ์
            if(SH.alive == true){
                g.drawImage(SH.YakORG.getImage(), SH.x, SH.y-90 , 180,200, this); //ตำแหน่งยักษ์
                g.drawString("SahatsaKuman : "+SH.hp, SH.x-10, SH.y-80); //ตำแหน่ง HPM
            }
            
            
            //sj new add/////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            if(SH2.count == 1){ 
                if(SH2.alive == true){
                    g.drawImage(SH2.YakORG.getImage(), SH2.x, SH2.y , 180, 200, this); //x300-y380
                    g.drawString("Sahatsakuman : "+SH2.hp, SH2.x, SH2.y);
                    SH2.count = 0;
                    hit2 = true;
                }           
            }
        else {
            if(SH2.alive == true){
                g.drawImage(SH2.YakORG.getImage(), SH2.x, SH2.y , 180, 200, this);
                g.drawString("Sahatsakuman : "+SH2.hp, SH2.x, SH2.y);
            }
                       
        }
                                 
            ///
            
            
        }
        if(hit==true){
            RingRam.hp-=SH.damage;
            hit=false;
        }
        
        if(hit2==true){
            RingRam.hp-=SH2.damage;
            hit2=false;
        }
        // หลังจบเกม/เกมโอเวอร
        if(RingRam.hp <= 0){
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);   
            g.drawImage(died.getImage(), 100,100, 1000, 200, this);  
            setLayout(null);
            closebt.setBounds(600, 450, 500, 120);
            closebt.setBorderPainted(false);
            closebt.setBorder(null);
            closebt.setOpaque(false);
            closebt.setContentAreaFilled(false);
            add(closebt);
            
            timer.stop();
            timercount.stop();
        }
        if(nextstage == true){
            this.setLayout(null);
            g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);
            g.drawImage(day.getImage(), 450, 40, 400, 220, this);   
            
            RingRam.x = xx;
            RingRam.y = yy;
            RingRam.hp = hpp;
            RingRam.floor = floors;
            RingRam.door = doors;
            setLayout(null);
            nextstagebt.setBounds(400, 400, 460, 70);
            nextstagebt.setBorderPainted(false);
            nextstagebt.setBorder(null);
            nextstagebt.setOpaque(false);
            nextstagebt.setContentAreaFilled(false);
            add(nextstagebt);
            
            timer.stop();
            timercount.stop();
        }
        g.drawImage(water.getImage(), 20 , 200 , 1200, 470, this);
        
    } //drawscreen  
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
	return (a.intersects(b));
    }
}
                
