import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
//x,y are place that they are

public class Enemy {
    private BufferedImage imageRunning;
    private BufferedImage imageOver;
    private BufferedImage imageCurrent;
    //private int radius = 40; // radius is like padding b.c it is around the image.
    private int x;// = radius + 5;
    private int y;// = radius + 5;
    private int velX = 3;
    private int velY = 3;
    private GameManager m1;
    private int maxHeight;
    private int maxWidth;


    //x, y of goal
    private int goalX;
    private int goalY;

    public Enemy(GameManager m, int x1, int y1) {
        x = x1;
        y = y1;
        m1 = m;

        //get heigth and getwidth is right
        maxHeight = m.getHeight();

        maxWidth = m.getWidth();


        //Need to obtain from GameManage: 1. width, 2.height, 3.position of goals. the enemies need to move toward the gaols

        try {
            this.imageRunning = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/Asg2 - W/bin/enemy-alive.png"));
            this.imageOver = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/Asg2 - W/bin/enemy-dead.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.imageCurrent = this.imageRunning;
    }

    //Current image - Enemey alive
    public BufferedImage getCurrentImage() {
        return this.imageCurrent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Enemy die
    public void die() {
        this.imageCurrent = this.imageOver;

    }
    //todo: in class performAction moving toward the goal
// 2 ways:
    //1. declare max value
    //2. x an Y inside there range
    public void performAction() {
        goalY = m1.getGoal().getY();

        goalX = m1.getGoal().getX();


        velX = ((goalX - x +100)/100);
        velY = ((goalY - y+100)/100);

       x += velX;
       y += velY;



//       //Todo: will need to caculate this to goal x and goal y
//       //Check if it is over the place
//        if (x - radius < 0 ) {
//            velX = -velX; //reflect along nor
//            x = radius;// reposition
//        } else if (x + radius >  maxWidth) {
//            velX = -velX;
//            x = maxWidth - radius;
//        }
//
//        /* may cross both x and Y bounds */
//        if (y - radius < 0){
//            velY = -velY;
//            y = radius;
//        } else if (y+radius > maxHeight){
//            velY = -velY;
//            y = maxHeight-radius;
//        }

    }
}
