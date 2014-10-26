package frontend.AbstractFeatures;

import static frontend.AbstractFeatures.SLogoButton.BUTTON_WIDTH;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;

/**
 * This class represents a GUIFeature that uses a drop-down menu to interact.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */
public abstract class SLogoDropDown extends GUIFeature {

	protected List<String> myItems;
	protected String myPromptText;
	protected String myFolderName;
	
	/**
	 * Constructor.
	 * 
	 * @see GUIFeature#GUIFeature(double, double)
	 * @param prompt The string that the drop down should originally say when created.
	 */
	public SLogoDropDown(double x, double y, String prompt, String folder) {
		super(x, y);
		myPromptText = prompt;
		myItems = new ArrayList<String>();
		myFolderName = folder;
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
	public void fillItemList()
	{
		File[] files = new File(this.myFolderName).listFiles();

		for (File file : files) {
			myItems.add(file.toString().substring(
					file.toString().indexOf(this.myFolderName) + this.myFolderName.length(),
					file.toString().length()));
		}
	}

	/**
	 * Defines the action that will occur when the user
	 * selects an item from the drop down.
	 * 
	 * @param chosen The String that represents the item chosen.
	 */
	protected abstract void doDropDownClickAction(String chosen);

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
