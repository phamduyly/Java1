import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;

public class GameManager extends JFrame implements KeyListener {
    private int canvasWidth;
    private int canvasHeight;
    private int borderLeft;
    private int borderTop;
    private BufferedImage canvas;
    private Stage stage;
    private Enemy[] enemies;
    private Player player;
    private Goal[] goals;
    private Graphics gameGraphics;
    private Graphics canvasGraphics;
    private int numEnemies;
    private int numE; //Num E - trying to record the number of Goals killed without delete the object from the screen not right
    private int numGoals;
    private int numG; // Num G - trying to record the number of Goals killed without delete the object from the screen but not rights.
    public boolean continueGame;
    public int[] goX; // Goals X array
    public int[] goY; // Goals Y array
    // For generate random every time the game start - Do this way to reduce the amount of changed code and variables
    long n = System.nanoTime();
    Random rng = new Random(n);


    public static void main(String[] args) {
// During development, you can adjust the values provided in the brackets below
// as needed. However, your code must work with different/valid combinations
// of values.
        GameManager managerObj = new GameManager(1920, 1080, 10, 10);


    }

    public GameManager(int preferredWidth, int preferredHeight, int maxEnemies, int maxGoals) {
        this.borderLeft = getInsets().left;
        this.borderTop = getInsets().top;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (screenSize.width < preferredWidth)
            this.canvasWidth = screenSize.width - getInsets().left - getInsets().right;
        else
            this.canvasWidth = preferredWidth - getInsets().left - getInsets().right;
        if (screenSize.height < preferredHeight)
            this.canvasHeight = screenSize.height - getInsets().top - getInsets().bottom;
        else
            this.canvasHeight = preferredHeight - getInsets().top - getInsets().bottom;

        setSize(this.canvasWidth, this.canvasHeight);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);

        this.canvas = new BufferedImage(this.canvasWidth, this.canvasHeight, BufferedImage.TYPE_INT_RGB);
// Create a Stage object to hold the background images
        this.stage = new Stage();
// Create a Goal object with its initial x and y coordinates

        this.numGoals = maxGoals;
        this.numG = maxGoals;
        this.goals = new Goal[numGoals];

        goX = goalsX();
        goY = goalsY();

