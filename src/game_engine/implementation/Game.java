package game_engine.implementation;

import java.util.HashMap;

public class Game {

    HashMap<String, GameComponent> gameComponents;

    public Game(){

    }

    public void addComponent(GameComponent gameComponent){

    }

    public void removeComponent(GameComponent gameComponent){

    }

    public void addComponents(GameComponent...gameComponents){
        for(GameComponent gc : gameComponents){
            this.addComponent(gc);
        }
    }
}
