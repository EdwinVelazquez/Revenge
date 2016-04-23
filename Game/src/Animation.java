

import java.awt.*;

public class Animation {

	Image[] image;
	
	int current = 0;
	int numImage;
	
	int duration;
	int countdown;
	
	
	
	public Animation(String name, int duration, int n, String extension){
		image = new Image[n];
		numImage = n;
		this.duration = duration;
		countdown = duration;
		
		for(int i = 0; i < n; i++){
			image[i] = Toolkit.getDefaultToolkit().getImage(name + i + extension);
			//System.out.println(name + i + extension);
		}
	}
	
	public Image getImage(){
		countdown--;
		if(countdown == 0){
			countdown = duration;
			current++;
			if(current == image.length){
				current = 0;
			}
		}
		return image[current];
	}
	
	public Image getStaticImage(){
		
		return image[0];
		
	}
	 public void draw(Graphics g,int x, int y) {
		 if (getImage() != null){ 
			 g.drawImage(getImage(), x, y, null);
		 }
	 }
		
	
}
