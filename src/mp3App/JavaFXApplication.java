package mp3App;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class JavaFXApplication extends javafx.application.Application{



    public void init(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Application.launch();

    }

    MediaPlayer mediaPlayer;
    public void play(){
        String dejavu = "src\\mp3\\dejaVu.mp3";
        Media hit = new Media(new File(dejavu).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        System.out.println(mediaPlayer);
        mediaPlayer.play();
    }
}
