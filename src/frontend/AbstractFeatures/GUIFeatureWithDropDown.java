/**
 * This class represents a GUIFeature that uses a drop-down menu to interact.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */
package frontend.AbstractFeatures;

import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_WIDTH;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public abstract class GUIFeatureWithDropDown extends GUIFeature {

	protected List<String> myItems;
	protected String myPromptText;
	
	/**
	 * @see GUIFeature#GUIFeature(double, double)
	 * 
	 * @param prompt The string that the drop down should originally say when created.
	 */
	public GUIFeatureWithDropDown(double x, double y, String prompt) {
		super(x, y);
		myPromptText = prompt;
		myItems = new ArrayList<String>();
		fillItemList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void action(){
		
	}
	
	/**
	 * Get the list of items from a directory and store it.
	 */
	public abstract void fillItemList();
	
	/**
	 * Do something with the chosen item of the box.
	 * @param chosen The path of the file chosen.
	 */
	public abstract void doDropDownClickAction(String chosen);

	/**
	 * {@inheritDoc}
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
