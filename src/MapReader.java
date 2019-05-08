//Written by Dr. Kow
//Takes in csv files and interprets them

import java.util.*;
import java.io.*;

public class MapReader {
	//Returns a rotated 2D array - the roles of the primary and secondary indices are swapped in the returned array.
	public static int[][] rotate(int[][] a) {
		int[][] b = new int[a[0].length][a.length];
		for(int y = 0; y < a.length; y++) {
			for(int x = 0; x < a[y].length; x++) {
				b[x][y] = a[y][x];
			}
		}
		return b;
	}

	//Reads a 2D array of int values from a CSV file.
	public static int[][] readFromCSV(File file) {
		try {
			//Start scanning the file.
			Scanner in = new Scanner(file);

			//Get a list of all non-blank lines.
			ArrayList<String> lines = new ArrayList<String>();
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if (!line.trim().equals("")) lines.add(line);
			}

			//Make an array of that size
			int[][] ret = new int[lines.size()][];

			//Parse each line and put it in the int array.
			for(int i = 0; i < lines.size(); i++) {
				String[] tokens = lines.get(i).split(",", -1);
				ret[i] = new int[tokens.length];
				for(int j = 0; j < tokens.length; j++) {
					ret[i][j] = Integer.parseInt(tokens[j].trim());
				}
			}

			in.close(); //important - close file when done.

			return ret;
		}
		catch(Exception e) {
			System.out.println("Problem when trying to read the file." + e);
			return null;
		}
	}
}
