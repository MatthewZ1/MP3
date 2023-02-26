package scenes;

import Main.Game;

//parent class for other scenes 
public class Scene {
    private Game game;
    
    public Scene(Game game){

    }

    public Game getGame(){
        return game;
    }
}
