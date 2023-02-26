package Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import inputs.WorkKeyListener;
import inputs.WorkMouseListener;
import scenes.Settings;
import scenes.Menu;
import scenes.Playing;
import scenes.Editing;

public class Game extends JFrame implements Runnable{
	// they use game screen, but i wanna keep it consistent
	private GamePanel gp;

	private int updates;
	// updates per second
	private long lastTimeUPS;

	private Thread gameThread;

	private Render render;

	//classes
	private Menu menu;
	private Playing playing;
	private Settings settings;
	private Editing editing;

	private final int tileSize = 32;
	private int screenW = tileSize * 20;
	private int screenH = tileSize * 20;

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
		game.gp.initInputs();
	}

	private void start() {
		gameThread = new Thread(this) {};
		gameThread.start();
	}

	public Game() {
		initClasses();
		// creates a screen 20 tiles long and wide
		// each tile being 32 pixels long anf wide
		setSize(640, 640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initClasses();
		//set starting screen to be x by y 
		setPreferredSize(new Dimension(656, 679));
		//can't resize
		setResizable(false);
		add(gp);
		pack();		
		setVisible(true);

	}

	private void initClasses() {
		render = new Render(this);
		gp = new GamePanel(this);

		menu = new Menu(this);
		playing = new Playing(this);
		settings = new Settings(this);
		editing = new Editing(this);
	}

	private void callUPS() {
		if (System.currentTimeMillis() - lastTimeUPS >= 1000) {
			System.out.println("USP: " + updates);
			updates = 0;
			lastTimeUPS = System.currentTimeMillis();
		}
	}
	
	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / 120.0;
		double timePerUpdate = 1000000000.0 / 60.0;

		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();

		int frames = 0;
		int updates = 0;

		long lastTimeCheck = System.currentTimeMillis();

		while(true){
			if (System.nanoTime() - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = System.nanoTime();
				frames++;
			}

			if (System.nanoTime() - lastUpdate >= timePerUpdate) {
				lastUpdate = System.nanoTime();
				updates++;
			}
			//callUPS();
			if(System.currentTimeMillis() - lastTimeCheck >= 1000){
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}
		}	

	}

	//getters and setters
	public Render getRender(){
		return render;

	}
	public Menu getMenu(){
		return menu;
	}
	public Playing getPlaying(){
		return playing;
	}
	public Settings getSettings(){
		return settings;
	}
	public Editing getEditor(){
		return editing;
	}

}
// callFPS();
        
//     }

//     private void callFPS() {
//         //prints fps to ensure speed is fast enough 
//         frames++;
//         if (System.currentTimeMillis() - lastTime >= 1000) {
//             System.out.println("fps: " + frames);
//             frames = 0;
//             lastTime = System.currentTimeMillis();
//         }
//     }