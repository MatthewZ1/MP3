package objects;
import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage[] sprite;
    private int id;
    private String tileType;

    public Tile(BufferedImage sprite, int id, String tileType){
        this.sprite = new BufferedImage[1];
		this.sprite[0] = sprite;        
        this.id = id;
        // this.tileType = tileType;
    }

    public Tile(BufferedImage[] sprite, int id, String tileType) {
		this.sprite = sprite;
		this.id = id;
		// this.tileType = tileType;
	}

    public BufferedImage getSprite(int animationIndex) {
		return sprite[animationIndex];
	}

    public BufferedImage getSprite() {
		return sprite[0];
	}

    public int getId(){
        return id;
    }

    public String getTileType(){
        return tileType;
    }
}
