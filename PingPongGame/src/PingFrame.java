import javax.swing.*;
import java.awt.*;

public class PingFrame extends JFrame {
    PingPanel pingPanel;
    PingFrame(){
        pingPanel=new PingPanel();
        this.add(pingPanel);
        this.setTitle("Ping Pong Game");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }
}
