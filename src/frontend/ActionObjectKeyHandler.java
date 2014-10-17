package frontend;

import SLogoControllers.InputController;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class ActionObjectKeyHandler implements EventHandler<KeyEvent>{

	private ActionObjectMover myMover;
	
	public ActionObjectKeyHandler(ActionObjectMover mover){
		myMover = mover;
	}

	@Override
	public void handle(KeyEvent event) {
		boolean shouldDraw = false;
		InputController ic = new InputController();
		
		if(event.getCode() == KeyCode.UP){
			ic.giveInput("fd 50");
			shouldDraw = true;
		}
		if(event.getCode() == KeyCode.DOWN){
			ic.giveInput("fd -50");
			shouldDraw = true;
		}
		if(event.getCode() == KeyCode.LEFT){
			ic.giveInput("left 10");
			shouldDraw = true;
		}
		if(event.getCode() == KeyCode.RIGHT){
			ic.giveInput("right 10");
			shouldDraw = true;
		}
		
		
		if(shouldDraw) myMover.startDrawing(ic.getInstructions());
		
	}

}
