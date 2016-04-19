
public class SaveGame extends CSV{
	
	//list of the names in csv file
	//might add more things as the game gets more complicated
	static final int name = 0;
	static final int maxScores = 1;
	static final int hLevel = 2;
	
	//saveGame is static cause there is only one. 
	static SaveGame s = new SaveGame();
	//static arrays of the columns (because there is only one saveGame.csv)
	static String names[] = s.getAllNames();
	static int[] scores = s.getAllScores();
	static String[] highestLevel = s.getLevel();

	public SaveGame() {
		//file needs to be in the same folder or give the path of the file
		super("saveGame.csv");
	}
	
	/**
	 * this method gets all the score
	 * NOTE will return error if score is not a int
	 * @return a int array of all score
	 */
	public int[] getAllScores(){
		String[] score = this.readColumn(maxScores,true);
		int[] returnArray = new int[score.length];
		//might move this block into its own method if more things are ints or might make another method in the super class
		for(int i = 0; i < score.length; i++){
			returnArray[i] = Integer.parseInt(score[i]);
		}
		return returnArray;
	}
	/**
	 * this method gets all names in the saveGame.csv
	 * @return string array of all names
	 */
	public String[] getAllNames(){
		return this.readColumn(name,true);
	}
	/**
	 * this method changes 'Name' in the given row
	 * @param newName the new Name to replace the old one
	 * @param row the row of the location
	 */
	public void setName(String newName, int row){
		s.editColumn(newName, row, name);
	}
	/**
	 * this method changes the 'Score' in the given row
	 * @param newScore the new score to replace the old
	 * @param row the row of the location
	 */
	public void setScore(int newScore,int row){
		s.editColumn("" + newScore, row, maxScores);
	}
	/**
	 * this method changes the 'Level' in the given row
	 * @param newLevel the new level to replace the old
	 * @param row the row of the location
	 */
	public void setLevel(int newLevel, int row){
		s.editColumn("" + newLevel, row, hLevel);
	}
	/**
	 * get the 'Highest Level' column
	 * @return a string array of levels
	 */
	public String[] getLevel(){
		return this.readColumn(hLevel,true);
	}
	/**
	 * this method gets the average score
	 * @return a float of the average score
	 */
	public float getAverage(){
		float sum = 0;
		for(int i = 0; i < scores.length; i++){
			sum = sum + scores[i];
		}
		return sum/scores.length;
	}
	
	
	//testing purpose
	public static void main(String args[])
	  {	
		for(int i = 0; i < scores.length;i++){
			System.out.println(names[i]);			
			System.out.println(scores[i]);
		}
		//String[] a = {"player","12312"};
		//s.addRow(a);
		//String[][] all = s.getAllRows();
		//System.out.println(all[1][1]);
		//System.out.println(all[1][0]);
		//System.out.println(s.getNumRows());
		//s.clearAllRows();System.out.println(s.numRows);
	  }
	

}
