/**
 * This class represents a GUIFeature that uses a drop-down menu to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import static frontend.GUIFeatureWithButton.BUTTON_WIDTH;

public abstract class GUIFeatureWithDropDown extends GUIFeature {

	protected List<String> myItems;
	
	/**
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithDropDown(double x, double y) {
		super(x, y);
		myItems = new ArrayList<String>();
	}

	/**
	 * @see frontend.GUIFeature#action()
	 */
	@Override
	public void action(){
		
	}
	
	public abstract void doDropDownClickAction(String chosen);

	/**
	 * @see frontend.GUIFeature#makeTool()
	 */
	@Override
	public Group makeTool() {
		ChoiceBox<String> cb = new ChoiceBox<String>();
		cb.setItems(FXCollections.observableArrayList(
			    myItems));
		
		Group g = new Group();
		cb.setLayoutX(myX);
		cb.setLayoutY(myY);
		cb.setMinWidth(BUTTON_WIDTH);
		cb.setMaxWidth(BUTTON_WIDTH);
		
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				
				doDropDownClickAction(myItems.get(newValue.intValue()));
				
			}
			
		});
		
		g.getChildren().add(cb);
		return g;
	}
}
