package frontend;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class TestButton extends GUIFeature{

	private Button test;
	
	public TestButton(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		System.out.println("Hello");
		System.out.println("sdg");
		test.setDisable(true);
		
	}

	@Override
	public Node makeTool() {
		test = new Button("Hello");
		
		test.setOnMouseClicked(new EventHandler<MouseEvent>(){
			
			@Override
			public void handle(MouseEvent event) {
				action();
			}
		});
		
		
		
		test.setLayoutX(myX);
		test.setLayoutY(myY);
		
		return test;
		
	}

}
