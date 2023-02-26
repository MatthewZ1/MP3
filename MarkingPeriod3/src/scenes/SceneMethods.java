package scenes;

import java.awt.Graphics;

//every "method" you make here. The other classes will also get these "methods"
//if you add "publc void callJoeMama()," this will be a method in other classes
public interface SceneMethods {
    public void render(Graphics g);
    public void mouseClicked(int x, int y);
    public void mouseMoved(int x, int y);
    public void mousePressed(int x, int y);
    public void mouseReleased(int x, int y);
}