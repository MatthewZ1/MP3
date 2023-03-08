package scenes;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.text.AttributeSet.ColorAttribute;

import Main.Game;
import Main.GamePanel;
import helperMethod.LoadSave;
import managers.TileManager;
import objects.Tile;
import ui.ToolBar;

public class Editing extends Scene implements SceneMethods{
    private int[][] lvl;
    private Tile selectedTile;
    private int mouseX, mouseY;
    private boolean drawSelect;
    private int lastTileX, lastTileY, lastTileId;
    private ToolBar toolBar;

    public Editing(Game game) {
        super(game);
        toolBar = new ToolBar(0, 640, 640, 100, this);
    }

    @Override
    public void render(Graphics g) {
        toolBar.draw(g);
        drawSelectedTile(g);

    }

    public void saveLevel(){
        LoadSave.saveLevel("new level", lvl);
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
        
    }

    @Override
    public void mouseReleased(int x, int y) {

    }

    public void mouseDragged(int x, int y) {
        if(y >= 640){

        }
        else{
            changeTile(x, y);
        }
    }
    
}
