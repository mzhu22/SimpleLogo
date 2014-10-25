package frontend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static frontend.Turtle.IMAGE_WIDTH;
import static frontend.Turtle.IMAGE_HEIGHT;


public class Stamp extends ImageView{

	public Stamp(double x, double y, double direction, Image im){
		super(im);
		this.setX(x - IMAGE_WIDTH/2);
		this.setY(y - IMAGE_HEIGHT/2);
		this.setRotate(-direction + 90);
		this.setFitHeight(IMAGE_HEIGHT);
		this.setFitWidth(IMAGE_WIDTH);
	}
}
