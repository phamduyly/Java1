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
   
    // x width and y - height is canvas height and width
    public Goal(int x1, int y1) {
        x = x1;
        y = y1;
    	try
        {
            this.imageRunning = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/test1/src/goal-alive.png"));
            this.imageOver = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/test1/src/goal-dead.png"));

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
    }
}
