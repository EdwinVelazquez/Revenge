import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * this class handles csv files similar to the python package
 * for now it will have basic methods (just read on existing file.)
 ***************************************************
 *To Do
 *edit to csv
 **add columns?
 ***************************************************
 *NOTE:
 *this only does basic reading of a csv file
 ***************************************************
 ***************************************************
 * @author josuerojas
 */
public class CSV {
	
	String fileName; //is the whole location, if it is not in the same folder
	String splitBy; //what you are going to split this by
	BufferedReader buffRead = null;
	BufferedWriter buffWrite = null;
	int numColumns; //might not need this
	
	/**
	 * constructor
	 * @param fileName the location of the file 
	 * @param splitBy what the csv is split by
	 */
	public CSV(String fileName, String splitBy){
		this.fileName = fileName;
		this.splitBy = splitBy;
		this.numColumns = getNumColumns();
	}
	/**
	 * other constructor where the default splitBy is ","
	 * @param fileName the location of the file
	 */
	public CSV(String fileName){
		this.fileName = fileName;
		this.splitBy = ",";
		this.numColumns = getNumColumns();
	}
	/**
	 * this method is needed for getting just a column
	 * this method gets the number of columns in a csv file
	 * @return the number of columns 
	 */
	public int getNumColumns(){
		int returnInt = 0;
		try{
			buffRead = new BufferedReader(new FileReader(fileName));
			//does not check if null so make sure its not null or add and if to check
			return buffRead.readLine().split(splitBy).length;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffRead != null) {
				try {
					buffRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return returnInt;
	}
	
	
	/**
	 * this method returns a String[] of the row in a csv file
	 * assumes the row exist *NEED TO TEST THIS
	 * @param row which row to return
	 * @return a String array of what the row contains, returns {""} if nothing is there
	 */
	public String[] readRow(int row){
		String line = ""; //represents the line
		//if(row < 0){
			//return line.split(",");
		//}
		try{
			buffRead = new BufferedReader(new FileReader(fileName));
			int lineNum = 0; //the line number
			while ((line = buffRead.readLine()) != null) {
				if(lineNum == row){ //add an if to avoid going through the whole file and row doesn't exist
					return line.split(splitBy);
				}
				lineNum++; 
			}
		}
		//exception
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (buffRead != null) {
			try {
				buffRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		return line.split(",");
	}
	/**
	 * this method gets the column from a csv file
	 * @param column the column number (starting with 0)
	 * @return a String[] of what the column contains
	 */
	public String[] readColumn(int column){
		String line = "";
		String returnStringA = "" ; //this will contain all the words in the columns
		//String split = "";
		try{
			buffRead = new BufferedReader(new FileReader(fileName));
			line = buffRead.readLine();
			//format reasons start by adding the first string without ","
			if(line != null){
				returnStringA = line.split(splitBy)[column];
			}
			while ((line = buffRead.readLine()) != null) {
				//have to check if the column exist or else...
				if(column < numColumns){
					returnStringA = returnStringA + "," + line.split(splitBy)[column];
				}
			}
		}
		//exception
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (buffRead != null) {
			try {
				buffRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		//String[] returnString = null;
		return  returnStringA.split(",");	
		}
	
	/**
	 * this method gets the column from a csv file without the first line
	 * @param column the column number (starting with 0)
	 * @return a String[] of what the column contains
	 */
	public String[] readColumn(int column, boolean skip1stLine){
		if(!skip1stLine){
			return readColumn(column);
		}
		String line = "";
		String returnStringA = ""; //this will contain all the words in the columns
		try{
			buffRead = new BufferedReader(new FileReader(fileName));
			//skip the first line
			buffRead.readLine();
			line = buffRead.readLine();
			//format reasons start by adding the first string without ","
			if(line != null){
				returnStringA = line.split(splitBy)[column];
			}
			while ((line = buffRead.readLine()) != null) {
				//System.out.println(line);
				//have to check if the column exist or else...
				if(column < numColumns){
					returnStringA = returnStringA + "," + line.split(splitBy)[column];
				}
			}
		}
		//exceptions
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (buffRead != null) {
			try {
				buffRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		//test this on an empty string later
		return returnStringA.split(",");	
		}
	
	/*
	 *useless method for now.(may come back to this for another idea)
	/**
	 * this method gets the column from a csv file (with)out the first line if returnInt is true then tries to convert to integers
	 * Note this does wil return an error and will crash if it cannot be converted to integer
	 * @param column the column number (starting with 0)
	 * @param skip1stLine
	 * @param returnInt
	 * @return a Object[] of what the column contains an Object to avoid conflicts between String[] and int[]
	 *
	public Object[] readColumn(int column, boolean skip1stLine, boolean returnInt){
		if(!returnInt){
			return readColumn(column,skip1stLine);
		}
		
		String line = "";
		String returnStringA = ""; //this will contain all the words in the columns
		try{
			buff = new BufferedReader(new FileReader(fileName));
			int lineNum = 0; //the line number
			if(skip1stLine){
				buff.readLine();
			}
			while ((line = buff.readLine()) != null) {
				//System.out.println(line);
				//have to check if the column exist or else...
				if(column < numColumns){
					returnStringA = returnStringA + "," + line.split(splitBy)[column];
				}
			}
		}
		//exceptions
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (buff != null) {
			try {
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		String[] stringA = returnStringA.split(",");
		Object[] returnArray  = new Object[stringA.length];
		//convert to integer need to check integers
		for(int i = 0; i < stringA.length; i++){
			returnArray[i] = Integer.parseInt(stringA[i]);
		}
		//test this on an empty string later
		return returnArray;
		}
	*/
	
	/**
	 * this method adds a row to a csv file
	 * @param input the row you want to add to the csv
	 * @throws IOException 
	 */
	public void addRow(String[] input){
		//in order to write put another row the input must have tha same columns as the csv
		if(input.length == numColumns){
			try {
				//use the append mode in FileWriter
				buffWrite = new BufferedWriter(new FileWriter(fileName,true));
				buffWrite.newLine();
				buffWrite.append(String.join(",",input));
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				if(buffWrite != null){
					try{
						buffWrite.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
	

}
