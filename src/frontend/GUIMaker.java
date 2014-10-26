package frontend;

import java.util.ResourceBundle;

import errorsAndExceptions.ErrorPopUp;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * This class makes the window that represents
 * the IDE for the SLogo language. 
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class GUIMaker {
	
	public static final ErrorPopUp EPU = new ErrorPopUp();
	public static final int BUTTON_OFFSET_X = 50;
	private int myWidth;
	private int myHeight;
	private Group myRoot;
	
	/**
	 * Constructor.
	 * 
	 * @param w The width of the window.
	 * @param h The height of the window.
	 */
	public GUIMaker(int w, int h){
		myWidth = w;
		myHeight = h;
		myRoot = new Group();
	
	}
	
	/**
	 * Creates the TabPane that represents different workspaces
	 * and adds the updated scene to the stage.
	 * 
	 * @param s The stage of the program.
	 * @return The corresponding scene.
	 */
	public Scene make(Stage s){
		Scene scene = new Scene(myRoot, myWidth, myHeight);
		
		TabPane tp = new TabPane();
		tp.resize(myWidth, myHeight);
		
		SLogoWorkspace st = new SLogoWorkspace(tp);
		tp.getTabs().add(st.createWorkspace(tp.getTabs().size() + 1));

		myRoot.getChildren().add(tp);
		
		return scene;
	}
}