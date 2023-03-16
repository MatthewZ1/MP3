package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Main.GameStates.*;

import Main.Game;
import Main.GameStates;

public class WorkKeyListener implements KeyListener {
    private Game game;
    public WorkKeyListener(Game game){
        this.game = game;
    }
    public void keyPressed(KeyEvent e){
        if(GameStates.gameState == EDIT){
            game.getEditor().keyPressed(e);
        }
        // if(e.getKeyCode() == KeyEvent.VK_A){
        //     System.out.println("A");
        //     GameStates.gameState = MENU;
        // }
        // else if(e.getKeyCode() == KeyEvent.VK_W){
        //     System.out.println("W");
        //     GameStates.gameState = PLAYING;
        // }
        // else if(e.getKeyCode() == KeyEvent.VK_S){
        //     System.out.println("S");
        //     GameStates.gameState = SETTINGS;
        // }
        // else if(e.getKeyCode() == KeyEvent.VK_D){
        //     System.out.println("D");
        // }
        // if (GameStates.gameState == EDIT)
		// 	g.getEditor().keyPressed(e);
		// else if (GameStates.gameState == PLAYING)
		// 	g.getPlaying().keyPressed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
