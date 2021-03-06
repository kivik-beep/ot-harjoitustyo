package spaceinvaders.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Space Invaders Game.
 *
 * @version 3 - FINAL
 * @author kxkivi
 */
public class Spaceinvaders extends Application {
//initial setup

    private Play play;
    private Start start;

    /**
     * Starts the user interface.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("! ! Space invaders ! !");
        this.play = new Play(stage);

        this.start = new Start(play, stage);
        Scene startScene = start.getScene();

        stage.setScene(startScene);
        stage.show();
    }

}
