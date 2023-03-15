package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Main.Game;
import objects.Tile;
import scenes.Editing;
import java.awt.*;
import java.awt.image.BufferedImage;

import static Main.GameStates.*;


public class ToolBar extends Bar{
    private Editing editing;
    private MyButton bMenu, bSave;

    private Tile selectedTile;

	private Map<MyButton, ArrayList<Tile>> map = new HashMap<MyButton, ArrayList<Tile>>();
	private MyButton bGrass, bWater, bRoadS, bRoadC, bWaterC, bWaterB, bWaterI;
    // private ArrayList<MyButton> tileButtons = new ArrayList<MyButton>();

    public ToolBar(int x, int y, int width, int height, Editing editing) {
        super(x, y, width, height);
        this.editing = editing;
        initButtons();
    }

    private void initButtons() {
        bMenu = new MyButton("Menu", 2, 642, 100, 30);
        bSave = new MyButton("Save", 2, 674, 100, 30);

        int w = 50;
        int h = 50;
        int xStart = 110;
        int yStart = 650;
        int xOffset = (int) (w * 1.1f);

        int i = 0;
        bGrass = new MyButton("Grass", xStart, yStart, w, h, i++);
		bWater = new MyButton("Water", xStart + xOffset, yStart, w, h, i++);

		initMapButton(bRoadS, editing.getGame().getTileManager().getRoadsS(), xStart, yStart, xOffset, w, h, i++);
        initMapButton(bRoadC, editing.getGame().getTileManager().getRoadsC(), xStart, yStart, xOffset, w, h, i++);
		initMapButton(bWaterC, editing.getGame().getTileManager().getCorners(), xStart, yStart, xOffset, w, h, i++);
		initMapButton(bWaterB, editing.getGame().getTileManager().getBeaches(), xStart, yStart, xOffset, w, h, i++);
		initMapButton(bWaterI, editing.getGame().getTileManager().getIslands(), xStart, yStart, xOffset, w, h, i++);

    }

    private void initMapButton(MyButton b, ArrayList<Tile> list, int x, int y, int xOff, int w, int h, int id){
        b = new MyButton("", (x + (xOff * id)), y, w, h, id);
		map.put(b, list);
    }

    private void saveLevel() {
        editing.saveLevel();
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);

        drawButton(g);
    }

    private void drawButton(Graphics g) {
        bMenu.draw(g);
        bSave.draw(g);

        drawNormalButton(g, bGrass);
        drawNormalButton(g, bWater);
        drawSelectedTile(g);
        drawMapButtons(g);
    }

    private void drawNormalButton(Graphics g, MyButton b) {
        g.drawImage(getButtonImg(b.getId()), b.x, b.y, b.width, b.height, null);
    }

    private void drawMapButtons(Graphics g) {
        for(Map.Entry<MyButton, ArrayList<Tile>> entry: map.entrySet()){
            MyButton b = entry.getKey();
            BufferedImage img = entry.getValue().get(0).getSprite();

            g.drawImage(img,  b.x, b.y, b.width, b.height, null);
        }
    }

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null) {
            g.drawImage(selectedTile.getSprite(), 550, 650, 50, 50, null);
            g.setColor(Color.BLACK);
            g.drawRect(550, 650, 50, 50);
        }
    }

    // private void drawTileButtons(Graphics g) {
    //     for (MyButton b : tileButtons) {
    //         // Sprite
    //         g.drawImage(getButtonImg(b.getId()), b.x, b.y, b.width, b.height, null);

    //         // MouseOver
    //         if (b.isMouseOver()) {
    //             g.setColor(Color.WHITE);
    //         } else {
    //             g.setColor(Color.BLACK);
    //         }

    //         // Border
    //         // g.setColor(Color.BLACK);
    //         g.drawRect(b.x, b.y, b.width, b.height);

    //         // MousePressed
    //         // doesn't work
    //         g.setColor(Color.BLACK);
    //         g.drawRect(x + 1, y + 1, width - 2, height - 2);
    //         g.drawRect(x + 2, y + 2, width - 4, height - 4);
    //     }
    // }

    private BufferedImage getButtonImg(int id) {
        return editing.getGame().getTileManager().getSprite(id);
    }

    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            setGameState(MENU);
        } 
        else if(bSave.getBounds().contains(x,y)){
            saveLevel();
        }
        else 
         {
            // for (MyButton b : tileButtons) {
            //     if (b.getBounds().contains(x, y)) {
            //         selectedTile = editing.getGame().getTileManager().getTile(b.getId());
            //         editing.setSelectedTile(selectedTile);
            //         return;
            //     }
            // }
        }
    }

    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        bSave.setMouseOver(false);
        // for (MyButton b : tileButtons) {
        //     b.setMouseOver(false);
        // }
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMouseOver(true);
        else if (bSave.getBounds().contains(x,y)){
            bSave.setMouseOver(true);
        }
        else {
            // for (MyButton b : tileButtons) {
            //     if (b.getBounds().contains(x, y)) {
            //         b.setMouseOver(true);
            //         return;
            //     }
            // }
        }
    }

    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMousePressed(true);
        else if(bSave.getBounds().contains(x,y)){
            bSave.setMousePressed(true);
        }
        else {
            // for (MyButton b : tileButtons) {
            //     if (b.getBounds().contains(x, y)) {
            //         b.setMousePressed(true);
            //         return;
            //     }

            // }
        }
    }

    public void mouseReleased(int x, int y) {
        bMenu.resetBooleans();
        bSave.resetBooleans();
        // for (MyButton b : tileButtons) {
        //     b.resetBooleans();
        // }
    }
}
