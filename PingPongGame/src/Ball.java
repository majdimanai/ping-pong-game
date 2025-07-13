import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle {
    Random random;
    int xVelocity, yVelocity;

    Ball(int x,int y,int width,int height){
        super(x,y,width,height);
        random = new Random();
    int randomXdirection= random.nextInt(2);
    if(randomXdirection==0){
        randomXdirection--;

    }setXdirection(randomXdirection*2);

        int randomYdirection= random.nextInt(2);
        if(randomYdirection==0){
            randomYdirection--;

        }setYdirection(randomYdirection*2);


    }
    public void setXdirection(int xDirection){
        xVelocity=xDirection;

    }
    public void setYdirection(int yDirection){
        yVelocity=yDirection;

    }
    public void move(){
        x+=xVelocity;
        y+=yVelocity;

    }
    public void draw(Graphics g){
    g.setColor(Color.white);
    g.fillOval(x,y,width,height);
    }
}
