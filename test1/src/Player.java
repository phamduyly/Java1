import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {
	private BufferedImage imageRunning;
    private BufferedImage imageOver;
    private BufferedImage imageCurrent;
    private int x;
    private int y;
    private int velX; //Faster than enemy
    private int velY; //Faster than enemy

    
    public Player(int x1, int y1) {
    x = x1;
    y = y1;
        try
        {
            this.imageRunning = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/test1/src/player-alive.png"));
            this.imageOver = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/test1/src/player-dead.png"));

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
    
    //Player alive
    public BufferedImage getCurrentImage()
    {
        return this.imageCurrent;
    }
    
    //Player die
    public void die()
    {
        this.imageCurrent = this.imageOver;
    }
    
    //Moving

    public void performAction()
    {
        x += velX;
        y += velY;

        setKey('L',true);
        setKey('R',true);
        setKey('U',true);
        setKey('D',true);

        setKey('L',false);
        setKey('R',false);
        setKey('U',false);
        setKey('D',false);
        //moving and reset the current imange.
    }

    public void setKey(char c, boolean state) {
       // get the keyboard button
        char a = c;
        boolean state1 = state;
        int speed =30;

        if (a == 'L' && state1 == true) {
            velX = -speed;

        } else
        if (a == 'R' && state1 == true) {
            velX = speed;
            
        } else
        if (a == 'U' && state1 == true) {
            velY = -speed;
            
        } else
        if (a == 'D' && state1 == true) {
            velY = speed;
            
        }

        if (a == 'L' && state1 == false) {
            velX = 0;

        } else
        if (a == 'R' && state1 == false) {
            velX = -0;
          
        } else
        if (a == 'U' && state1 == false) {
            velY = 0;
            
        } else
        if (a == 'D' && state1 == false) {
            velY = -0;
         
        }

    }

    
}
