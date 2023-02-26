package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

import inputs.WorkKeyListener;
import inputs.WorkMouseListener;

public class GamePanel extends JPanel {
    
    private Game game;
    private WorkMouseListener mouseListener;
	private WorkKeyListener keyListener;
    
    public GamePanel(Game game) {
        this.game = game;

   
    }
    public void initInputs(){
		mouseListener = new WorkMouseListener(game);
		keyListener = new WorkKeyListener();

		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		addKeyListener(keyListener);

		requestFocus();
	}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);        

        game.getRender().render(g);
    }

}
