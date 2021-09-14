package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class AnswerList {
	public static HashMap<String,String> getAnswerList(){
		HashMap<String,String> map = new HashMap<>();
		String [] helper = new String[2];
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream("C:\\Users\\CHANDRA\\eclipse-workspace\\assingment_qualicoach\\src\\main\\java\\resources\\quizAnswers.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner readFile = new Scanner(fis);
		while(readFile.hasNext()) {
			String line = readFile.nextLine();
			helper[0] = line.split("-")[0].trim();
			helper[1] = line.split("-")[1].trim();
			map.put(helper[0], helper[1]);
		}
		
		return map;
	}
}
