package game_engine.implementation;

import java.util.HashMap;

public class Player extends GameComponent {

    HashMap<String, PlayerComponent> playerComponents;

    /**
     * Basic constructor.
     */
    public Player(){

    }

    /**
     * Add a single component to the Player.
     * @param playerComponent the component to be added
     */
    public void addComponent(PlayerComponent playerComponent){

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

    /**
     * Returns the selected component.
     * @param componentAlias the component's name in the store
     * @return the selected component
     */
    public PlayerComponent getComponent(String componentAlias){
        return playerComponents.get(componentAlias);
    }
}
