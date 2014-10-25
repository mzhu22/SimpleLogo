package frontend.ConcreteFeatures;

import java.util.function.Predicate;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import frontend.SLogoCanvas;
import frontend.AbstractFeatures.GUIFeatureWithButton;

public class ClearCanvasButton extends GUIFeatureWithButton {

	protected Canvas myCanvas;
	
	public ClearCanvasButton(double x, double y, String buttonName, Canvas canvas) {
		super(x, y, buttonName);
		myCanvas = canvas;
	}

	@Override
	public void action() {
		((SLogoCanvas) myCanvas).changeBackground(Color.WHITE);
		((SLogoCanvas)myCanvas).getHolder().getChildren().removeIf(new Predicate<Object>(){

			@Override
			public boolean test(Object t) {
				return t instanceof Line;
			}
			
		});

	}

}
