package app;

import game_engine.implementation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui_config.fxml"));
        primaryStage.setTitle("RL Workbench");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {

        Game g = new Game();
        g.addComponent(new Player());
        g.addComponent(new Player());
        g.addComponent(new Player());
        g.addComponent(new BasicCardDeck());

        BasicCardDeck deck = (BasicCardDeck) g.getComponents("BasicCardDeck").getFirst();
        deck.shuffle();
        Player p1 = (Player) g.getComponents("Player").getFirst();
        p1.addComponent(new Hand(10));

        Hand h = (Hand) p1.getComponents("Hand").getFirst();
        for(int i = 0; i < 100; i++){
            h.drawFrom(deck);
        }

        for (Card c : h.getCards()){
            System.out.println(c.toString());
        }

        System.out.println(deck.size());
    }
}
