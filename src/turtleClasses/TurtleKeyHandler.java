package turtleClasses;

import java.util.HashMap;
import java.util.Map;

import frontend.PaneUpdater;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import SLogoControllers.InputController;

/**
 * This class represents a key handler for turtles on the screen.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class TurtleKeyHandler implements EventHandler<KeyEvent>{

	private TurtleMover myMover;
	private PaneUpdater myPaneUpdater;
	
	/**
	 * Map of keys to their command.
	 */
	private final static Map<KeyCode, String> ARROW_KEYS = new HashMap<KeyCode, String>()
			{
				//for serialization
				private static final long serialVersionUID = 1L;

			{
				put(KeyCode.UP, "fd 50");
				put(KeyCode.DOWN, "fd -50");
				put(KeyCode.LEFT, "left 10");
				put(KeyCode.RIGHT, "right 10");
			}};;
			
	/**
	 * Constructor.		
	 * 
	 * @param mover The turtle mover.
	 * @param pu The pane updater.
	 */
	public TurtleKeyHandler(TurtleMover mover, PaneUpdater pu){
		this.myMover = mover;
		this.myPaneUpdater = pu;
	}

	/**
	 * Checks whether the key pressed is one with an actual command.
	 * If so, calls upon the mover to execute that command.
	 */
	@Override
	public void handle(KeyEvent event) {
		boolean shouldMove = false;
		InputController ic = new InputController();
		KeyCode kc = event.getCode();
		if(TurtleKeyHandler.ARROW_KEYS.containsKey(kc))
		{
			ic.giveInput(TurtleKeyHandler.ARROW_KEYS.get(kc));
			shouldMove = true;
		}

		if(shouldMove)
		{
			myMover.startDrawing(ic.getInstructions());
			this.myPaneUpdater.updateAll();
		}
		
	}

}