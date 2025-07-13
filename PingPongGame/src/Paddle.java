import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Paddle extends Rectangle {
int idPlayer;
int yVelocity;




    Paddle(int x, int y, int width, int height, int idPlayer) {
        super(x, y, width, height);
        this.idPlayer = idPlayer;

    }
    public void keyPressed(KeyEvent e) {
        switch (idPlayer) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    setYDirection(-10);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(10);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-10);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(10);
                    move();
                }
                break;
        }

    }
    public void keyReleased(KeyEvent e) {
        switch (idPlayer) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
                break;
        }


    }
    public void setYDirection(int yDirection) {
        this.yVelocity = yDirection;

    }
    public void move(){
        y += yVelocity;

    }
    public void draw(Graphics g) {
        if(idPlayer==1){
            g.setColor(Color.red);
        }
        else if(idPlayer==2){
            g.setColor(Color.blue);
        }
        g.fillOval(x,y,width,height);

    }
}
