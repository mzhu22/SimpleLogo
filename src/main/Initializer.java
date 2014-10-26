package main;

import static frontend.SLogoWorkspace.GUI_NAMES;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import frontend.GUIMaker;

/**
 * The class that sets up the stage, initializes
 * the first scene and animation/frame details, and
 * runs the program as an Application.
 *
 * @author Chris Bernt
 * @author Safkat Islam
 */
public class Initializer extends Application {
    private GUIMaker myMaker;
    private int guiWidth = 1000;
    private int guiHeight = 650;

    /**
     * Set stage and scene up at the beginning.
     * 
     * @param s Stage to add the scene to.
     */
    @Override
    public void start (Stage s) {

        s.setTitle(GUI_NAMES.getString("Title"));
        
        myMaker = new GUIMaker(guiWidth, guiHeight);
        
        Scene scene = myMaker.make(s);
        scene.setFill(Color.LIGHTGRAY);
        s.setScene(scene);
        s.show();
        
        
    }

    /**
     * Begins the simulation. Called in Main.java.
     * 
     * @param args Input from command line if run from a terminal.
     */
    public void begin(String[] args) {
        launch(args);
    }
}