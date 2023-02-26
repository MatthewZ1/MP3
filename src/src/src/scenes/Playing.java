package scenes;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import Main.GamePanel;
import helperMethod.LevelBuilder;
import managers.TileManager;

public class Playing extends GamePanel implements SceneMethods{
    private int[][] lvl;
    private TileManager tileManager;
    public Playing(Game game) {
        super(game);
        //TODO Auto-generated constructor stub

        lvl = LevelBuilder.getLevelData();
        tileManager = new TileManager();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, 640, 640);
        for(int y = 0; y < lvl.length; y++){
            for(int x = 0; x < lvl[y].length; x++){
                int id = lvl[y][x];
                g.drawImage(tileManager.getSprite(id), x*32, y*32, null);
            }
        }
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
