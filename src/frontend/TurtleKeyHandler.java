package frontend;

import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import SLogoControllers.InputController;

public class TurtleKeyHandler implements EventHandler<KeyEvent>{

	private TurtleMover myMover;
	private PaneUpdater myPaneUpdater;
	private final static Map<KeyCode, String> ARROW_KEYS = new HashMap<KeyCode, String>()
			{{
				put(KeyCode.UP, "fd 50");
				put(KeyCode.DOWN, "fd -50");
				put(KeyCode.LEFT, "left 10");
				put(KeyCode.RIGHT, "right 10");
			}};;
			
	public TurtleKeyHandler(TurtleMover mover, PaneUpdater pu){
		this.myMover = mover;
		this.myPaneUpdater = pu;
	}

	@Override
	public void handle(KeyEvent event) {
		boolean shouldDraw = false;
		InputController ic = new InputController();
		KeyCode kc = event.getCode();
		if(this.ARROW_KEYS.containsKey(kc))
		{
			ic.giveInput(this.ARROW_KEYS.get(kc));
			shouldDraw = true;
		}

		if(shouldDraw)
		{
			myMover.startDrawing(ic.getInstructions());
			this.myPaneUpdater.updateAll();
		}
		
	}

}