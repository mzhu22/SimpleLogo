package frontend.ConcreteFeatures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import SLogoControllers.InputController;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import errorsAndExceptions.ErrorPopUp;
import frontend.PaneUpdater;
import frontend.Translator;
import frontend.TurtleMover;
import frontend.AbstractFeatures.GUIFeatureWithButton;

public class LoadSLogoFileButton extends GUIFeatureWithButton {

	private PaneUpdater myPaneUpdater;
	private TurtleMover myMover;
	private Translator myTranslator;
	
	public LoadSLogoFileButton(double x, double y, String buttonName, TurtleMover mover, PaneUpdater pu, Translator t) {
		super(x, y, buttonName);
		this.myPaneUpdater = pu;
		this.myMover = mover;
		this.myTranslator = t;
	}

	@Override
	public void action() {
		FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir") +"/examples/"));
        File file = fileChooser.showOpenDialog(new Stage());
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("SLogo File", "*.logo"));
        if(file != null && file.isFile()){
        	String input = "";
			try {
				input = new Scanner(file).useDelimiter("\\Z").next();
			} catch (FileNotFoundException e) {
				ErrorPopUp epu = new ErrorPopUp();
				epu.display("Bad file");
			}
        	
        	InputController ic = new InputController(myTranslator);
			ic.giveInput(input);
			this.myMover.startDrawing(ic.getInstructions());
			this.myPaneUpdater.updateAll();
        }
	}

}
