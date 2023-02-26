package helperMethod;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadSave {
    public static BufferedImage getSpriteAtlas(){
        BufferedImage img = null;
        File is = new File("./src/res/sprite.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
    
}
