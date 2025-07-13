import java.awt.*;

public class Score extends Rectangle {
    static  int height;
    static  int width;
    int player1;
    int player2;
    Score(int height, int width) {
        Score.height = height;
        Score.width = width;

    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 60));
g.drawLine(width/2, 0, width/2, height);
g.drawString(String.valueOf(player1), (width/2)-85, 50);
g.drawString(String.valueOf(player2), (width/2)+20, 50);


    }
}
