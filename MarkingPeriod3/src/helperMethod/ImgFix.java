package helperMethod;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class ImgFix {
    

    //rotate
    //when sprite comes, they are facing up, down, left, right
    //therefore, they need to have "angles" facign at 0, 90, 180, 270 deg
    public static BufferedImage getRotImg(BufferedImage img, int rotAngle){
        int w = img.getWidth();
        int h = img.getHeight();

        BufferedImage newImg = new BufferedImage(w, h, img.getType());
        Graphics2D g2d = newImg.createGraphics();

        g2d.rotate(Math.toRadians(rotAngle), w/2, h/2);
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return newImg;
    }

    //layers
    //to layer land on top of water for the "coastal" feel
    public static BufferedImage buildImg(BufferedImage[] imgs){
        int w = imgs[0].getWidth();
        int h = imgs[0].getHeight();

        BufferedImage newImg = new BufferedImage(w, h, imgs[0].getType());
        Graphics2D g2d = newImg.createGraphics();
        
        for(BufferedImage img : imgs){
            //water on bottom, land on top 
            g2d.drawImage(img, 0, 0, null);

        }
        g2d.dispose();

        return newImg;
    }
}
