package scenes;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;
import helperMethod.LevelBuilder;
import helperMethod.LoadSave;
import managers.EnemyManager;
import ui.ActionBar;
import java.awt.image.BufferedImage;

public class Playing extends Scene implements SceneMethods {
    private int[][] lvl;
    private ActionBar actionBar;
    private int mouseX, mouseY;
    private EnemyManager enemyManager;

    public Playing(Game game) {
        super(game);

        loadDefaultLevel();
        actionBar = new ActionBar(0, 640, 640, 100, this);

        enemyManager = new EnemyManager(this);
    }

    private void loadDefaultLevel() {
        lvl = LoadSave.getLevelData("new level");
        //lvl = LevelBuilder.getLevelData();
    }

    @Override
    public void render(Graphics g) {
        drawLevel(g);
        actionBar.draw(g);
        enemyManager.draw(g);
    }

    public void drawLevel(Graphics g){
        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x];
                g.drawImage(getSprite(id), x * 32, y * 32, null);
            }
        }
    }

    public void update(){
        enemyManager.update();
    }

    private BufferedImage getSprite(int spriteID) {
        return getGame().getTileManager().getSprite(spriteID);
    }

    public void setLevel(int[][] lvl){
        this.lvl = lvl;
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (y >= 640) {
            actionBar.mouseClicked(x, y);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (y >= 640) {
            actionBar.mouseMoved(x, y);
        } else {
            mouseX = (x / 32) * 32;
            mouseY = (y / 32) * 32;
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (y >= 640) {
            actionBar.mouseMoved(x, y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        actionBar.mouseMoved(x, y);
    }

    @Override
    public void mouseDragged(int x, int y) {

    }
}
