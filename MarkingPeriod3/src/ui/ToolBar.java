package ui;

import java.util.ArrayList;

import objects.Tile;
import scenes.Editing;
import java.awt.*;
import java.awt.image.BufferedImage;

import static Main.GameStates.*;


public class ToolBar extends Bar{
    private Editing editing;
    private MyButton bMenu, bSave;

    private Tile selectedTile;

    private ArrayList<MyButton> tileButtons = new ArrayList<MyButton>();

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
        int xOffSet = (int) (w * 1.1);

        int i = 0;
        for (Tile tile : editing.getGame().getTileManager().tiles) {
            tileButtons.add(new MyButton(tile.getName(), xStart + xOffSet * i, yStart, w, h, i));
            i++;
        }
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
        drawTileButtons(g);
        drawSelectedTile(g);

    }

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null) {
            g.drawImage(selectedTile.getSprite(), 550, 650, 50, 50, null);
            g.setColor(Color.BLACK);
            g.drawRect(550, 650, 50, 50);
        }
    }

    private void drawTileButtons(Graphics g) {
        for (MyButton b : tileButtons) {
            // Sprite
            g.drawImage(getButtonImg(b.getId()), b.x, b.y, b.width, b.height, null);

            // MouseOver
            if (b.isMouseOver()) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }

            // Border
            // g.setColor(Color.BLACK);
            g.drawRect(b.x, b.y, b.width, b.height);

            // MousePressed
            // doesn't work
            g.setColor(Color.BLACK);
            g.drawRect(x + 1, y + 1, width - 2, height - 2);
            g.drawRect(x + 2, y + 2, width - 4, height - 4);
        }
    }

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
            for (MyButton b : tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    selectedTile = editing.getGame().getTileManager().getTile(b.getId());
                    editing.setSelectedTile(selectedTile);
                    return;
                }
            }
        }
    }

    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        bSave.setMouseOver(false);
        for (MyButton b : tileButtons) {
            b.setMouseOver(false);
        }
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMouseOver(true);
        else if (bSave.getBounds().contains(x,y)){
            bSave.setMouseOver(true);
        }
        else {
            for (MyButton b : tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    b.setMouseOver(true);
                    return;
                }
            }
        }
    }

    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMousePressed(true);
        else if(bSave.getBounds().contains(x,y)){
            bSave.setMousePressed(true);
        }
        else {
            for (MyButton b : tileButtons) {
                if (b.getBounds().contains(x, y)) {
                    b.setMousePressed(true);
                    return;
                }

            }
        }
    }

    public void mouseReleased(int x, int y) {
        bMenu.resetBooleans();
        bSave.resetBooleans();
        for (MyButton b : tileButtons) {
            b.resetBooleans();
        }
    }
}
