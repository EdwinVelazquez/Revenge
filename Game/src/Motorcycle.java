
public class Motorcycle extends Character{

	static String filename = "Images/Character/Motorcycle/motorcycle";
	static String extension = ".png";
	int speed = 10;
	int turnSpeed = 10; //this speed is used for turning to make it smooth
	int life = 100; 
	public Motorcycle() {
		super(filename, extension,700, 400, 1, 3,4);
		// TODO Auto-generated constructor stub
	}
	public void pressA1(boolean p){
		if(p){
			if(speed < 20){
				speed++;
			}
		}
		else {
			if(speed > 10){
				speed--;
			}
		}
	}
	public void moveRt(){
		super.moveRt(speed);
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}

}
