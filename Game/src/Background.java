/**
 * this class is the background for the introduction and select screen
 * @author josuerojas
 *
 */
public class Background extends Animation{

	public Background() {
		//super("Images/StickFigure/stick_",5,5,".gif");
		super("Images/Background/background_",5, 101, ".jpg");

	}
	public Background(int duration) {
		super("Images/Background/background_",duration, 101, ".jpg");
	}
	public Background(int width, int height) {
		super("Images/Background/background_",5, 101, ".jpg",width,height);
	}

}
