import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;


public class Player {
	private BufferedImage imageRunning;
    private BufferedImage imageOver;
    private BufferedImage imageCurrent;
    private int x;
    private int y;
    private int velX; //Faster than enemy
    private int velY; //Faster than enemy
    private int maxWidth;
    private int maxHeight;


    Random rand = new Random();
    int  n = rand.nextInt(50) + 1;
    int speed = 30;

    public Player(GameManager m1, int x1, int y1) {
    x = x1;
    y = y1;

    maxHeight = m1.getHeight();
    maxWidth = m1.getWidth();
        try
        {
            this.imageRunning = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/Asg2 - W/bin/player-alive.png"));
            this.imageOver = ImageIO.read(new File("C:/Users/DELL/Desktop/itp_workspace/Asg2 - W/bin/player-dead.png"));

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
        int radius = 10;

        //Stop if Player reach the boundaries

        if (x - radius < 0 ) {
            velX = 0; //reflect along nor
            x = radius;// reposition
        } else if (x + radius >  maxWidth) {
            velX = 0;
            x = maxWidth - radius;
        }

        /* may cross both x and Y bounds */
        if (y - radius < 0){
            velY = 0;
            y = radius;
        } else if (y+radius > maxHeight){
            velY = 0;
            y = maxHeight-radius;
        }

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


        if (a == 'L' && state1 == true) {
            velX = -speed;

        } else if (a == 'R' && state1 == true) {
            velX = speed;
            // System.out.println("pressed");
        } else if (a == 'U' && state1 == true) {
            velY = -speed;
            //System.out.println("pressed");
        } else if (a == 'D' && state1 == true) {
            velY = speed;
            //System.out.println("pressed");
        }

        if (a == 'L' && state1 == false) {
            velX = 0;

        } else if (a == 'R' && state1 == false) {
            velX = -0;
            //System.out.println("pressed");
        } else if (a == 'U' && state1 == false) {
            velY = 0;
            //System.out.println("pressed");
        } else if (a == 'D' && state1 == false) {
            velY = -0;
            ///System.out.println("pressed");
        }
    }
}
