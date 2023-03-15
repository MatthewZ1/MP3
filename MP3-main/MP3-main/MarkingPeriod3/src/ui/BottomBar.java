package ui;

import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import Main.GameStates;
import objects.Tile;
import scenes.Playing;

import static Main.GameStates.*;

public class BottomBar {
    private int x, y, width, height;
    private MyButton bMenu;
    private Playing playing;

    private ArrayList<MyButton> tileButtons = new ArrayList<MyButton>();

    public BottomBar(int x, int y, int width, int height, Playing playing) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playing = playing;

        initButtons();
    }

    private void initButtons() {
        bMenu = new MyButton("Menu", 2, 642, 100, 30);

        int w = 50;
        int h = 50;
        int xStart = 110;
        int yStart = 650;
        int xOffSet = (int) (w * 1.1);

        int i = 0;
        for (Tile tile : playing.getGame().getTileManager().tiles) {
            tileButtons.add(new MyButton(tile.getTileType(), xStart + xOffSet * i, yStart, w, h, i));
            i++;
        }
    }

    private void drawButton(Graphics g) {
        bMenu.draw(g);
        drawTileButtons(g);

    }

    private void drawTileButtons(Graphics g) {
        for (MyButton b : tileButtons) {
            g.drawImage(getButtonImg(b.getId()), b.x, b.y, b.width, b.height, null);
        }
    }

    private BufferedImage getButtonImg(int id) {
        return playing.getGame().getTileManager().getSprite(id);
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);

        drawButton(g);
    }

    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            setGameState(MENU);
        }
    }

    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMouseOver(true);
    }

    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMousePressed(true);
    }

    public void mouseReleased(int x, int y) {
        bMenu.resetBooleans();
    }
}
