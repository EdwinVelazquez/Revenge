/**
 * this class is the background for the introduction and select screen
 * @author josuerojas
 *
 */
public class Background extends Animation{

	public Background() {
		super("Images/Background/background_",5, 101, ".jpg");

	}
	public Background(int duration) {
		super("Images/Background/background_",duration, 101, ".jpg");
	}

}
