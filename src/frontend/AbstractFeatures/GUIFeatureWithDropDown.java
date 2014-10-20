/**
 * This class represents a GUIFeature that uses a drop-down menu to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend.AbstractFeatures;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_WIDTH;

public abstract class GUIFeatureWithDropDown extends GUIFeature {

	protected List<String> myItems;
	protected String myPromptText;
	
	/**
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithDropDown(double x, double y, String prompt) {
		super(x, y);
		myPromptText = prompt;
		myItems = new ArrayList<String>();
		fillItemList();
	}

	/**
	 * @see frontend.AbstractFeatures.GUIFeature#action()
	 */
	@Override
	public void action(){
		
	}
	
	public abstract void fillItemList();
	
	public abstract void doDropDownClickAction(String chosen);

	/**
	 * @see frontend.AbstractFeatures.GUIFeature#makeTool()
	 */
	@Override
	public Group makeTool() {
		ComboBox<String> cb = new ComboBox<String>();
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
		cb.setPromptText(myPromptText);
		g.getChildren().add(cb);
		return g;
	}
}
