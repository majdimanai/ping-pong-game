import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class PingPanel extends JPanel implements Runnable {
    static final int width = 1000;
    static final int height =(int)(width *(0.56));
    static final Dimension size = new Dimension(width,height);
    static final int ballDiametre=20;
    static final int paddleWidth=25;
    static final int paddleHeight=100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random rand;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    PingPanel() {
        newPaddle();
        newBall();
        score=new Score( height,width);
        this.setFocusable(true);
        this.addKeyListener(new Al() {});
        this.setPreferredSize(size);
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void newBall(){
        ball=new Ball((width/2) -(ballDiametre/2),(height/2) -(ballDiametre/2),ballDiametre,ballDiametre);

    }
    public void newPaddle(){
        paddle1=new Paddle(0,(height/2)-(paddleHeight/2),paddleWidth,paddleHeight,1);
        paddle2=new Paddle(width-paddleWidth,(height/2)-(paddleHeight/2),paddleWidth,paddleHeight,2);


    }
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    public void draw (Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);

    }
    public void moveBall(){
paddle1.move();
paddle2.move();
ball.move();

    }
    public void checkCollision(){
       if(ball.intersects(paddle1)){
           ball.xVelocity=Math.abs(ball.xVelocity);
           ball.xVelocity++;
           if(ball.yVelocity>0){
               ball.yVelocity++;
           }else{
               ball.yVelocity--;
           }ball.setXdirection(ball.xVelocity);
           ball.setYdirection(ball.yVelocity);
        }

       if(ball.intersects(paddle2)){
            ball.xVelocity=Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if(ball.yVelocity>0){
                ball.yVelocity++;
            }else{
                ball.yVelocity--;
            }ball.setXdirection(-ball.xVelocity);
            ball.setYdirection(ball.yVelocity);
        }



        if(ball.y<=0){
           ball.setYdirection(-ball.yVelocity);
       }
       if(ball.y>height-ballDiametre){
           ball.setYdirection(-ball.yVelocity);
       }


        if (paddle1.y<=0){
            paddle1.y=0;
        }
         if(paddle1.y>=height-paddleHeight){
            paddle1.y=height-paddleHeight;
        }
        if (paddle2.y<=0){
            paddle2.y=0;
        }
        if(paddle2.y>=height-paddleHeight){
            paddle2.y=height-paddleHeight;
        }
        if(ball.x<=0){
            score.player2++;
            newPaddle();
            newBall();
        }
        if(ball.x>=width-paddleWidth){
            score.player1++;
            newPaddle();
            newBall();

        }

    }
    public void run(){
        long lastTimes = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTimes) / ns;
            lastTimes = now;
            if(delta >= 1){
                moveBall();
                checkCollision();
                repaint();
                delta--;

            }
        }

    }
    public class Al extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);

        }
        public void keyReleased(KeyEvent e){
    paddle1.keyReleased(e);
    paddle2.keyReleased(e);
        }
    }

}
