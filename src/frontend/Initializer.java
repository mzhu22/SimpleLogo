package frontend;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The class that sets up the stage, initializes
 * the first scene and animation/frame details, and
 * runs the program as an Application.
 *
 * @author Chris Bernt
 */

public class Initializer extends Application {
    private GUIMaker myMaker;
    private int guiWidth = 800;
    private int guiHeight = 650;

    /**
     * Set things up at the beginning.
     */
    @Override
    public void start (Stage s) {

        s.setTitle("SLogo");
        
        myMaker = new GUIMaker(guiWidth, guiHeight);
        
        Scene scene = myMaker.make(s);
        scene.setFill(Color.LIGHTGRAY);
        s.setScene(scene);
        s.show();
        
        
    }

    /**
     * @param args
     * Begins the simulation. Called in Main.java.
     */
    public void begin(String[] args) {
        launch(args);
    }
}