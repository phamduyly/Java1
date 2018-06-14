import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;

public class GameManager extends JFrame implements KeyListener {
    private int canvasWidth;
    private int canvasHeight;
    private int borderLeft;
    private int borderTop;
    private BufferedImage canvas;
    private Stage stage;
    private Enemy[] enemies;
    private Player player;
    private Goal goal;
    private Graphics gameGraphics;
    private Graphics canvasGraphics;
    private int numEnemies;
    private boolean continueGame;

    public static void main(String[] args) {
// During development, you can adjust the values provided in the brackets below
// as needed. However, your code must work with different/valid combinations
// of values.
        GameManager managerObj = new GameManager(1920, 1280, 30);
    }

    public GameManager(int preferredWidth, int preferredHeight, int maxEnemies) {
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
        Random rng = new Random(2);
        this.canvas = new BufferedImage(this.canvasWidth, this.canvasHeight, BufferedImage.TYPE_INT_RGB);
// Create a Stage object to hold the background images
        this.stage = new Stage();
// Create a Goal object with its initial x and y coordinates
        this.goal = new Goal(this.canvasWidth / 2, Math.abs(rng.nextInt()) % this.canvasHeight);
// Create a Player object with its initial x and y coordinates
        this.player = new Player(this.canvasWidth - (Math.abs(rng.nextInt()) % (this.canvasWidth / 2)),
                (Math.abs(rng.nextInt()) % this.canvasHeight));
// Create the Enemy objects, each with a reference to this (GameManager) object
// and their initial x and y coordinates.
        this.numEnemies = maxEnemies;
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
// If the player is alive, this should move the player in the direction of the
// key that has been pressed
// Note: See keyPressed and keyReleased methods in the GameManager class.
        this.player.performAction();
// If the enemy is alive, the enemy must move towards the goal. The goal object
// is obtained
// via the GameManager object that is given at the time of creating an Enemy
// object.
// Note: The amount that the enemy moves by must be much smaller than that of
// the player above
// or else the game becomes too hard to play.
        for (int i = 0; i < this.numEnemies; i++) {
            this.enemies[i].performAction();
        }
        if ((Math.abs(this.goal.getX() - this.player.getX()) < (this.goal.getCurrentImage().getWidth() / 2))
                && (Math.abs(this.goal.getY() - this.player.getY()) < (this.goal.getCurrentImage().getWidth() /
                2))) {
            for (int i = 0; i < this.numEnemies; i++) {
// Sets the image of the enemy to the "dead" image and sets its status to
// indicate dead
                this.enemies[i].die();
            }
// Sets the image of the enemy to the "dead" image and sets its status to
// indicate dead
            this.goal.die();
// Sets the background of the stage to the finished game background.
            this.stage.setGameOverBackground();
            this.continueGame = false;
        }
// If an enemy is close to the goal, the player and goal die
        int j = 0;
        while (j < this.numEnemies) {
            if ((Math.abs(this.goal.getX() - this.enemies[j].getX()) < (this.goal.getCurrentImage().getWidth() / 2))
                    && (Math.abs(this.goal.getY() - this.enemies[j].getY()) <
                    (this.goal.getCurrentImage().getWidth() / 2))) {
                this.player.die();
                this.goal.die();
                this.stage.setGameOverBackground();
                j = this.numEnemies;
                this.continueGame = false;
            }
            j++;
        }
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
            this.canvasGraphics.drawImage(this.goal.getCurrentImage(),
                    this.goal.getX() - (this.goal.getCurrentImage().getWidth() / 2),
                    this.goal.getY() - (this.goal.getCurrentImage().getHeight() / 2), null);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
// Draw everything.
        this.gameGraphics.drawImage(this.canvas, this.borderLeft, this.borderTop, this);
        long end = System.nanoTime();
        this.gameGraphics.drawString("FPS: " + String.format("%2d", (int) (1000000000.0 / (end - start))),
                this.borderLeft + 50, this.borderTop + 50);
    }

    public Goal getGoal() {
        return this.goal;
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