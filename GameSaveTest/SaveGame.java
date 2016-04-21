import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * this class extends CSV.java. This is suppose to handle saving data to a CSV
 * file called 'saveGame' most of the methods are static because there only
 * exist one CSV file for the save game.
 * 
 * @author josuerojas
 * 
 */
public class SaveGame extends CSV {

	// list of the names in csv file
	// might add more things as the game gets more complicated
	static final int name = 0;
	static final int maxScores = 1;
	static final int hLevel = 2;

	// saveGame is static cause there is only one.
	static SaveGame s = new SaveGame();

	// static arrays of the columns (because there is only one saveGame.csv)
	// static String names[] = s.getAllNamesCSV();
	// static int[] scores = s.getAllScoresCSV();
	// static String[] highestLevel = s.getAllLevelCSV();

	public SaveGame() {
		// file needs to be in the same folder or give the path of the file
		super("saveGame.csv");
	}

	/**
	 * this method gets all the score NOTE will return error if score is not a
	 * int
	 * 
	 * @return a int array of all score
	 */
	public static int[] getAllScores() {
		String[] score = s.readColumn(maxScores, true);
		int[] returnArray = new int[score.length];
		// might move this block into its own method if more things are ints or
		// might make another method in the super class
		for (int i = 0; i < score.length; i++) {
			returnArray[i] = Integer.parseInt(score[i]);
		}
		return returnArray;
	}

	/**
	 * this method gets all names in the saveGame.csv
	 * 
	 * @return string array of all names
	 */
	public static String[] getAllNames() {
		return s.readColumn(name, true);
	}

	/**
	 * get the 'Highest Level' column
	 * 
	 * @return a string array of levels
	 */
	public static String[] getAllLevel() {
		return s.readColumn(hLevel, true);
	}

	/**
	 * this method changes 'Name' in the given row
	 * 
	 * @param newName
	 *            the new Name to replace the old one
	 * @param row
	 *            the row of the location
	 */
	public static void setName(String newName, int row) {
		s.editColumn(newName, row, name);
	}

	/**
	 * this method changes the 'Score' in the given row. THIS NEEDS TO BE FIX TO SORT IT
	 * 
	 * @param newScore
	 *            the new score to replace the old
	 * @param row
	 *            the row of the location
	 */
	public static void setScore(int newScore, int row) {
		s.editColumn("" + newScore, row, maxScores);
	}

	/**
	 * this method changes the 'Level' in the given row
	 * 
	 * @param newLevel
	 *            the new level to replace the old
	 * @param row
	 *            the row of the location
	 */
	public static void setLevel(int newLevel, int row) {
		s.editColumn("" + newLevel, row, hLevel);
	}

	/**
	 * this method adds a new row to the saveGame.csv (not sorted). Use the addSorted() to keep the csv tidy.
	 * 
	 * @param input
	 *            the string array that will be inserted
	 */
	public static void addNewRow(String[] input) {
		s.addRow(input);
	}

	/**
	 * this method gets the average score
	 * 
	 * @return a float of the average score
	 */
	public static float getAverage() {
		int[] scores = s.getAllScores();
		float sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum = sum + scores[i];
		}
		return sum / scores.length;
	}

	/**
	 * This method adds a row but it puts it in sorted order from highest score to lowest
	 * 
	 * @param newRow the row inputing
	 */
	public static void addSorted(String[] newRow) {
		// this method will insert new row but sorted by highest score first
		// in order to write put another row the input must have the same
		// columns as the csv
		String[][] allRows = s.getAllRows();
		s.clearAllRows();
		boolean change = false;
		for(int i = 0; i < allRows[0].length;i++){
			System.out.println(allRows[0][i]);
		}
		s.addRow(allRows[0]); //add the first line
		
		for(int i = 1; i < allRows.length; i++){
			System.out.println(allRows.length);
			if(!change && Integer.parseInt(allRows[i][s.maxScores]) <= Integer.parseInt(newRow[maxScores])){
				change = true; //make it escape the infinite loop	
				s.addRow(newRow); //add the new row
				i--; //so it can write all rows
			}
			else{
				s.addRow(allRows[i]);
			}
		}
		

	}

	/**
	 * this method edits the score in a row and sorts it.
	 * @param score new score (in a game this should only change when the score is higher)
	 * @param row the location of the row that is going to be edited. 
	 */
	public static void setScoreSorted(int score, int row){
		String[] newRow = s.readRow(row); //get row that is going to change
		newRow[maxScores] = "" + score; //change the score
		s.removeRow(row); //remove the row
		s.addSorted(newRow);
		
	}
	// testing purpose
	public static void main(String args[]) {
		for (int i = 0; i < s.numRows - 1; i++) {
			System.out.println(s.getAllNames()[i]);
		}
		String[] a = { "player", "100", "1" };
		//s.addSorted(a);
		s.setScoreSorted(9999, 10);
		// String[][] all = s.getAllRows();
		// System.out.println(all[1][1]);
		// System.out.println(all[1][0]);
		// System.out.println(s.getNumRows());
		// s.clearAllRows();System.out.println(s.numRows);
	}

}
