package scenes;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.text.AttributeSet.ColorAttribute;

import Main.Game;
import Main.GamePanel;

public class Editing extends GamePanel implements SceneMethods{
    public Editing(Game game) {
        super(game);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0, 0, 640, 640);
    }

    @Override
    public void mouseClicked(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mouseMoved(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }

    @Override
    public void mousePressed(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseRelased'");
    }

    public void mouseDragged(int x, int y) {
    }
    
}