        for (int i = 0; i < this.numGoals; i++) {
            this.goals[i] = new Goal(this, goX[i], goY[i], true);
            //turn this into the perform action - get those these and calculate thing
        }
// Create a Player object with its initial x and y coordinates
        this.player = new Player(this, this.canvasWidth - (Math.abs(rng.nextInt()) % (this.canvasWidth / 2)),
                (Math.abs(rng.nextInt()) % this.canvasHeight));
// Create the Enemy objects, each with a reference to this (GameManager) object
// and their initial x and y coordinates.
        this.numEnemies = maxEnemies;
        this.numE = maxEnemies;
        this.enemies = new Enemy[this.numEnemies];
        for (int i = 0; i < this.numEnemies; i++) {
            this.enemies[i] = new Enemy(this, Math.abs(rng.nextInt()) % (this.canvasWidth / 4),
                    Math.abs(rng.nextInt()) % this.canvasHeight);
        }
        this.gameGraphics = getGraphics();
        this.canvasGraphics = this.canvas.getGraphics();
        this.continueGame = true;
        while (this.continueGame) {
            updateCanvas();
        }
        this.stage.setGameOverBackground();
        updateCanvas();

    }

    public void updateCanvas() {
        long start = System.nanoTime();
//Player and Goals and Enemies

        this.player.performAction();

        //Keep going to kill enemies
        if (this.numGoals > 0) {
            for (int i = 0; i < this.numEnemies; i++) {
                this.enemies[i].performAction(goX, goY);
                System.out.println(i);
            }
        } else {
            endGamesE(numGoals);
        }


        //End games with player
        int s = 0;
        while (s < this.numGoals) {
            if ((Math.abs(this.goals[s].getX() - this.player.getX()) < (this.goals[s].getCurrentImage().getWidth() / 2))
                    && (Math.abs(this.goals[s].getY() - this.player.getY()) < (this.goals[s].getCurrentImage().getWidth() /
                    2))) {
                this.goals[s].die();
                this.minusGoals(numGoals);
                this.endGamesP(numGoals);
            }

            s++;
        }
        // int j = 0;

        //Enemies Kill Goals
        for (int j = 0; j < this.numEnemies; j++) {
            int k = j;
            //Lost on how to kill GoalS with EnemieS
            //Thinking of maybe this needed to checck every goals with 1 enemy and vice versa
            if ((Math.abs(this.goals[j].getX() - this.enemies[j].getX()) < (this.goals[j].getCurrentImage().getWidth() / 2))
                    && (Math.abs(this.goals[j].getY() - this.enemies[j].getY()) <
                    (this.goals[j].getCurrentImage().getWidth() / 2))) {

                this.goals[k].die();
                this.minusGoals(numGoals);
                this.endGamesE(numGoals);
            }
            //j++;
        }
        //some things here
        try {
// Draw stage
            this.canvasGraphics.drawImage(stage.getCurrentImage(), 0, 0, null);
// Draw player
            this.canvasGraphics.drawImage(player.getCurrentImage(),
                    this.player.getX() - (this.player.getCurrentImage().getWidth() / 2),
                    this.player.getY() - (this.player.getCurrentImage().getHeight() / 2), null);
// Draw enemies
            for (int i = 0; i < this.numEnemies; i++) {
                this.canvasGraphics.drawImage(this.enemies[i].getCurrentImage(),
                        this.enemies[i].getX() - (this.enemies[i].getCurrentImage().getWidth() / 2),
                        this.enemies[i].getY() - (this.enemies[i].getCurrentImage().getHeight() /
                                2), null);
            }
// Draw goal
            for (int r = 0; r < this.numGoals; r++) {
                this.canvasGraphics.drawImage(this.goals[r].getCurrentImage(),
                        this.goals[r].getX() - (this.goals[r].getCurrentImage().getWidth() / 2),
                        this.goals[r].getY() - (this.goals[r].getCurrentImage().getHeight() / 2), null);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
// Draw everything.
        this.gameGraphics.drawImage(this.canvas, this.borderLeft, this.borderTop, this);
        long end = System.nanoTime();
        this.gameGraphics.drawString("FPS: " + String.format("%2d", (int) (1000000000.0 / (end - start))),
                this.borderLeft + 50, this.borderTop + 50);

    }

    public Goal[] getGoal() {
        return this.goals;
    }

    //Self input classes
    //Generate Goal X
    public int[] goalsX() {
        int[] test = new int[numGoals];
        for (int i = 0; i < this.numGoals; i++) {
            test[i] = Math.abs(rng.nextInt()) % this.canvasWidth;
        }
        return test;
    }

    //Generate Goal Y
    public int[] goalsY() {
        int[] test1 = new int[numGoals];
        for (int i = 0; i < this.numGoals; i++) {
            test1[i] = Math.abs(rng.nextInt()) % this.canvasHeight;
        }
        return test1;

    }

    //Minus the goals when they get kille
    public int minusGoals(int t) {
        numGoals = t;
        numGoals = numGoals - 1;
        System.out.println(numGoals);
        return numGoals;

    }

    //End games with Enemies is the winner
    public void endGamesE(int t) {

        if (t == 0) {
            this.continueGame = false;
            this.stage.setGameOverBackground();
            this.player.die();
            JOptionPane.showMessageDialog(null, "Enemies have killed" + " " + numG + " and win the game");
        }

    }

    //End games with Players is the winner
    public void endGamesP(int t) {

        if (t == 0) {
            for (int i = 0; i < this.numEnemies; i++) {
                this.enemies[i].die();
            }
            this.continueGame = false;
            this.stage.setGameOverBackground();
            JOptionPane.showMessageDialog(null, "Players have killed" + " " + numE + " and win the game");
        }

    }

    //Get number of Enemies to use
    public int getNumEnemies() {
        return numEnemies;
    }

    //Get number of Goals to use in Enemies classs
    public int getNumGoals() {
        return numGoals;
    }

    public void keyPressed(KeyEvent ke) {
// Below, the setKey method is used to tell the Player object which key is
// currently pressed.
// The Player object must keep track of the pressed key and use it for
// determining the direction
// to move.
        if (ke.getKeyCode() == KeyEvent.VK_LEFT)
            this.player.setKey('L', true);
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
            this.player.setKey('R', true);
        if (ke.getKeyCode() == KeyEvent.VK_UP)
            this.player.setKey('U', true);
        if (ke.getKeyCode() == KeyEvent.VK_DOWN)
            this.player.setKey('D', true);
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE)
            this.continueGame = false;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
// Below, the setKey method is used to tell the Player object which key is
// currently released.
// The Player object must keep track of the pressed key and use it for
// determining the direction
// to move.
        if (ke.getKeyCode() == KeyEvent.VK_LEFT)
            this.player.setKey('L', false);
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
            this.player.setKey('R', false);
        if (ke.getKeyCode() == KeyEvent.VK_UP)
            this.player.setKey('U', false);
        if (ke.getKeyCode() == KeyEvent.VK_DOWN)
            this.player.setKey('D', false);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

}