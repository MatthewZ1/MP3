package scenes;

import Main.Game;
import java.awt.image.BufferedImage;

//parent class for other scenes 
public class Scene {
    private Game game;
    private int animationIndex;
    private int ANIMATION_SPEED = 25;
    private int tick;
    
    public Scene(Game game){
        this.game = game;
    }
    public Game getGame(){
        return game;
    }

    public void updateTick() {
        tick++;
        if(tick >= ANIMATION_SPEED){
            tick = 0;
            animationIndex++;
            if(animationIndex >= 4){
                animationIndex = 0;
            }
        }
    }

    public int getAnimationIndex(){
        return animationIndex;
    }

    public boolean isAnimation(int spriteID){
        return getGame().getTileManager().isSpriteAnimation(spriteID);
    }

    public BufferedImage getSprite(int spriteID) {
        return getGame().getTileManager().getSprite(spriteID);
    }

    public BufferedImage getSprite(int spriteID, int animationIndex) {
        return getGame().getTileManager().getAniSprite(spriteID, animationIndex);
    }
}
