package frontend;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_HEIGHT;
import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_WIDTH;

public class GUIMaker {
	
	public static final int BUTTON_OFFSET_X = 50;
	private int myWidth;
	private int myHeight;
	private double myTabWidth;
	private double myTabHeight;
	private Group myRoot;
	
	
	public GUIMaker(int w, int h){
		myWidth = w;
		myHeight = h;
		myRoot = new Group();
	}
	
	public Scene make(Stage s){
		Scene scene = new Scene(myRoot, myWidth, myHeight);
		

		TabPane tp = new TabPane();
		tp.resize(myWidth, myHeight);
		
		SLogoTab st = new SLogoTab(tp);
		tp.getTabs().add(st.createTab(tp.getTabs().size() + 1));
		
		
		//Should add a button that allows new tabs to be created
		myRoot.getChildren().add(tp);
		
//		myRoot.addEventHandler(KeyEvent.KEY_PRESSED, new ActionObjectKeyHandler(myMover));
		
		return scene;
	}
}