import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Goal {
	private BufferedImage imageRunning;
    private BufferedImage imageOver;
    private BufferedImage imageCurrent;
    private int x;
    private int y;
    private GameManager m1;
    private boolean goalState;

    public Goal(GameManager m, int x1, int y1, boolean gS) {
        x = x1;
        y = y1;
        m1 = m;
        goalState = gS;

        try
        {
            this.imageRunning = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/Asg2 - W/bin/goal-alive.png"));
            this.imageOver = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/Asg2 - W/bin/goal-dead.png"));

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        this.imageCurrent = this.imageRunning;
           
    }

    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    //Goal alive
    public BufferedImage getCurrentImage()
    {
        return this.imageCurrent;
    }
    
    //Goal die
    public void die()
    {
        this.imageCurrent = this.imageOver;
        //Goal die - change state of the goal.
        goalState = false;
    }
}
