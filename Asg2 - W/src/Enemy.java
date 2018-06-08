import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;



public class Enemy {
    private BufferedImage imageRunning;
    private BufferedImage imageOver;
    private BufferedImage imageCurrent;
    private int radius = 100; // radius is like padding b.c it is around the image. // Basically no radius is fine
    private int x;
    private int y;
    private GameManager m1;
    private int maxHeight;
    private int maxWidth;
    public int velX;
    public int velY;
    public int k; //K for matching the index from for loop to find the right shortest Y based on the shortest X detected by the fucntion under.
    private int numG; //Number of Goals to use


    public Enemy(GameManager m, int x1, int y1) {
        x = x1;
        y = y1;
        m1 = m;
        numG = m1.getNumGoals();

        //get heigth and getwidth
        maxHeight = m.getHeight();
        maxWidth = m.getWidth();

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

    //Get Min value function - used to determine the shortest rage to the enemies - works
    public int getMinValue(int[] numbers) {
        int minValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        return minValue;
    }

    //Calculate distance to X for each
    //TodO: Right Distance calculation from enemies to nearEST goals
    public int[] DisX(int[] goalX) {
        int[] des1X = new int[numG];
        for (int i = 0; i < numG; i++) {
            des1X[i] = goalX[i] - this.x;
            k = i;
        }

        //Need to returs des Y here ( pick Y from goalY[] with the same exact index
        return des1X;
    }

    //Todo: Return the Distance to neart Goals objecct based on X
    public int DisY(int[] goalY) {
        int des1Y = goalY[k] - this.y;
        return des1Y;
    }

    //Function to change the dividen number based on the distance to provide the best fitted velocity
    public int divX(int t) {
        int divX=0;
        if (t > 100){
            divX = 100;
        } else if (t > 10 && t < 100) {
            divX = 10;
        } else if (t < 10) {
            divX = 1;
        }

        return divX;
    }


    //Perform action
    public void performAction(int[] goalX, int[]goalY) {
        //Step that I think it should be
        /*
        Step1: taking X and Y of all goal - only take goal that have goalState = true;
        Step2: calculate shortest distance by calculate the crossover between distance to Goal X and goal Y
        Step3: from shortest distance , return road to goal X and Y
        Step4: calculate speed from road to choosen goal X and Y
        Step5: kill the goals
        */

        //Declare new int disX and Y instead fo plugin into the velocity calculation for clear and debugging pupose.
        int disX = Math.abs(this.getMinValue(DisX(goalX))); // shortest distance to X - This is to hanlde negative number however it is not really fit the purpose.s
        int disY = Math.abs(DisY(goalY)); // shortest distance to Y

        try {
            velX = (disX / divX(disX));
            velY = (disY / divX(disY));
            //Handel case the distance is a negative number andd make the whole code run wrongly - so in that case, velocity will be both 4.
            //
        } catch (Exception e) {

            System.out.println(e);
        }


        //For debug purpose
        System.out.println(Arrays.toString(goalX) + "" + Arrays.toString(goalY));
        System.out.println("X "+x+";Y "+y);
        System.out.println("disX " + disX+";disY " + disY);
        System.out.println("divX "+divX(disX)+";divY "+divX(disY));
        System.out.println("velX "+velX+";velY "+velY);

        //Main moving function
        x += velX;
        y += velY;

        //Bounce back if the objects reach the horizontal
        if (x - radius < 0 ) {
            velX = -velX; //reflect along nor
            x = radius;// reposition
        } else if (x + radius >  maxWidth) {
            velX = -velX;
            x = maxWidth - radius;
        }

        /* may cross both x and Y bounds */
        if (y - radius < 0){
            velY = -velY;
            y = radius;
        } else if (y+radius > maxHeight){
            velY = -velY;
            y = maxHeight-radius;
        }
    }
}


