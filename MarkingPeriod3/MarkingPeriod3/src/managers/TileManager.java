package managers;

import objects.Tile;
import java.util.*;

import helperMethod.LoadSave;

import java.awt.image.BufferedImage;

public class TileManager {
    public Tile GRASS, WATER, ROAD;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<>();
    public TileManager(){
        loadAtlas();
        createTiles();
    }
    private void createTiles() {
        int id = 0;
        tiles.add(GRASS = new Tile(getSprite(9, 0), id++, "Grass")); //0
        tiles.add(WATER = new Tile(getSprite(0, 0), id++, "Water")); //1
        tiles.add(ROAD = new Tile(getSprite(8, 0), id++, "Road")); //2
    }
    private void loadAtlas() {
        atlas = LoadSave.getSpriteAtlas();
    }
    public Tile getTile(int id){
        return tiles.get(id);
    }
    public BufferedImage getSprite(int id){
        return tiles.get(id).getSprite();
    }
    private BufferedImage getSprite(int x, int y){
        return atlas.getSubimage(x*32, y*32, 32, 32);
    }
    
}
