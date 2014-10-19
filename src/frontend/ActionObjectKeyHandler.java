package frontend;

import java.util.HashMap;
import java.util.Map;

import SLogoControllers.InputController;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class ActionObjectKeyHandler implements EventHandler<KeyEvent>{

	private ActionObjectMover myMover;
	private final static Map<KeyCode, String> ARROW_KEYS = new HashMap<KeyCode, String>()
			{{
				put(KeyCode.UP, "fd 50");
				put(KeyCode.DOWN, "fd -50");
				put(KeyCode.LEFT, "left 10");
				put(KeyCode.RIGHT, "right 10");
			}};;
			
	public ActionObjectKeyHandler(ActionObjectMover mover){
		myMover = mover;
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
		}
		
	}

}