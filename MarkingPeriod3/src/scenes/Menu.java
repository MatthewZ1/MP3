package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import Main.Game;
import Main.GamePanel;
import ui.MyButton;
import static Main.GameStates.*;

public class Menu extends Scene implements SceneMethods{
    private MyButton bPlaying, bEdit, bSettings, bQuit;

    public Menu(Game game){
        super(game);
        initButtons();
    }

    private void initButtons() {
        int w = 150;
		int h = w / 3;
		int x = 640 / 2 - w / 2;
		int y = 150;
		int yOffset = 100;

		bPlaying = new MyButton("Play", x, y, w, h);
        bEdit = new MyButton("Edit", x, y + yOffset, w, h);
		bSettings = new MyButton("Settings", x, y + yOffset * 2, w, h);
		bQuit = new MyButton("Quit", x, y + yOffset * 3, w, h);

    }

    @Override
    public void render(Graphics g) {
        // for (int y = 0; y < 20; y++) {
        //     for (int x = 0; x < 20; x++) {
        //         // put an array of sprites on the GUI
        //         g.drawImage(sprites.get(19), x * 32, y * 32, null);
        //     }
        // }

        drawButton(g);
    }
    private void drawButton(Graphics g){
        bPlaying.draw(g);
        bEdit.draw(g);
        bSettings.draw(g);
        bQuit.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bPlaying.getBounds().contains(x, y))
			setGameState(PLAYING);
		else if (bEdit.getBounds().contains(x, y))
		 	setGameState(EDIT);
		else if (bSettings.getBounds().contains(x, y))
			setGameState(SETTINGS);
		else if (bQuit.getBounds().contains(x, y))
			System.exit(0);
    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlaying.setMouseOver(false);
		bEdit.setMouseOver(false);
		bSettings.setMouseOver(false);
		bQuit.setMouseOver(false);

		if (bPlaying.getBounds().contains(x, y))
			bPlaying.setMouseOver(true);
		else if (bEdit.getBounds().contains(x, y))
			bEdit.setMouseOver(true);
		else if (bSettings.getBounds().contains(x, y))
			bSettings.setMouseOver(true);
		else if (bQuit.getBounds().contains(x, y))
			bQuit.setMouseOver(true);

    }

    @Override
    public void mousePressed(int x, int y) {
        if (bPlaying.getBounds().contains(x, y))
			bPlaying.setMousePressed(true);
		else if (bEdit.getBounds().contains(x, y))
		 	bEdit.setMousePressed(true);
		else if (bSettings.getBounds().contains(x, y))
			bSettings.setMousePressed(true);
		else if (bQuit.getBounds().contains(x, y))
			bQuit.setMousePressed(true);

    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bPlaying.resetBooleans();
		bEdit.resetBooleans();
		bSettings.resetBooleans();
		bQuit.resetBooleans();
    }

    public void mouseDragged(int x, int y) {
    }
}
