package NaLongKa_Game;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NaLongka_Maingame extends JFrame implements ActionListener {
    StartGame sg = new StartGame();
    stage1 state1 = new stage1(); 
    stage2 stage2 = new stage2();

    
    
    public NaLongka_Maingame (){
        this.setSize(1200,700);
        this.add(sg);
                                    
        sg.requestFocusInWindow();
        sg.StartGame.addActionListener(this);
        state1.closebt.addActionListener(this);
        stage2.closebt.addActionListener(this);
        state1.nextstagebt.addActionListener(this);

        
        
    }
    public static void main(String[] args) {
        JFrame kui = new NaLongka_Maingame();
        kui.setSize(1200,700);
        kui.setVisible(true);
        kui.setTitle("NaLongKa - ณ.ลงกา");
        kui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        kui.setLocationRelativeTo(null);
        kui.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sg.StartGame){
            this.setLocationRelativeTo(null);
            this.remove(sg);
            this.setSize(1200,700);
            this.setTitle("Stage 1 - พระตำหนักสวนขวัญ");
            this.add(state1);
            state1.requestFocusInWindow();
        }
        else if(e.getSource() == state1.nextstagebt){
            this.setLocationRelativeTo(null);
            this.remove(state1);
            this.setSize(1200,700);
            this.setTitle("Stage 2 - ประตูออกเมือง");
            this.add(stage2);
            stage2.requestFocusInWindow();
        }       
  
        else if(e.getSource()==stage2.closebt){
            System.exit(0);
        }

        else if(e.getSource() == state1.closebt){
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
    
}
