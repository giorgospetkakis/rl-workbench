package game_engine.implementation;

import java.util.HashMap;
import java.util.LinkedList;

public class Player extends GameComponent {

    HashMap<String, LinkedList<PlayerComponent>> playerComponents;

    /**
     * Basic constructor.
     */
    public Player(){
        this.type = "Player";
        playerComponents = new HashMap<>();
    }

    /**
     * Add a single component to the Player.
     * @param playerComponent the component to be added
     */
    public void addComponent(PlayerComponent playerComponent){
        if(!playerComponents.containsKey(playerComponent.type)) {
            LinkedList<PlayerComponent> list = new LinkedList<>();
            list.add(playerComponent);
            this.playerComponents.put(playerComponent.type, list);
        } else {
            playerComponents.get(playerComponent.type).add(playerComponent);
        }
    }

    /**
     * Add components to the player.
     * @param playerComponents the components to be added
     */
    public void addComponents(PlayerComponent...playerComponents){
        for(PlayerComponent pc : playerComponents){
            this.addComponent(pc);
        }
    }

    public void removeComponent(PlayerComponent playerComponent){
        LinkedList<PlayerComponent> list = playerComponents.get(playerComponent.type);
        for(PlayerComponent element : list){
            if(element.equals(playerComponent)){
                list.remove(element);
            }
        }
    }

    /**
     * Returns all components of the selected type.
     * @param type the component's type
     * @return all components of the selected type.
     */
    public LinkedList<PlayerComponent> getComponents(String type){
        return playerComponents.get(type);
    }
}
