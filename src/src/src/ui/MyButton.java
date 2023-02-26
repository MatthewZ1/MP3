package ui;
import java.awt.Color;
import java.awt.Graphics;

import javafx.scene.shape.Rectangle;

public class MyButton {
    private int x, y, width, height;
    private String txt;
    private boolean mouseOver, mousePressed;

    private Rectangle bounds;

    public MyButton(String txt, int x, int y, int width, int height){
        this.txt = txt;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        initBounds();
    }
    public void setMousePressed(boolean mousePressed){
        this.mousePressed = mousePressed;
    }

    private void initBounds(){
        this.bounds = new Rectangle(x, y, width, height);
    }
    public void draw(Graphics g){
        //body
        drawBody(g);

        //border
        drawBorder(g);
        
        //txt
        drawText(g);
    }
    private void drawBorder(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        if(mousePressed){
            g.drawRect(x + 1, y + 1, width - 2, height - 2);
            g.drawRect(x + 2, y + 2, width - 4, height - 4);
        }
    }

    private void drawBody(Graphics g) {
        if(mouseOver){
            g.setColor(Color.gray);
        }
        else{
            g.setColor(Color.WHITE);
        }
        g.fillRect(x, y, width, height);
    }

    private void drawText(Graphics g) {
        int w = g.getFontMetrics().stringWidth(txt);
        int h = g.getFontMetrics().getHeight();
        
        g.drawString(txt, x - w/2 + width/2, y + h/2 + height/2 - 4);
    }
    public void setMouseOver(boolean mouseOver){
        this.mouseOver = mouseOver;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void resetBooleans(){
        this.mouseOver = false;
        this.mousePressed = false;
    }
}
