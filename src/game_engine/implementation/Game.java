package game_engine.implementation;

import java.util.HashMap;
import java.util.LinkedList;

public class Game {

    private HashMap<String, LinkedList<GameComponent>> gameComponents;
    private LinkedList<Turn> history;

    /**
     * Creates a new Game
     */
    public Game(){
        gameComponents = new HashMap<>();
        history = new LinkedList<>();
    }

    /**
     * Adds a game component to the gc hashmap
     * If a game component of the same kind exists
     * it adds it to a linked list with the rest
     * @param gameComponent the game component to be added
     */
    public void addComponent(GameComponent gameComponent){
        if(!gameComponents.containsKey(gameComponent.type)) {
            LinkedList<GameComponent> list = new LinkedList<>();
            list.add(gameComponent);
            this.gameComponents.put(gameComponent.type, list);
        } else {
            gameComponents.get(gameComponent.type).add(gameComponent);
        }
    }

    /**
     * Adds multiple components to the hashmap
     * @param gameComponents The components to be added
     */
    public void addComponents(GameComponent...gameComponents){
        for(GameComponent gc : gameComponents){
            this.addComponent(gc);
        }
    }

    /**
     * Removes a specific component from the hashmap
     * @param gameComponent the component to be removed
     */
    public void removeComponent(GameComponent gameComponent){
        LinkedList<GameComponent> list = gameComponents.get(gameComponent.type);
        for(GameComponent element : list){
            if(element.equals(gameComponent)){
                list.remove(element);
            }
        }
    }

    /**
     * Returns all elements of the selected type
     * @param type The type selected
     * @return The elements in the game of that type
     */
    public LinkedList<GameComponent> getComponents(String type){
        return gameComponents.get(type);
    }
}
