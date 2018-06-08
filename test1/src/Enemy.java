import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//x,y are place that they are

public class Enemy {
    private BufferedImage imageRunning;
    private BufferedImage imageOver;
    private BufferedImage imageCurrent;
    private int x;
    private int y;
    private int velX = 3;
    private int velY = 3;
    private GameManager m1;



    //x, y of goal
    private int goalX;
    private int goalY;

    public Enemy(GameManager m, int x1, int y1) {
        x = x1;
        y = y1;
        m1 = m;

        //Need to obtain from GameManage: 1. width, 2.height, 3.position of goals. the enemies need to move toward the gaols

        try {
            this.imageRunning = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/test1/src/enemy-alive.png"));
            this.imageOver = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/test1/src/enemy-dead.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.imageCurrent = this.imageRunning;
    }

    //Current image - Enemy alive
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

    public void performAction() {
        goalY = m1.getGoal().getY();

        goalX = m1.getGoal().getX();


        velX = ((goalX - x +100)/100);
        velY = ((goalY - y+100)/100);

       x += velX;
       y += velY;


    }
}
