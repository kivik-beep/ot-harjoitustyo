package spaceinvaders.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spaceinvaders.domain.Game;

/**
 *
 * @author kxkivi
 */
public class Spaceinvaders extends Application {
//initial setup

    private Play play;
    private Start start;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("! ! Space invaders ! !");
        this.play = new Play();
        Scene playScene = play.getScene();
        this.start = new Start(playScene, play, stage);
        Scene startScene = start.getScene();

        stage.setScene(startScene);
        stage.show();
    }

}
