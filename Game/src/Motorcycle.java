
public class Motorcycle extends Character{

	static String filename = "Images/Character/Motorcycle/motorcycle";
	static String extension = ".png";
	int speed = 10;
	int life = 100; 
	public Motorcycle() {
		super(filename, extension,700, 400, 1, 3,4);
		// TODO Auto-generated constructor stub
	}
	public void pressA1(boolean p){
		if(p){
			speed = 20;
		}
		else speed = 10;
	}
	public void moveRt(){
		super.moveRt(speed);
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}

}
