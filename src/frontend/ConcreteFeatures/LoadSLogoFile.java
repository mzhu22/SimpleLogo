package frontend.ConcreteFeatures;

import static frontend.GUIMaker.EPU;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import SLogoControllers.InputController;
import frontend.PaneUpdater;
import frontend.Translator;
import frontend.TurtleMover;
import frontend.AbstractFeatures.SLogoButton;

/**
 * This class represents a button that allows the user
 * to open a logo file from a folder and run it.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class LoadSLogoFile extends SLogoButton {

	private PaneUpdater myPaneUpdater;
	private TurtleMover myMover;
	private Translator myTranslator;
	
	/**
	 * 
	 * @see SLogoButton#GUIFeatureWithButton(double, double, String)
	 * @param mover The TurtleMover to run the commands.
	 * @param pu The PaneUpdater to update the panes based on the file's commands.
	 * @param t The Translator to translate the text file.
	 */
	public LoadSLogoFile(double x, double y, String buttonName, TurtleMover mover, PaneUpdater pu, Translator t) {
		super(x, y, buttonName);
		this.myPaneUpdater = pu;
		this.myMover = mover;
		this.myTranslator = t;
	}

	/**
	 * {@inheritDoc}
	 * When the button is clicked, create a new FileChooser
	 * with an extension filter to .logo. Get the chosen file and
	 * run it like a normal input. Throws a SLogoException
	 * if the file cannot be found.
	 */
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
				EPU.display("Bad file", true);
			}
        	
        	InputController ic = new InputController(myTranslator);
			ic.giveInput(input);
			this.myMover.startDrawing(ic.getInstructions());
			this.myPaneUpdater.updateAll();
        }
	}

}
