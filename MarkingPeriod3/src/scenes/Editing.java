package scenes;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.event.AncestorEvent;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.awt.image.BufferedImage;
import Main.Game;
import Main.GamePanel;
import helperMethod.LoadSave;
import managers.TileManager;
import objects.Tile;
import ui.ToolBar;
import java.awt.event.KeyEvent;

public class Editing extends Scene implements SceneMethods{
    private int[][] lvl;
    private Tile selectedTile;
    private int mouseX, mouseY;
    private boolean drawSelect;
    private int lastTileX, lastTileY, lastTileId;
    private ToolBar toolBar;
    private int animationIndex;
    private int tick;
    private int ANIMATION_SPEED = 25;

    public Editing(Game game) {
        super(game);
        System.out.println(game);
        loadDefaultLevel();
        toolBar = new ToolBar(0, 640, 640, 100, this);
        
    }

    public void drawLevel(Graphics g){
        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x];
                if(isAnimation(id)){
                    g.drawImage(getSprite(id, animationIndex), x * 32, y * 32, null);
                }
                else{
                    g.drawImage(getSprite(id), x * 32, y * 32, null);
                }
            }
        }
    }

    private boolean isAnimation(int spriteID){
        return getGame().getTileManager().isSpriteAnimation(spriteID);
    }

    private BufferedImage getSprite(int spriteID) {
        return getGame().getTileManager().getSprite(spriteID);
    }

    private BufferedImage getSprite(int spriteID, int animationIndex) {
        return getGame().getTileManager().getAniSprite(spriteID, animationIndex);
    }

    private void loadDefaultLevel() {
        lvl = LoadSave.getLevelData("new level");
        //lvl = LevelBuilder.getLevelData();
    }

    @Override
    public void render(Graphics g) {
        updateTick();
        drawLevel(g);
        toolBar.draw(g);
        drawSelectedTile(g);

    }

    private void updateTick() {
        tick++;
        if(tick >= ANIMATION_SPEED){
            tick = 0;
            animationIndex++;
            if(animationIndex >= 4){
                animationIndex = 0;
            }
        }
    }

    public void saveLevel(){
        LoadSave.saveLevel("new level", lvl);
        getGame().getPlaying().setLevel(lvl); 
    }

    private void drawSelectedTile(Graphics g) {
        if(selectedTile != null && drawSelect){
            g.drawImage(selectedTile.getSprite(), mouseX, mouseY, 32, 32, null);
        }
    }

    public void setSelectedTile(Tile tile){
        this.selectedTile = tile;
        drawSelect = true;
    }

    private void changeTile(int x, int y) {
        if(selectedTile != null){
            int tileX = x/32;
            int tileY = y/32;

            if(lastTileX == tileX && lastTileY == tileY && lastTileId == selectedTile.getId()){
                return;
            }

            lastTileX = tileX;
            lastTileY = tileY;
            lastTileId = selectedTile.getId();
            lvl[tileY][tileX] = selectedTile.getId();
        }  
    }

    @Override
    public void mouseClicked(int x, int y) {
        if(y >= 640){
            toolBar.mouseClicked(x, y);
        }
        else{
            changeTile(mouseX, mouseY);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if(y >= 640){
            toolBar.mouseMoved(x, y);
            drawSelect = false;
        }
        else{
            drawSelect = true;
            mouseX = (x/32) * 32;
            mouseY = (y/32) * 32;
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if(y>= 640){
            toolBar.mousePressed(x,y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        toolBar.mouseReleased(x,y);
    }

    public void mouseDragged(int x, int y) {
        if(y >= 640){

        }
        else{
            changeTile(x, y);
        }
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_R){
            toolBar.rotateSprite();
        }
    }
    
}
