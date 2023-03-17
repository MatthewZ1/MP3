package enemies;
import java.awt.Rectangle;
import static helperMethod.Constants.Direction.*;

public abstract class Enemy {
    private float x, y;
    private Rectangle bounds;
    private int health, ID, enemyType;
    private int lastDir;

    public Enemy(float x, float y, int ID, int enemyType){
        this.x = x;
        this.y = y;
        this.ID = ID;
        this.enemyType = enemyType;
        bounds = new Rectangle((int) x, (int) y, 32, 32);
        //lastDir = RIGHT;
        lastDir = -1;
        //use -1 to check where the mobs spawn 
    }

    public void move(float speed, int dir){
        lastDir = dir;
        switch(dir){
        case LEFT:
            this.x -= speed;
            break;
        case UP:
        this.y -= speed;
            break;
        case RIGHT:
            this.x += speed;
            break;
        case DOWN:
            this.y += speed;
            break;
        }
    }

    public void setPos(int x, int y){
        //dont use for move only for position fix
        this.x = x;
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public int getHealth(){
        return health;
    }

    public int getID(){
        return ID;
    }

    public int getEnemyType(){
        return enemyType;
    }

    public int getLastDir(){
        return lastDir;
    }
    
}
